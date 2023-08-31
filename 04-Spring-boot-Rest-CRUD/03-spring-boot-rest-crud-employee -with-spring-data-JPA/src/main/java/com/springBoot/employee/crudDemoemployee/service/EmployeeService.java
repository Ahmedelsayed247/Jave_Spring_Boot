package com.springBoot.employee.crudDemoemployee.service;

import com.springBoot.employee.crudDemoemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAllemp();

    public Employee getEmployeeByID(int theID);
    public Employee save(Employee theEmployee);
    public void deleteById(int theID);
}
