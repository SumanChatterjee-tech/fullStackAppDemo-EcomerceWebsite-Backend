package com.example.appDemo.fullStackAppDemo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.appDemo.fullStackAppDemo.entity.cartEntity;
import com.example.appDemo.fullStackAppDemo.exception.UserRelatedException;
import com.example.appDemo.fullStackAppDemo.exception.cartIsEmptyException;
import com.example.appDemo.fullStackAppDemo.model.BuyDetails;
import com.example.appDemo.fullStackAppDemo.model.Changepassword;
import com.example.appDemo.fullStackAppDemo.model.cartDetails;
import com.example.appDemo.fullStackAppDemo.model.sendFeedBack;
import com.example.appDemo.fullStackAppDemo.shared.userDTO;

public interface userService extends UserDetailsService {
	public userDTO createUser(userDTO userdto) throws UserRelatedException;
	public long getCartDetails(String emailID) throws cartIsEmptyException;
	public cartDetails addTocart(String userID, cartDetails cart);
	public List<cartEntity> getCartDetailsToShowCart(String emailID);
	public boolean deleteItemsFromcart(long imageID, int countOfItem);
	public userDTO getUser(String email);
	public void addBoughtItems(String emailID, BuyDetails buyDeatils);
	public List<BuyDetails> getAllBoughtItem(String emailID);
	public boolean deleteAllFromCartByImageID(long imageID);
	public sendFeedBack saveFeedBackDetails(sendFeedBack feedbackDetails);
	public List<sendFeedBack> getAllReviews();
	public boolean checkForExsistanceOfUser(String emailID) throws UserRelatedException;
	public boolean changePassword(Changepassword changePwd) throws UserRelatedException;

}
