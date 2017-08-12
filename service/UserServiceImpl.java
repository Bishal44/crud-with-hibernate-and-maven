package com.bishal.sis.service;

import java.util.List;

import com.bishal.sis.dao.UserDao;
import com.bishal.sis.dao.UserDaoImpl;
import com.bishal.sis.dto.UserDto;

public class UserServiceImpl  implements UserService{
	UserDao userDao=new UserDaoImpl();

	@Override
	public void saveUserInfo(UserDto userDto) {
	userDao.saveUserInfo(userDto);
		
	}

	@Override
	public void updateUserInfo(UserDto userDto) {
		userDao.updateUserInfo(userDto);
	}

	@Override
	public void deleteUserInfo(int id) {
		userDao.deleteUserInfo(id);
		
	}

	@Override
	public List<UserDto> getAllUserInfo() {
		return userDao.getAllUserInfo();
		
	}

	@Override
	public UserDto getUserByunameAndpass(String uname, String pass) {

		return userDao.getUserByunameAndpass(uname, pass);
	}

	@Override
	public UserDto grtinfoById(int id) {
		
		return userDao.grtinfoById(id);
	}

	@Override
	public String getImageUrlById(int id) {
		return userDao.getImageUrlById(id);
	}

}
