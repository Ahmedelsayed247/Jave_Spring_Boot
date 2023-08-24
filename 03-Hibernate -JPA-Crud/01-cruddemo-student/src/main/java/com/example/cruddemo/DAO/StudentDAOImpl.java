package com.example.cruddemo.DAO;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager

    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc " , Student.class);
           return theQuery.getResultList();
    }



    @Override
    public List<Student> findByLastName(String lastname) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData" , Student.class);
        //set query parameter
        theQuery.setParameter("theData" ,lastname) ;
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void Update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void Delete(Integer id) {
         // retrieve the student id
        Student theStudent = entityManager.find(Student.class, id) ;
        //Delete form dataBase
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional

    public int deleteAll() {
        int numberOfDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numberOfDeleted;
    }


}
