package com.springBoot.employee.crudDemoemployee.service;

import com.springBoot.employee.crudDemoemployee.DAO.EmployeeDAO;
import com.springBoot.employee.crudDemoemployee.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO theEmployeeDAO ;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAllemp() {
        return theEmployeeDAO.findAllEmployee();
    }

    @Override
    public Employee getEmployeeByID(int theID) {
        return theEmployeeDAO.getEmployeeByID(theID);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return theEmployeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theID) {
          theEmployeeDAO.deleteById(theID);
    }
}
