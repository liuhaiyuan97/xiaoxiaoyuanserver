package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.project.entity.Friends;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.FriendsService;
import com.project.service.UserService;


@Controller
@RequestMapping("friends")
public class FriendsController {
	@Autowired
	private FriendsService friendsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="findAllFriends",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String findAllFriends(@RequestParam("id") int id) {
		List<Friends> list=friendsService.findAllFriends(id);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		List<Integer> intlist=new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if (list.get(i).getFri_id1()==id){
				intlist.add(list.get(i).getFri_id2());
			}else {
				intlist.add(list.get(i).getFri_id1());
			}
		}
		List<User> users=new ArrayList<>();
		for(int i=0;i<intlist.size();i++) {
			users.add(userService.showAllInfo(intlist.get(i)));
		}
		Gson gson=new Gson();
		String userlist=gson.toJson(users);
		return userlist;
	}
	
	@RequestMapping("deleteFriend")
	@ResponseBody
	public String deleteFriend(@RequestParam("id") int id,@RequestParam("friendId") int friendId) {
		friendsService.deleteFriend(id, friendId);
		friendsService.deleteFriend(friendId,id);
		return "true";
	}
	
	@RequestMapping("insertRequest")
	@ResponseBody
	public String insertRequest(@RequestParam("id") int id,@RequestParam("friend") String friend) {
		if(friend.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
			User user=userService.isExitEmail(friend);
			if(user!=null) {
			Friends friends=friendsService.isFriend(id,user.getUser_id());
			
			Request request=friendsService.isRequest(id,user.getUser_id());
			if(user!=null && user.getUser_id()!=id && friends==null && request==null) {
				friendsService.insertRequest(id, user.getUser_id());
				return "send";
			}else if(user.getUser_id()==id){
				return "yourself";
			}else if(user.getUser_id()!=id && friends!=null){
				return "repeatadd";
			}else if(user.getUser_id()!=id && friends==null && request!=null) {
				return "repeatsend";
			}else {
				return "";
			}
			}else {
				return "notexit";
			}
			
			
		}else {
			User user=userService.isExitPhone(friend);
			if(user!=null) {
			Friends friends=friendsService.isFriend(id,user.getUser_id());
			
			Request request=friendsService.isRequest(id,user.getUser_id());
			if(user.getUser_id()!=id && friends==null && request==null) {
				friendsService.insertRequest(id, user.getUser_id());
				return "send";
			}else if(user.getUser_id()==id){
				return "yourself";
			}else if(user.getUser_id()!=id && friends!=null) {
				return "repeatadd";
			}else if(user.getUser_id()!=id && friends==null && request!=null) {
				return "repeatsend";
			}
			else{
				return "";
			}
		}else {
			return "notexit";
		}
		}
		
	}
	
	@RequestMapping(value="selectRequest",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String selectRequest(@RequestParam("id") int id) {
		List<Request> requests=friendsService.selectRequest(id);
		List<Integer> integers=new ArrayList<>();
		for(int i=0;i<requests.size();i++) {
			integers.add(requests.get(i).getRequest_sender_id());
		}
		List<User> users=new ArrayList<>();
		for(int i=0;i<integers.size();i++) {
			users.add(userService.showAllInfo(integers.get(i)));
		}
		if(users!=null) {
			Gson gson=new Gson();
			String str=gson.toJson(users);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping(value="updateRequest",produces="text/plain;chartset=utf-8")
	@ResponseBody
	public String updateRequest(@RequestParam("type") String type,@RequestParam("id") int id,@RequestParam("friendId") int friendId) {
		if(type.equals("true")) {
			friendsService.updateRequest(id, friendId, 1);
			friendsService.insertFriend(friendId,id);
			return "true";
		}else {
			friendsService.updateRequest(id, friendId, 2);
			return "false";
		}
	}
	
	}
