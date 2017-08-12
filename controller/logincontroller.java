package com.bishal.sis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bishal.sis.dto.UserDto;
import com.bishal.sis.service.UserService;
import com.bishal.sis.service.UserServiceImpl;


@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session =request.getSession(false);
	session.invalidate();
	response.sendRedirect("Login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		UserService userService=new UserServiceImpl();
	
		UserDto userDto= userService.getUserByunameAndpass(userName, password);
		if(userDto!=null) {
			HttpSession httpSession=request.getSession();
			response.sendRedirect("Home.jsp");
			httpSession.setAttribute("username", userName);
		}
		else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
