package com.hxminco.mock.ext.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessControlFilter implements Filter {
	private String allowValue = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowValue = filterConfig.getInitParameter("allow");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (allowValue != null && !allowValue.equals("")) {
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", allowValue);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
