package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagHandler {
    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView  modelAndView = new ModelAndView("tag");
//        Student student = new Student(1L, "张三", 22);
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(22);
        student.setFlag(true);

//        String[] hobby = {"读书","看电影","玩游戏"};
//        student.setHobby(Arrays.asList("读书","看电影","玩游戏"));
        student.setHobby(Arrays.asList("摄影","读书","听音乐","看电影","旅游","玩游戏"));
        student.setSelectHobby(Arrays.asList("摄影","读书","听音乐"));

        student.setRadioId(1);

        Map<Integer, String> gradeMap = new HashMap<>();
        gradeMap.put(1,"一年级");
        gradeMap.put(2,"二年级");
        gradeMap.put(3,"三年级");
        gradeMap.put(4,"四年级");
        gradeMap.put(5,"五年级");
        gradeMap.put(6,"六年级");
        student.setGradeMap(gradeMap);
        student.setSelectGrade(3);

        Map<Integer, String> cityMap = new HashMap<>();
        cityMap.put(1,"北京");
        cityMap.put(2,"上海");
        cityMap.put(3,"广州");
        cityMap.put(4,"深圳");
        student.setCityMap(cityMap);
        student.setSelectCity(3);

        student.setIntroduce("你好，我是...");

        modelAndView.addObject("student", student);
        return modelAndView;
    }
}
