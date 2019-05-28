package com.project.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserMapper;
import com.project.entity.User;
import com.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(Map<String, String> map,String password) {
		return userMapper.login(map.get("user_phone"),map.get("user_email"),password);
		
	}

	@Override
	public void regist(Map<String, String> map, String password) {
		userMapper.regist(map.get("user_phone"), map.get("user_email"), password);
	}

	@Override
	public User isExitPhone(String phone) {
		return userMapper.isExitPhone(phone);
	}

	@Override
	public User isExitEmail(String email) {
	
		return userMapper.isExitEmail(email);
	}

	@Override
	public List<User> FloorList() {
		return userMapper.FloorList();
	}

	@Override
	public void updateUserImage(int userid, int image) {
		userMapper.updateUserImage(userid, image);
	}

	@Override
	public User showAllInfo(int id) {
		
		return userMapper.showAllInfo(id);
	}

	@Override
	public void updateUserName(int id, String info) {
		userMapper.updateUserName(id, info);
		
	}

	@Override
	public void updateUserSex(int id, String info) {
		userMapper.updateUserSex(id, info);
		
	}

	@Override
	public void updateUserPhone(int id, String info) {
		userMapper.updateUserPhone(id, info);
		
	}

	@Override
	public void updateUserEmail(int id, String info) {
		userMapper.updateUserEmail(id, info);
		
	}

	@Override
	public void updateUserBirthday(int id, String info) {
		userMapper.updateUserBirthday(id, info);
		
	}

	@Override
	public User selectFloorByUserId(int id) {
		return userMapper.selectFloorByUserId(id);
	}

	@Override
	public void addUserFloor(int id,int floor) {
		userMapper.addUserFloor(id,floor);
		
	}



	
	
	
	
	
	
}
