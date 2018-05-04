package com.hxminco.mock.ext.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

public class HttpLocaleFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		filterChain.doFilter(new HttpServletRequestSimplifiedChineseWrapper(request), servletResponse);
	}

	@Override
	public void destroy() {
	}

	final class HttpServletRequestSimplifiedChineseWrapper extends HttpServletRequestWrapper {
		HttpServletRequestSimplifiedChineseWrapper(final HttpServletRequest request) {
			super(request);
		}

		public Enumeration<Locale> getLocales() {
			Vector<Locale> v = new Vector<Locale>(1);
			v.add(getLocale());
			return v.elements();
		}

		public Locale getLocale() {
			Locale locale = Locale.SIMPLIFIED_CHINESE;
			return locale;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
