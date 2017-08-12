package com.bishal.sis.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bishal.sis.dto.UserDto;
import com.bishal.sis.service.UserService;
import com.bishal.sis.service.UserServiceImpl;
import com.bishal.sis.util.ImageUtil;





@WebServlet("/UserController")
@MultipartConfig
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String User_LIST_PAGE = "userList.jsp";
	private static final String User_CREATE_PAGE = "userForm.jsp";
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equalsIgnoreCase("user_list")) {
			request.setAttribute("users", userService.getAllUserInfo());
			forward = User_LIST_PAGE;
		} else if (action.equalsIgnoreCase("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("user", userService.grtinfoById(id));
			forward = User_CREATE_PAGE;
		} else if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			userService.deleteUserInfo(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward = User_LIST_PAGE;
		} else if (action.equalsIgnoreCase("add_new")) {
			forward = User_CREATE_PAGE;
		}
		request.getRequestDispatcher(forward).forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDto userDto = new UserDto();
		userDto.setUserName(request.getParameter("uname"));
		userDto.setPassword(request.getParameter("pass"));
		userDto.setFirstName(request.getParameter("fname"));
		userDto.setLastName(request.getParameter("lname"));
		userDto.setEmail(request.getParameter("email"));
		userDto.setGender(request.getParameter("gender"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = dateFormat.parse(request.getParameter("dob"));
			userDto.setDob(date);
		} catch (java.text.ParseException e) {

			e.printStackTrace();
		}
		
		
		
		String userId = request.getParameter("id");
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(part, ImageUtil.filePath + fileName);
		} else {
			imageUrl = userService.getImageUrlById(Integer.parseInt(userId));
		}
		userDto.setImageUrl(imageUrl);
		
		if(userId==null||userId.isEmpty()) {
			userService.saveUserInfo(userDto);
			//EmailUtility.sendEmail(userDto.getEmail());
		}else {
			userDto.setId(Integer.parseInt(userId));
			userService.updateUserInfo(userDto);
		}

	
	response.sendRedirect(User_LIST_PAGE);
		request.getServletContext().setAttribute("users", userService.getAllUserInfo());
		


	}

		
	}



