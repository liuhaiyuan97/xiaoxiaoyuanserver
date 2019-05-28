package com.project.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FriendsMapper;
import com.project.entity.Friends;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService{

	@Autowired
	private FriendsMapper friendsMapper;
	
	@Override
	public List<Friends> findAllFriends(int id) {
	
		return friendsMapper.findAllFriends(id);
	}

	@Override
	public void deleteFriend(int id, int friendId) {
		friendsMapper.deleteFriend(id, friendId);
	}

	@Override
	public void insertRequest(int id, int friendId) {
		friendsMapper.insertRequest(id, friendId);	
	}

	@Override
	public List<Request> selectRequest(int id) {
		return friendsMapper.selectRequest(id);
	}

	@Override
	public void updateRequest(int id, int friendId,int tag) {
		friendsMapper.updateRequest(id, friendId, tag);
	}

	
	public void insertFriend(int id,int friendId) {
		friendsMapper.insertFriend(id, friendId);
	}

	@Override
	public Friends isFriend(int id, int friendId) {
		return friendsMapper.isFriend(id, friendId);
	}

	@Override
	public Request isRequest(int id, int friendId) {
		return friendsMapper.isRequest(id, friendId);
	}

	
}
