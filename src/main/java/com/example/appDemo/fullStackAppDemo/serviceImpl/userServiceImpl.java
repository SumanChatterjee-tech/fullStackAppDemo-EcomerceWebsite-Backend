package com.example.appDemo.fullStackAppDemo.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.appDemo.fullStackAppDemo.entity.BuyEntity;
import com.example.appDemo.fullStackAppDemo.entity.UserEntity;
import com.example.appDemo.fullStackAppDemo.entity.cartEntity;
import com.example.appDemo.fullStackAppDemo.entity.feedBackEntity;
import com.example.appDemo.fullStackAppDemo.exception.UserRelatedException;
import com.example.appDemo.fullStackAppDemo.exception.cartIsEmptyException;
import com.example.appDemo.fullStackAppDemo.model.BuyDetails;
import com.example.appDemo.fullStackAppDemo.model.Changepassword;
import com.example.appDemo.fullStackAppDemo.model.cartDetails;
import com.example.appDemo.fullStackAppDemo.model.sendFeedBack;
import com.example.appDemo.fullStackAppDemo.repository.UserRepository;
import com.example.appDemo.fullStackAppDemo.repository.buyRepository;
import com.example.appDemo.fullStackAppDemo.repository.cartRepository;
import com.example.appDemo.fullStackAppDemo.repository.feedBackRepository;
import com.example.appDemo.fullStackAppDemo.service.userService;
import com.example.appDemo.fullStackAppDemo.shared.userDTO;
import com.example.appDemo.fullStackAppDemo.shared.Utills;

@Service
public class userServiceImpl implements userService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	Utills utills;
	@Autowired
	BCryptPasswordEncoder bycryptPasswordEncoder;
	@Autowired
	cartRepository cartRepo;
	@Autowired
	buyRepository buyRepo;
	@Autowired
	feedBackRepository feedBackRepo;
	@Autowired
	EntityManager em;
	@Override
	public userDTO createUser(userDTO userdto) throws UserRelatedException {
		UserEntity userEntity = new UserEntity();
		userDTO returnValue = new userDTO();
		UserEntity checkForDuplicateUser = userRepo.findByEmail(userdto.getEmail());
		if(checkForDuplicateUser != null) throw new UserRelatedException("User Already Present");
		ModelMapper modelMapper = new ModelMapper();
		userEntity = modelMapper.map(userdto, UserEntity.class);
		userEntity.setUserId(utills.generateUserId(30));
		userEntity.setEncryptedPassword(bycryptPasswordEncoder.encode(userdto.getPassword()));
		UserEntity storedUserEntity = userRepo.save(userEntity);
		returnValue = modelMapper.map(storedUserEntity, userDTO.class);
		//BeanUtils.copyProperties(storedUserEntity, returnValue);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepo.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(),true,
				true,true,
				true,new ArrayList<>());
	}

	@Override
	public long getCartDetails(String emailID) throws cartIsEmptyException {
		long cuurentCartCount = cartRepo.findCartDetailsByEmailId(emailID);
		//if(cuurentCartCount == null) throw new cartIsEmptyException("Cart is Empty for you!");
		return cuurentCartCount;
	}

	@Override
	public cartDetails addTocart(String emailID, cartDetails cart) {
		ModelMapper modelMapper = new ModelMapper();
		cartEntity cartEn = modelMapper.map(cart, cartEntity.class);
		cartEn.setEmailID(emailID);
		cartEntity cartEntity = cartRepo.save(cartEn);
		cartDetails returnValue = modelMapper.map(cartEntity, cartDetails.class);
		return returnValue;
	}

	@Override
	public List<cartEntity> getCartDetailsToShowCart(String emailID) {
		List<cartEntity> cartEntity = cartRepo.findAllCartDetailsByUserId(emailID);
		//if(cuurentCartCount == null) throw new cartIsEmptyException("Cart is Empty for you!");
		return cartEntity;
	}

	@Override
	@Transactional
	@Modifying
	public boolean deleteItemsFromcart(long imageID, int countOfItem) {
		TypedQuery<cartEntity> query = (TypedQuery<cartEntity>) em.createNamedQuery("deletePerticularDataFromCart");
		query.setParameter("rowNumber", countOfItem);
		query.setParameter("imageID", imageID);
		query.executeUpdate();
		return true;
	}

	@Override
	public userDTO getUser(String email) {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepo.findByEmail(email);
		ModelMapper modelMapper = new ModelMapper();
		userDTO returnValue = modelMapper.map(userEntity, userDTO.class);
		return returnValue;
	}

	@Override
	public void addBoughtItems(String emailID, BuyDetails buyDeatils) {
		ModelMapper modelMapper = new ModelMapper();
		BuyEntity buyEntity = modelMapper.map(buyDeatils,BuyEntity.class);
		System.out.println(buyEntity);
		BuyEntity checkIfIDPresentalready = buyRepo.findByImageID(buyDeatils.getImageID());
		if(checkIfIDPresentalready == null) {
			buyRepo.save(buyEntity);
		}
		else {
			//String totalPrice = Double.toString((Double.parseDouble(buyEntity.getPrice())+Double.parseDouble((checkIfIDPresentalready.getPrice()))));
			int totalCount = checkIfIDPresentalready.getCount() +  buyEntity.getCount();
			buyRepo.updateBuyRepository(totalCount,emailID, buyEntity.getImageID());
		}
		//Tried out Optional API
//		checkIfIDPresentalready.ifPresent(value->{
//			String totalPrice = Double.toString((Double.parseDouble(buyEntity.getPrice())+Double.parseDouble((value.getPrice()))));
//			int totalCount = value.getCount() +  buyEntity.getCount();
//			buyRepo.updateBuyRepository(totalCount,totalPrice,userID, buyEntity.getImageID());
//		});
//		checkIfIDPresentalready.
	}

	@Override
	public List<BuyDetails> getAllBoughtItem(String emailID) {
		ModelMapper modelMapper = new ModelMapper();
		List<BuyEntity> allEntities = buyRepo.findByEmailID(emailID);
		List<BuyDetails> returnValue = allEntities
		  .stream()
		  .map(entity -> modelMapper.map(entity, BuyDetails.class))
		  .collect(Collectors.toList());
		return returnValue;
	}

	@Override
	public boolean deleteAllFromCartByImageID(long imageID) {
		 cartRepo.deleteFromCartByImageID(imageID);
		 return true;
	}

	@Override
	public sendFeedBack saveFeedBackDetails(sendFeedBack feedbackDetails) {
		ModelMapper modelMapper = new ModelMapper();
		feedBackEntity feedbackEn = modelMapper.map(feedbackDetails, feedBackEntity.class);
		feedBackEntity savedEntity = feedBackRepo.save(feedbackEn);
		sendFeedBack returnValue = modelMapper.map(savedEntity, sendFeedBack.class);
		return returnValue;
	}

	@Override
	public List<sendFeedBack> getAllReviews() {
		ModelMapper modelMapper = new ModelMapper();
		List<feedBackEntity> feedbackEn = feedBackRepo.getAllReviews();
		List<sendFeedBack> returnValue = feedbackEn.stream().map(entity->modelMapper.map(entity, sendFeedBack.class))
		.collect(Collectors.toList());
		return returnValue;
	}

	@Override
	public boolean checkForExsistanceOfUser(String emailID) throws UserRelatedException {
		UserEntity userEntity = userRepo.findByEmail(emailID);
		if(userEntity == null)throw new UserRelatedException("User not found");
		return true;
	}

	@Override
	public boolean changePassword(Changepassword changePwd) throws UserRelatedException {
		UserEntity userEntity = userRepo.findByEmail(changePwd.getEmail());
		if(bycryptPasswordEncoder.matches(changePwd.getPassword(), userEntity.getEncryptedPassword())) {
			throw new UserRelatedException("Old and New password can not be same");
		}
		userRepo.changePassword(bycryptPasswordEncoder.encode(changePwd.getPassword()), changePwd.getEmail());
		return true;
	}
	
}
