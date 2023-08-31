package com.springBoot.employee.crudDemoemployee.DAO;

import com.springBoot.employee.crudDemoemployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //Define field for entity
    private EntityManager entityManager ;



    //set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAllEmployee() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);
        //execute query and get result list
        List<Employee> employees= theQuery.getResultList();

        //return the employees ;
        return employees;
    }

    @Override
    public Employee getEmployeeByID(int theID) {
        Employee theEmployee = entityManager.find(Employee.class , theID);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee = entityManager.merge(theEmployee) ;
        return dbEmployee ;

    }

    @Override
    public void deleteById(int theID) {
        Employee theEmployee = entityManager.find(Employee.class , theID);
        entityManager.remove(theEmployee);
    }
}
