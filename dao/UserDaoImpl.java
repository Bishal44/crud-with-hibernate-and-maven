package com.bishal.sis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.bishal.sis.dto.StudentDto;
import com.bishal.sis.dto.UserDto;
import com.bishal.sis.util.DbUtil;
import com.bishal.sis.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public void saveUserInfo(UserDto userDto) {
		
			try {
				Session session = HibernateUtil.getSession();
				session.save(userDto);
				session.getTransaction().commit();
			} catch (IOException e) {

				e.printStackTrace();
			}

	}
	@Override
	public void updateUserInfo(UserDto userDto) {
		try {
			Session session = HibernateUtil.getSession();
			session.update(userDto);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Override
	public void deleteUserInfo(int id) {
		UserDto userdto = grtinfoById(id);
		if (userdto != null) {

			try {
				Session session = HibernateUtil.getSession();
				session.delete(userdto);
				session.getTransaction().commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	@Override
	public List<UserDto> getAllUserInfo() {
		List <UserDto> userList=null;
		

		try {
			Session session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(UserDto.class);
			userList = criteria.list();
			session.getTransaction().commit();
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		return userList;
	}
	@Override
	public UserDto getUserByunameAndpass(String uname, String pass) {
		UserDto userDto = null;
		
		try {
			Session	session = HibernateUtil.getSession();
			Criteria criteria= session.createCriteria(UserDto.class).add(Restrictions.eq("userName", uname))
					.add(Restrictions.eq("password", pass));
			
			 userDto=(UserDto) criteria.uniqueResult();
			 session.getTransaction().commit();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return userDto;
	}
		
		
	
	@Override
	public UserDto grtinfoById(int id) {
		UserDto userDto = null;
		try {
			Session session = HibernateUtil.getSession();
			userDto = (UserDto) session.get(UserDto.class, id);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDto;
	}
	@Override
	public String getImageUrlById(int id) {
		UserDto userdto = new UserDto();
		try {
			Session session = HibernateUtil.getSession();
			userdto = (UserDto) session.get(UserDto.class, id);
			session.getTransaction().commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userdto.getImageUrl();
	}
	
}
