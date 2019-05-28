package com.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.project.entity.User;


public interface UserMapper {
	public User login(@Param("user_phone") String phone,@Param("user_email") String email,@Param("password") String password);
	
	public void regist(@Param("user_phone") String phone,@Param("user_email") String email,@Param("password") String password);

	public User isExitPhone(String phone);
	
	public User isExitEmail(String email);
	
	public List<User> FloorList();
	
	public int updateUserImage(@Param("userid") int userid,@Param("image") int image);
	
	public User showAllInfo(int id);
	
	public void updateUserName(@Param("id") int id,@Param("info") String info);
	
	public void updateUserSex(@Param("id") int id,@Param("info") String info);

	public void updateUserPhone(@Param("id") int id,@Param("info") String info);
	
	public void updateUserEmail(@Param("id") int id,@Param("info") String info);
	
	public void updateUserBirthday(@Param("id") int id,@Param("info") String info);
	
	public User selectFloorByUserId(int id);
	
	public void addUserFloor(@Param("id") int id,@Param("floor") int floor);
}
