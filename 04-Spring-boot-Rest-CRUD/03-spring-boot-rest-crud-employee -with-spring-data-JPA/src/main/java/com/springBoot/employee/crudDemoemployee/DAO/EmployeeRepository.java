package com.springBoot.employee.crudDemoemployee.DAO;

import com.springBoot.employee.crudDemoemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
