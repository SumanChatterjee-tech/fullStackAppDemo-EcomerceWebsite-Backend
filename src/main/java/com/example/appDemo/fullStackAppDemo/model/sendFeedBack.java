package com.example.appDemo.fullStackAppDemo.model;

public class sendFeedBack {
	private String fromEmail;
	private String comments;
	private double rating;
	private String feedbackerName;
	public sendFeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sendFeedBack(String fromEmail, String comments, double rating, String feedbackerName) {
		super();
		this.fromEmail = fromEmail;
		this.comments = comments;
		this.rating = rating;
		this.feedbackerName = feedbackerName;
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
		return "sendFeedBack [fromEmail=" + fromEmail + ", comments=" + comments + ", rating=" + rating
				+ ", feedbackerName=" + feedbackerName + "]";
	}
}
