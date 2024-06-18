package com.example.appDemo.fullStackAppDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buydetails")
public class BuyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long autoId;
	@Column(name="imageid",nullable=false)
	private long imageID;
	@Column(name="emailid",nullable=false)
	private String emailID;
	@Column(name="quantity",nullable=false)
	private int count;
	@Column(name="totalprice",nullable=false)
	private String price;
	@Column(name="imagedescription",nullable=false)
	private String description;
	@Column(name="isconfirmedbought",nullable=false)
	private boolean isBought=false;
	@Column(name="imageurl")
	private String imageUrl;
	public BuyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BuyEntity(long autoId, long imageID, String emailID, int count, String price, String description,
			boolean isBought, String imageUrl) {
		super();
		this.autoId = autoId;
		this.imageID = imageID;
		this.emailID = emailID;
		this.count = count;
		this.price = price;
		this.description = description;
		this.isBought = isBought;
		this.imageUrl = imageUrl;
	}
	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
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
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "BuyEntity [autoId=" + autoId + ", imageID=" + imageID + ", emailID=" + emailID + ", count=" + count
				+ ", price=" + price + ", description=" + description + ", isBought=" + isBought + ", imageUrl="
				+ imageUrl + "]";
	}	
}
