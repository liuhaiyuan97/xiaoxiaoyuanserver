package com.project.service;

import java.util.List;

import com.project.entity.Friends;
import com.project.entity.Request;
import com.project.entity.User;

public interface FriendsService {
	
	public List<Friends> findAllFriends(int id);
	
	public void deleteFriend(int id,int friendId);
	
	public void insertRequest(int id,int friendId);
	
	public List<Request> selectRequest(int id);
	
	public void updateRequest(int id,int friendId,int tag);
	
	public void insertFriend(int id,int friendId);
	
	public Friends isFriend(int id,int friendId);
	
	public Request isRequest(int id,int friendId);
	
}
