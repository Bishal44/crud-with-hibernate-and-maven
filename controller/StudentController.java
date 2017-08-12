package com.bishal.sis.controller;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.bishal.sis.dto.StudentDto;
import com.bishal.sis.service.StudentService;
import com.bishal.sis.service.StudentServiceImpl;
import com.bishal.sis.util.ImageUtil;

@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(StudentController.class);
	StudentService studentService = new StudentServiceImpl();
	private static final String STUDENT_LIST_PAGE = "StudentList.jsp";
	private static final String STUDENT_CREATE_PAGE = "StudentForm.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("student controller get method called");
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equalsIgnoreCase("add_new")) {
			forward = STUDENT_CREATE_PAGE;
		
		} else if (action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("student", studentService.getStudentInfobyId(id));
			forward = STUDENT_CREATE_PAGE;
		} else if (action.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			studentService.deleteStudentInfo(id);
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;

		} else if (action.equalsIgnoreCase("student_list")) {
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;

		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		log.info("id is"+rd);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDto studentDto = new StudentDto();

		studentDto.setStudentName(request.getParameter("sname"));
		studentDto.setCollegeName(request.getParameter("cname"));
		studentDto.setEmail(request.getParameter("email"));
		studentDto.setRoll(Integer.parseInt(request.getParameter("roll")));
		studentDto.setGender(request.getParameter("gender"));
		studentDto.setDepartment(request.getParameter("departcombo"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

		try {
			Date dob = dateFormat.parse(request.getParameter("dob"));
			studentDto.setDob(dob);
		} catch (java.text.ParseException e) {

			e.printStackTrace();
		}

		String[] subjects = request.getParameterValues("subject");
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}studentDto.setSubject(subject);
		String studentId=request.getParameter("id");
		
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(part, ImageUtil.filePath + fileName);
		} else {
			imageUrl = studentService.getImageUrlById(Integer.parseInt(studentId));
		}
		studentDto.setImageUrl(imageUrl);
		if(studentId==null||studentId.isEmpty()) {
			studentService.saveStudentInfo(studentDto);
		}else {
			studentDto.setId(Integer.parseInt(studentId));
			studentService.updateStudentInfo(studentDto);
		}

	
	response.sendRedirect(STUDENT_LIST_PAGE);
		request.getServletContext().setAttribute("students", studentService.getAllStudentInfo());
		

	}


}
