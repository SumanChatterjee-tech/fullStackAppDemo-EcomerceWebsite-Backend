package com.example.appDemo.fullStackAppDemo.security;

public class SecurityConstants {
	public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/createNewUser/**";
    public static final String EMAIL_VERIFICATION_URL = "/validateEmail/**";
    public static final String EMAIL_FEEDBACK_URL = "/feedBackSubmission/**";
    public static final String SHOW_FEEDBACKS_URL="/getAllReviews/**";
    public static final String FORGOT_PASSWORD_URL="/forgotUserEmail/**";
    public static final String CHANGE_PASSWORD_URL="/changePassword/**";
    public static final String H2_CONSOLE = "/h2-console/**";
   public static final String TOKEN_SECRET = "jf9i4jgu83nfl0jfu57ejf7"; // Lets put it to application.properties file
}
