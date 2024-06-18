package com.example.appDemo.fullStackAppDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedbackdetails")
public class feedBackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long autoId;
	@Column(name="fromemail")
	private String fromEmail;
	@Column(name="comments")
	private String comments;
	@Column(name="rating")
	private double rating;
	@Column(name="feedbackername")
	private String feedbackerName;
	public feedBackEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public feedBackEntity(long autoId, String fromEmail, String comments, double rating, String feedbackerName) {
		super();
		this.autoId = autoId;
		this.fromEmail = fromEmail;
		this.comments = comments;
		this.rating = rating;
		this.feedbackerName = feedbackerName;
	}
	public long getAutoId() {
		return autoId;
	}
	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedbackerName() {
		return feedbackerName;
	}
	public void setFeedbackerName(String feedbackerName) {
		this.feedbackerName = feedbackerName;
	}
	@Override
	public String toString() {
		return "feedBackEntity [autoId=" + autoId + ", fromEmail=" + fromEmail + ", comments=" + comments + ", rating="
				+ rating + ", feedbackerName=" + feedbackerName + "]";
	}
}
