package com.mry.shrio.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;

import com.mchange.v1.lang.BooleanUtils;
import com.mry.http.wrapper.XssHttpServletRequestWrapper;
import com.mry.util.ServletUtils;
import com.mry.util.StringUtils;

public class IXssFilter implements Filter {

	/**
	 * 是否过滤富文本内容
	 */
	private boolean flag = false;

	private List<String> excludes = new ArrayList<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
		if (StringUtils.isNotBlank(isIncludeRichText)) {
			flag = BooleanUtils.parseBoolean(isIncludeRichText);
		}
		String temp = filterConfig.getInitParameter("excludes");
		if (temp != null) {
			String[] url = temp.split(",");
			excludes.addAll(Arrays.asList(url));
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq = WebUtils.toHttp(request);
		if (ServletUtils.handleExcludeUrl(hreq,excludes)) {
			chain.doFilter(request, response);
			return;
		}
		XssHttpServletRequestWrapper xssrequest = new XssHttpServletRequestWrapper(WebUtils.toHttp(request), flag,hreq.getParameterMap());
		chain.doFilter(xssrequest, response);
	}


}
