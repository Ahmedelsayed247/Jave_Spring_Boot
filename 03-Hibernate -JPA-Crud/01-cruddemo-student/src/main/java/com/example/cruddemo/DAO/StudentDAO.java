package com.example.cruddemo.DAO;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findByID(Integer id );
    List<Student> findAll() ;
    List<Student> findByLastName(String thelastname) ;
    void Update(Student theStudent);
    void Delete(Integer id);
    int deleteAll() ;





}
