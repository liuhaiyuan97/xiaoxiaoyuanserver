package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.entity.User;

public interface UserService {
	public User login(Map<String, String> map,String password);
	
	public void regist(Map<String, String> map,String password);
	
	public User isExitPhone(String phone);
	
	public User isExitEmail(String email);
	
	public List<User> FloorList();
	
	public void updateUserImage(int userid,int image);
	
	public User showAllInfo(int id);
	
	public void updateUserName(int id,String info);
	
	public void updateUserSex(int id,String info);
	
	public void updateUserPhone(int id,String info);
	
	public void updateUserEmail(int id,String info);
	
	public void updateUserBirthday(int id,String info);
	
	public User selectFloorByUserId(int id);
	
	public void addUserFloor(int id,int floor);
}
