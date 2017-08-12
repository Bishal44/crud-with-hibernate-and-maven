package com.bishal.sis.service;

import java.util.List;

import com.bishal.sis.dao.StudentDao;
import com.bishal.sis.dao.StudentDaoImp;
import com.bishal.sis.dto.StudentDto;


public class StudentServiceImpl implements StudentService {
	StudentDao studentdao = new StudentDaoImp();

	

	@Override
	public void saveStudentInfo(StudentDto studentdto) {
		studentdao.saveStudentInfo(studentdto);
	}

	@Override
	public List<StudentDto> getAllStudentInfo() {
		
		return studentdao.getAllStudentInfo();
	}

	@Override
	public void updateStudentInfo(StudentDto studentdto) {
		studentdao.updateStudentInfo(studentdto);
		
	}

	@Override
	public void deleteStudentInfo(int id) {
		studentdao.deleteStudentInfo(id);
		
	}

	@Override
	public StudentDto getStudentInfobyId(int id) {
		return studentdao.getStudentInfobyId(id);
	}

	@Override
	public String getImageUrlById(int id) {
		
		return studentdao.getImageUrlById(id);
	}
	

}
