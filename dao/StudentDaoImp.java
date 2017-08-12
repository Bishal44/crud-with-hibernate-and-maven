package com.bishal.sis.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bishal.sis.dto.StudentDto;
import com.bishal.sis.dto.UserDto;
import com.bishal.sis.util.DbUtil;
import com.bishal.sis.util.HibernateUtil;

public class StudentDaoImp implements StudentDao {

	

	@Override
	public void saveStudentInfo(StudentDto studentdto) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(studentdto);
			session.getTransaction().commit();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<StudentDto> getAllStudentInfo() {
		List<StudentDto> studentlist = null;

		try {
			Session session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(StudentDto.class);
			studentlist = criteria.list();
			session.getTransaction().commit();
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("studentlist.size() " + studentlist.size());
		return studentlist;

	}

	@Override
	public void updateStudentInfo(StudentDto studentdto) {

		try {
			Session session = HibernateUtil.getSession();
			session.update(studentdto);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudentInfo(int id) {
		StudentDto studentdto = getStudentInfobyId(id);
		if (studentdto != null) {

			try {
				Session session = HibernateUtil.getSession();
				session.delete(studentdto);
				session.getTransaction().commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public StudentDto getStudentInfobyId(int id) {
		StudentDto studentdto = new StudentDto();
		try {
			Session session = HibernateUtil.getSession();
			studentdto = (StudentDto) session.get(StudentDto.class, id);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return studentdto;
	}

	@Override
	public String getImageUrlById(int id) {
		StudentDto studentdto = new StudentDto();
		try {
			Session session = HibernateUtil.getSession();
			studentdto = (StudentDto) session.get(StudentDto.class, id);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentdto.getImageUrl();
	}

}
