package com.cvbank.security;

public class SecurityConstants {
    public static final String SECRET = "secre";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/signup";
    public static final String LOGOUT_URL = "/api/logout";
    public static final long EXPIRATION_TIME = 30*60000L;
}
