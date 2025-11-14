package com.Jwt.SpringSecEx.controller;


import com.Jwt.SpringSecEx.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "kevin", 60),
            new Student(2, "safa", 50)
    ));

    @GetMapping("/student")
    public List<Student> getStudent(){
        return students;
    }

    @RequestMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
