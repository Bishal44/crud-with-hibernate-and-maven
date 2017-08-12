package com.bishal.sis.service;

import java.util.List;

import com.bishal.sis.dto.StudentDto;



public interface StudentService {
	public void saveStudentInfo(StudentDto studentdto);

	public List<StudentDto> getAllStudentInfo();

	public void updateStudentInfo(StudentDto studentdto);

	public void deleteStudentInfo(int id);

	public StudentDto getStudentInfobyId(int id);
	public String getImageUrlById(int id);
}
