package com.example.appDemo.fullStackAppDemo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.appDemo.fullStackAppDemo.email.EmailService;
import com.example.appDemo.fullStackAppDemo.entity.cartEntity;
import com.example.appDemo.fullStackAppDemo.exception.EmailSendingException;
import com.example.appDemo.fullStackAppDemo.exception.UserRelatedException;
import com.example.appDemo.fullStackAppDemo.exception.cartIsEmptyException;
import com.example.appDemo.fullStackAppDemo.model.BuyDetails;
import com.example.appDemo.fullStackAppDemo.model.Changepassword;
import com.example.appDemo.fullStackAppDemo.model.cartDetails;
import com.example.appDemo.fullStackAppDemo.model.userRegistrationModel;
import com.example.appDemo.fullStackAppDemo.model.userResponse;
import com.example.appDemo.fullStackAppDemo.service.userService;
import com.example.appDemo.fullStackAppDemo.shared.userDTO;
import com.example.appDemo.fullStackAppDemo.model.sendFeedBack;

@RestController

public class shoppingcartController {
	@Autowired
	userService userService;
	@Autowired
	EmailService emailservice;
	
	//create user for Registration
	@PostMapping(path="/createNewUser", consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public userResponse createUser(@RequestBody userRegistrationModel userRegModel) throws UserRelatedException {
		System.out.println(userRegModel);
		userResponse userResposne = new userResponse();
		ModelMapper modelMapper = new ModelMapper();
		userDTO userDto = modelMapper.map(userRegModel, userDTO.class);
		userDTO createdUser = userService.createUser(userDto);
		userResposne = modelMapper.map(createdUser, userResponse.class);
		return userResposne;
	}
	
	@GetMapping(path="/validateEmail/{email}")
	public String isEmailValid(@PathVariable String email) throws EmailSendingException{
		String otp =  emailservice.sendSimpleEmail(email);
		return otp;
	}
	
	@GetMapping(path="/getCartForUser/{emailID}")
	public long getCartItemDetails(@PathVariable String emailID) throws cartIsEmptyException {
		long currentcartCount= userService.getCartDetails(emailID);
		return currentcartCount;
	}
	
	@PostMapping(path="/addcartDetails/{emailID}")
	public cartDetails addToCart(@PathVariable String emailID, @RequestBody cartDetails cartDeatils){
		cartDetails cartDetails = userService.addTocart(emailID ,cartDeatils);
		return cartDetails;
	}
	
	@GetMapping(path="/showcartItems/{emailID}")
	public List<cartEntity> showcartItems(@PathVariable String emailID) throws cartIsEmptyException {
		List<cartEntity> cartEntity= userService.getCartDetailsToShowCart(emailID);
		return cartEntity;
	}
	
	@DeleteMapping(path="/deleteCartItems/{imageID}/{countOfItem}")
	public boolean deleteFromCart(@PathVariable long imageID,@PathVariable int countOfItem ) {
		return userService.deleteItemsFromcart(imageID,countOfItem);
	}
	
	@DeleteMapping(path="/deleteAll/{imageID}")
	public boolean deleteAll(@PathVariable long imageID) {
		return userService.deleteAllFromCartByImageID(imageID);
	}
	
	@GetMapping(path="/getUserDetails/{userEmail}")
	public userResponse userDetails(@PathVariable String userEmail) {
		userResponse userResposne = new userResponse();
		ModelMapper modelMapper = new ModelMapper();
		userResposne = modelMapper.map( userService.getUser(userEmail), userResponse.class);
		return userResposne;
	}
	@PostMapping(path="/addBoughtItem/{emailID}")
	public void addBoughtItem(@PathVariable String emailID, @RequestBody BuyDetails buyDeatils){
		userService.addBoughtItems(emailID,buyDeatils);
	}
	
	@GetMapping(path="/getAllBoughtItemsPerUserID/{emailID}")
	public List<BuyDetails> getAllBoughtItems(@PathVariable String emailID) {
		List<BuyDetails> buyDetails= userService.getAllBoughtItem(emailID);
		return buyDetails;
	}
	
	@PostMapping(path="/feedBackSubmission")
	public boolean sendFeedBack(@RequestBody sendFeedBack feedback) throws EmailSendingException{
		sendFeedBack feedBack = userService.saveFeedBackDetails(feedback);
		return emailservice.sendFeedBackMail(feedback);
	}
	
	@GetMapping(path="/getAllReviews")
	public List<sendFeedBack> getAllReviews() {
		List<sendFeedBack> sendFeedback = userService.getAllReviews();
		return sendFeedback;
	}
	
	@GetMapping(path="/forgotUserEmail/{emailID}")
	public boolean checkIfUserIsAnExsistingUser(@PathVariable String emailID) throws UserRelatedException{
		return userService.checkForExsistanceOfUser(emailID);
	}
	
	@PostMapping(path="/changePassword")
	public boolean changePassword(@RequestBody Changepassword changePwd) throws UserRelatedException{
		return userService.changePassword(changePwd);
	}
}
