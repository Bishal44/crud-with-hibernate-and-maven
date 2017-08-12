package com.bishal.sis.dao;

import java.util.List;

import com.bishal.sis.dto.UserDto;


public interface UserDao {
	public void saveUserInfo(UserDto userDto);

public void updateUserInfo(UserDto userDto);
public void deleteUserInfo(int id);
public List <UserDto>getAllUserInfo();
public UserDto getUserByunameAndpass(String uname,String pass);

	public UserDto grtinfoById(int id);
	public String getImageUrlById(int id);
}
