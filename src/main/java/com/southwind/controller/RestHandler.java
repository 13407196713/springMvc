package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/rest1")
public class RestHandler {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveorupdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }

    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/json;charset=UTF-8");
        return studentRepository.findAll();
    }

//    @GetMapping("/findAll")
//    public Collection<Student> findAll(){
//        return studentRepository.findAll();
//    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveorupdate(student);
    }

}
