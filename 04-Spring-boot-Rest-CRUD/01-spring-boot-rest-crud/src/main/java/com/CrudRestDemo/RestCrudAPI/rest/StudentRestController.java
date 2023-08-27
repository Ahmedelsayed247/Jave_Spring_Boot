package com.CrudRestDemo.RestCrudAPI.rest;


import com.CrudRestDemo.RestCrudAPI.Entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Students> theStudents ;

    //define @PostConstruct to load the students data...only once !

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>() ;
        theStudents.add(new Students("Ahmed","elsayed"));
        theStudents.add(new Students("ali","mahomud"));
        theStudents.add(new Students("mo2men","hatem"));
    }

    @GetMapping("/students")
    public List<Students> getStudents () {

           return theStudents ;
    }
    @GetMapping("/students/{studentId}")
    public Students getStudentByID (@PathVariable int studentId) {
        // just index to the list ...... keep it simple for now

        //check if the student found or not !
        if((studentId >= theStudents.size() || studentId <0 )) {
            throw new StudentNotFoundException("Student id not found - "+ studentId) ;
        }
        return theStudents.get(studentId);
    }




}
