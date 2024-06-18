package com.example.appDemo.fullStackAppDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="cartdetails")
@NamedNativeQuery(name="deletePerticularDataFromCart",query="Delete from cartdetails WHERE autoid IN"
		+"(SELECT autoid " + 
		"FROM (SELECT autoid," + 
		"ROW_NUMBER() OVER (partition BY imageid) AS RowNumber " + 
		"FROM cartdetails) AS T " + 
		"WHERE T.RowNumber=:rowNumber AND imageid = :imageID)")
public class cartEntity {
	@Column(name="imageid",nullable=false)
	private long imageID;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="autoid")
	private long autoId;
	@Column(name="emailid",nullable=false)
	private String emailID;
	@Column(name="imageurl",nullable=false)
	private String image;
	@Column(name="price",nullable=false)
	private String price;
	@Column(name="description",nullable=false)
	private String description;
	@Column(name="rating",nullable=false)
	private String rating;
	@Column(name="peoplerated",nullable=false)
	private String peopleRated;
	public cartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartEntity(long imageID, long autoId, String emailID, String image, String price, String description,
			String rating, String peopleRated) {
		super();
		this.imageID = imageID;
		this.autoId = autoId;
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
	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
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
		return "cartEntity [imageID=" + imageID + ", autoId=" + autoId + ", emailID=" + emailID + ", image=" + image
				+ ", price=" + price + ", description=" + description + ", rating=" + rating + ", peopleRated="
				+ peopleRated + "]";
	}
}
