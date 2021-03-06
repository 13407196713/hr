package com.south.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// 该过滤器用于统一全站的中文编码
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//1.强转
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		//2.放行
		chain.doFilter(new MyRequest(req), res);
		res.setContentType("text/html;charset=utf-8");
	}

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		@Override
		public String getParameter(String name) {
			// post请求
			if (request.getMethod().equalsIgnoreCase("post")){
				return request.getParameter(name);
			}
			// get请求
			String value = request.getParameter(name);
			if (value == null){
				return null;
			}
			try {
				value = new String(request.getParameter(name).getBytes("iso-8859-1"), "utf-8"); // utf-8
			} catch (UnsupportedEncodingException e) {
			}
			return value;
		}
	}
}