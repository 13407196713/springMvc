package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private int age;
    private boolean flag;
//    private String[] hobby;
    private List<String> hobby;
    private List<String> selectHobby;

    private int radioId;

    private Map<Integer, String> gradeMap;
    private int selectGrade;

    private Map<Integer, String> cityMap;
    private int selectCity;

    private String introduce;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
