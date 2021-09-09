package com.south.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//用于为客户端请求匹配对应的处理方法
public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");	
		if (null == method || "".equals(method) || method.trim().equals("")) {
			method = "execcute";
		}

		//为页面请求匹配具体处理的方法
		Class clazz = this.getClass();
		try {
			Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if(null != md){
				String jspPath = (String) md.invoke(this, req, resp);
				if (null != jspPath) {
					req.getRequestDispatcher(jspPath).forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 默认方法
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;
	}
}