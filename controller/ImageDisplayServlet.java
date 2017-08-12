package com.bishal.sis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishal.sis.service.StudentService;
import com.bishal.sis.service.StudentServiceImpl;
import com.bishal.sis.service.UserService;
import com.bishal.sis.service.UserServiceImpl;



@WebServlet("/ImageDisplayServlet")
public class ImageDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_BUFFER_SIZE = 10240;
	StudentService studentService=new StudentServiceImpl();
   UserService userService= new UserServiceImpl(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
			String imageId = request.getParameter("id");
			String filePath = "";
			if (imageId != null) {
				filePath = studentService.getImageUrlById(Integer.parseInt(imageId));
			} else {
				filePath = userService.getImageUrlById(Integer.parseInt(request.getParameter("user_id")));
			}

			File file = new File(filePath);
			String contentType = getServletContext().getMimeType(file.getName());
			if (contentType == null) {
				contentType = "application/octet-stream";
			}
			response.reset();
			response.setBufferSize(DEFAULT_BUFFER_SIZE);
			response.setContentType(contentType);
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

			BufferedInputStream input = null;
			BufferedOutputStream output = null;

			try {
				input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
				output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

				// Write file contents to response.
				byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
				int length;
				while ((length = input.read(buffer)) > 0) {
					output.write(buffer, 0, length);
				}
			} finally {
				output.close();
				input.close();
			}

	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
