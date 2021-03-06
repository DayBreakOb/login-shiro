package com.mry.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {



	public static final String urlForRest = "http://localhost:10090/resetpass.html?";
	public static final String ivForRest = "WjJVhiGPKuyxSmIt";

	public static boolean IsSingleLogin;

	@Value("${spring.shiro.issinglelogin:false}")
	public void setIsSingleLogin(boolean isSingleLogin) {
		IsSingleLogin = isSingleLogin;
	}

	public static String loginUrl = "_login_";

	public static int shiroFilterOrder = 2;

	public static int XssFilterOrder = 1;

	public static int UrlFilterOrder = 0;
	
	public static String xssExcludes = "/favicon.ico,/img/,/js/,/css/,/assets/,/dist/,/vendor/,/images/";
	
	public static String loginRsaPriFilePath = "/u01/cryptopem/rsa_private_key_pkcs8.pem";
	public static String restRsapubFilePath = "/u01/cryptopem/rsa_publick_key.pem";
	
	public static int requestMinLogin =15;
	public static int requestMaxLogin =100;
	
	
	public static String resetPassUrl ="localhost:10090/repass.html";
	public static long resetInterval=3600*1000;
	public static String postNoParamRequireExcludes="/logout";

}
