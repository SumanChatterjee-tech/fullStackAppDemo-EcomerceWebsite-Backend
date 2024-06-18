package com.example.appDemo.fullStackAppDemo.model;

public class cartDetails {
	private long imageID;
	private long autoID;
	private String emailID;
	private String image;
	private String price;
	private String description;
	private String rating;
	private String peopleRated;
	public cartDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartDetails(long imageID, long autoID, String emailID, String image, String price, String description,
			String rating, String peopleRated) {
		super();
		this.imageID = imageID;
		this.autoID = autoID;
		this.emailID = emailID;
		this.image = image;
		this.price = price;
		this.description = description;
		this.rating = rating;
		this.peopleRated = peopleRated;
	}
	public long getImageID() {
		return imageID;
	}
	public void setImageID(long imageID) {
		this.imageID = imageID;
	}
	public long getAutoID() {
		return autoID;
	}
	public void setAutoID(long autoID) {
		this.autoID = autoID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPeopleRated() {
		return peopleRated;
	}
	public void setPeopleRated(String peopleRated) {
		this.peopleRated = peopleRated;
	}
	@Override
	public String toString() {
		return "cartDetails [imageID=" + imageID + ", autoID=" + autoID + ", emailID=" + emailID + ", image=" + image
				+ ", price=" + price + ", description=" + description + ", rating=" + rating + ", peopleRated="
				+ peopleRated + "]";
	}
}
