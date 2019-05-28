package com.project.controller;

import com.google.gson.Gson;
import com.project.entity.Friends;
import com.project.entity.User;
import com.project.service.FriendsService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("friendsList")
public class FriendListController {
    @Autowired
    private FriendsService friendsService;
    @Autowired
    private UserService userService;

    @RequestMapping(value="findAllFriends",produces="text/plain;charset=utf-8")
    @ResponseBody
    public String findAllFriends(@RequestParam("id") int id) {
        List<Friends> list=friendsService.findAllFriends(id);
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
}
