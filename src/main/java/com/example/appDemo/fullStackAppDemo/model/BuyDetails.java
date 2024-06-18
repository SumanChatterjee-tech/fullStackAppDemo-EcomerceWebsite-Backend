package com.example.appDemo.fullStackAppDemo.model;

public class BuyDetails {
	private long imageID;
	private String emailID;
	private int count;
	private String price;
	private String description;
	private String imageUrl;
	private boolean isBought=false;
	public BuyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyDetails(long imageID, String emailID, int count, String price, String description, String imageUrl,
			boolean isBought) {
		super();
		this.imageID = imageID;
		this.emailID = emailID;
		this.count = count;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.isBought = isBought;
	}
	public long getImageID() {
		return imageID;
	}
	public void setImageID(long imageID) {
		this.imageID = imageID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	@Override
	public String toString() {
		return "BuyDetails [imageID=" + imageID + ", emailID=" + emailID + ", count=" + count + ", price=" + price
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", isBought=" + isBought + "]";
	}
}
