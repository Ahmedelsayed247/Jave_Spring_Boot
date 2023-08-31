package com.springBoot.employee.crudDemoemployee.service;

import com.springBoot.employee.crudDemoemployee.DAO.EmployeeRepository;
import com.springBoot.employee.crudDemoemployee.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository theEmployeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.theEmployeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAllemp() {
        return theEmployeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(int theID) {
        Optional<Employee> result = theEmployeeRepository.findById(theID);
        Employee theEmployee = null ;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find the employee id - " + theID) ;
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return theEmployeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theID) {
        theEmployeeRepository.deleteById(theID);
    }
}
