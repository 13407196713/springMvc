package com.southwind.controller;

import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @RequestMapping(value = "/index",method = RequestMethod.GET, params = {"name","id=1"})
    public String index(@RequestParam("name") String str, @RequestParam("id") int age){
        System.out.println(str);
        System.out.println(age);
        System.out.println("执行了index...");
        return "index";
    }

    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String str, @PathVariable("id") int age){
        System.out.println(str);
        System.out.println(age);
        return "index";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/forward")
    public String forward(){
        return "forward:/index.jsp";
//        return "index"; //两者效果一样
    }

    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:/index.jsp";
    }
}
