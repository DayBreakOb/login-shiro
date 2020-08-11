package com.mry.util;

import java.nio.charset.Charset;

public class SecurityConfigUtils {

	public final static Charset CHARSET = Charset.forName("UTF-8");

	public final static String AES_LOGIN_SK = "1DD:sOHHmCqB1111";

	public final static String AES_PASSWD_SK = "1DD:sOHHmCqB1111";

	// 指定获取客户端IP的Header名称，防止IP伪造。指定为空，则使用原生方法获取IP。
	public final static String remoteAddrHeaderName = "X-Forwarded-For";

	public static final String AES_VALI_CODE = "1DD:sOHHmCqB1111";

	public static final String LOGIN_FAILURE = "Account or password error, please try again.";
	public static final String LOGIN_NOTLONGIN = "No login or login timeout.Please login again, thank you!";
	public static final String LOGIN_SUCCESS = "Login successful!";
	public static final String LOGIN_GETINFO = "Get info successful!";
	public static final String LOGIN_ERROR = "Sorry, system error. Please try again later";
	public static final String LOGOUT_SUCCESS = "Logout successful!";

	// 是否允许刷新主框架页，如果设置为false，刷新主页将导致重新登录。如安全性比较高的，如银行个人首页不允许刷新。
	public static final boolean isAllowRefreshIndex = true;

	public static final boolean TRUE = true;
	public static final boolean FALSE = false;

	public static final String AES_REMBER_KEY = "r9%TVb{j8z>71vC=";

	public static final String[] ALLOW_REMOTE_ADDRESS = { "127.0.0.1","localhost","0:0:0:0:0:0:0:1"};

	public static final String AJAXLOGIN = "/login";

	public static boolean isGenerateNewSessionAfterLogin = false;

}