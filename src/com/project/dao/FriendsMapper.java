package com.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.Friends;
import com.project.entity.Request;

public interface FriendsMapper {
	public List<Friends> findAllFriends(int id);
	
	public void deleteFriend(@Param("id") int id,@Param("friendId") int friendId);
	
	public void insertRequest(@Param("id") int id,@Param("friendId") int friendId);
	
	public List<Request> selectRequest(int id);
	
	public void updateRequest(@Param("id") int id,@Param("friendId") int friendId,@Param("tag") int tag);
	
	public void insertFriend(@Param("id") int id,@Param("friendId") int friendId);
	
	public Friends isFriend(@Param("id") int id,@Param("friendId") int friendId);
	
	public Request isRequest(@Param("id") int id,@Param("friendId") int friendId);
}
