package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserList;
import com.southwind.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/data")
public class DataBindHandler {
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(int id){
        return id + "";
    }

    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "num",
            required = false, defaultValue = "0")Integer id){
        return id + "";
    }

    @RequestMapping("/array")
    @ResponseBody
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for(User user:userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    @ResponseBody
    public String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        for(String key:userMap.getUsers().keySet()){
            User user = userMap.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/json")
    @ResponseBody
    public User json(@RequestBody User user){
        System.out.println(user);
        user.setId(6);
        user.setName("张六");
        return user;
    }
}
