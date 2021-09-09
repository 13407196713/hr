package com.south.web;

import com.south.pojo.User;
import com.south.service.Impl.UserServiceImpl;
import com.south.service.UserService;
import com.south.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends BaseServlet {
	private UserService userService=new UserServiceImpl();

	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//接受用户名和用户密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		//调用业务层功能 : 根据用户名查找用户  select * from user where username=?, 返回用户
		User user=userService.findUserByUsernameAndPassword(username,password);

		//根据返回的用户是否为空,判断用户是否已经存在  ,向客户端响应
		if(null!=user){
			request.getSession().setAttribute("user",user);
			request.getRequestDispatcher("/manage.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "登录失败");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		return null;
	}
	
	public String userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.getSession().removeAttribute("user");
		//response.sendRedirect("/login.jsp");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return null;
	}

	public String toAddPage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		request.getRequestDispatcher("/adduser.jsp").forward(request, response);
		return null;
	}

	public String userAdd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setBirthday(DateUtil.parseToDate(request.getParameter("birthday"), DateUtil.yyyyMMdd));
		user.setCreatetime(new java.util.Date());
		user.setContent(request.getParameter("content"));
		userService.saveUser(user);

		List userList=userService.findAllUsers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/listuser.jsp").forward(request, response);
		return null;
	}

	public String toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		String  id = request.getParameter("id");
		User user =userService.findUserById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/updateuser.jsp").forward(request, response);
		return null;
	}

	public String updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		User user = new User();
		user.setId( request.getParameter("id"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		System.out.println(request.getParameter("sex"));
		user.setBirthday(DateUtil.parseToDate(request.getParameter("birthday"), DateUtil.yyyyMMdd));
		user.setCreatetime(new java.util.Date());
		user.setContent(request.getParameter("content"));
		
		userService.updateUser(user);
		List userList=userService.findAllUsers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/listuser.jsp").forward(request, response);
		return null;
	}

	public String deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		System.out.println(id);
		userService.delete(id);
		List userList=userService.findAllUsers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/listuser.jsp").forward(request, response);
		return null;
	}

	public List userList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List userList=userService.findAllUsers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/listuser.jsp").forward(request, response);
		return null;
	}
}
