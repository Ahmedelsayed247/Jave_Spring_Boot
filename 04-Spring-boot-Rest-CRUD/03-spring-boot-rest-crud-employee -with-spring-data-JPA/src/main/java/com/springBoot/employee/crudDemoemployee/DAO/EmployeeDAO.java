package com.springBoot.employee.crudDemoemployee.DAO;

import com.springBoot.employee.crudDemoemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAllEmployee () ;
    public Employee getEmployeeByID(int theID);
    public Employee save(Employee theEmployee);
    public void deleteById(int theID);


}
