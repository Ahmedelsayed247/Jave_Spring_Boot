package com.springBoot.employee.crudDemoemployee.rest;

import com.springBoot.employee.crudDemoemployee.entity.Employee;
import com.springBoot.employee.crudDemoemployee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService ;

    //quick and dirty :inject employee dao(use constructor injection)

    public EmployeeRestController(EmployeeService theemployeeService) {
        employeeService = theemployeeService;
    }


    //expose "/employee" and return a list of employee
    @GetMapping("/employees")
    public List<Employee> findAll (){
        return employeeService.findAllemp();
    }

    //add mapping for GET /employee/{employeeId;
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.getEmployeeByID(employeeId) ;
        if(theEmployee == null) {
            throw new RuntimeException("Employee is not found - " + employeeId);
        }
        return theEmployee ;

    }
    //add mapping for POST "/employee";
    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee theEmployee){

        //also just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .....instead of update
         theEmployee.setId(0);
         Employee dbEmployee = employeeService.save(theEmployee) ;
         return dbEmployee ;

    }
    //add mapping for PUT "/employee";
    @PutMapping("/employees")
    public Employee updatEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee) ;
        return dbEmployee ;

    }
    //add mapping for DELETE "/employee/{employeeID}";
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId ) {
        Employee tempEmployee = employeeService.getEmployeeByID(employeeId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId) ;
        }

        employeeService.deleteById(employeeId);
        return "Deleted employeeId -" + employeeId;
    }



}
