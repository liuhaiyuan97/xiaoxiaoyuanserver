package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.google.gson.Gson;
import com.project.entity.User;
import com.project.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String login(@RequestParam("phoneOremail") String phoneOremail,@RequestParam("password") String password) {
		if(phoneOremail.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
			System.out.println("邮箱登录");
			Map<String, String> map =new HashMap<>();
			map.put("user_phone","");
			map.put("user_email", phoneOremail);
			User user=userService.login(map, password);
			if(user!=null) {
				Gson gson=new Gson();
				String str=gson.toJson(user,User.class);
				System.out.println(str);
				return str;
			}else {
				return null;
			}
		}else {
			System.out.println("手机号登录");
			Map<String, String> map=new HashMap<>();
			map.put("user_phone",phoneOremail);
			map.put("user_email", "");
			System.out.println("controller"+phoneOremail+password);
			User user=userService.login(map, password);
			if(user!=null) {
				Gson gson=new Gson();
				String str=gson.toJson(user,User.class);
				System.out.println(str);
				return str;
			}else {
				return null;
			}
		}
		
		
	}
	
	@RequestMapping("regist")
	@ResponseBody
	public String regist(@RequestParam("phoneOremail") String phoneOremail,@RequestParam("password") String password) {
		if(phoneOremail.matches("[\\\\w!#$%&'*+/=?^_`{|}~-]+(?:\\\\.[\\\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\\\w](?:[\\\\w-]*[\\\\w])?\\\\.)+[\\\\w](?:[\\\\w-]*[\\\\w])?")) {
			Map< String, String> map=new HashMap<>();
			map.put("user_phone", "");
			map.put("user_email", phoneOremail);
			userService.regist(map, password);
			return "true";
		}else {
			Map< String, String> map=new HashMap<>();
			map.put("user_phone", phoneOremail);
			map.put("user_email", "");
			userService.regist(map, password);
			return "true";
		}
		
	} 
	
	@RequestMapping("isExitPhone")
	@ResponseBody
	public String isExitPhone(@RequestParam("phone") String phone) {
		User user=userService.isExitPhone(phone);
		if(user!=null) {
			return "exit";
		}else {
			return null;
		}
		
	}
	
	@RequestMapping("isExitEmail")
	@ResponseBody
	public String isExitEmail(@RequestParam("email") String email) {
		User user=userService.isExitEmail(email);
		if(user!=null) {
			return "exit";
		}else {
			return null;
		}
		
	}
	
	@RequestMapping(value="FloorList",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String FloorList(){
		List<User> users=userService.FloorList();
		if(users!=null && users.size()!=0) {
			Gson gson=new Gson();
			String list=gson.toJson(users);
			System.out.println(list);
			return list;
		}else {
			return null;
		}
	}
	
	@RequestMapping("updateUserImage")
	@ResponseBody
	public String updateUserImage(@RequestParam("id") int userid,@RequestParam("imageid") int image) {
		userService.updateUserImage(userid, image);
		return "true";
	}
	
	@RequestMapping(value="showAllInfo",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String showAllInfo(@RequestParam("id") int id) {
		User user=userService.showAllInfo(id);
		if(user!=null) {
			Gson gson=new Gson();
			String str=gson.toJson(user);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public String updateUserInfo(@RequestParam("id") int id,@RequestParam("type") String type,@RequestParam("info") String info) {
		
		if(type.equals("userName")) {
			userService.updateUserName(id, info);
		}else if(type.equals("userSex")) {
			userService.updateUserSex(id, info);
		}else if(type.equals("userPhone")) {
			userService.updateUserSex(id, info);
		}else if(type.equals("userEmail")) {
			userService.updateUserEmail(id, info);
		}else if(type.equals("userBirthday")) {
			userService.updateUserBirthday(id, info);
		}
		return "true";
	}
	
	@RequestMapping(value="selectFloorByUserId",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String selectFloorByUserId(@RequestParam("id") int id) {
		User user=userService.selectFloorByUserId(id);
		if(user!=null) {
			Gson gson=new Gson();
			String str=gson.toJson(user);
			return str;
		}else {
			return null;
		}
	}
	
	@RequestMapping("addUserFloor")
	@ResponseBody
	public String addUserFloor(@RequestParam("id") int id,@RequestParam("floor") int floor) {
		userService.addUserFloor(id,floor);
		return "true";
	}
	
	
}
