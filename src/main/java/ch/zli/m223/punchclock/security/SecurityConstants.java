package ch.zli.m223.punchclock.security;

import java.lang.module.FindException;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String LOGIN_URL = "/login";
    public static final String INDEX = "/index.html";
    public static final String ALL_HTML = "/*.html";
    public static final String ALL_JS = "/*.js";
    public static final String COMPANIES_URL = "/companies";
    public static final String USERS_URL = "/users";
}