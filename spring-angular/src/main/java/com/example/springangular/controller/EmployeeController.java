package com.example.springangular.controller;

import com.example.springangular.Exception.ResourceNotFoundException;
import com.example.springangular.Model.Employee;
import com.example.springangular.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/he")
    public String hello(){
        return "Hello world";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployeesList (){
        return employeeRepository.findAll();

    }

    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee emp){
        return employeeRepository.save(emp);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Optional<Employee> emplyeeById = employeeRepository.findById(id);
        if (emplyeeById.isPresent()) {
            return emplyeeById.get();
        }
        return null;


    }

    @GetMapping ("/employees/dep/{id}")
    public List<Employee> getEmployeebydepartement (@PathVariable Long id){
        return employeeRepository.Employeewithdepartementid(id);

    }


    @PutMapping ("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable Long id,@RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updateemployee = employeeRepository.save(employee);
    return ResponseEntity.ok(updateemployee);
    }
    @GetMapping ("/employees/byLastName/{lastname}")
    public ResponseEntity<List<Employee>> getEmployeesbyLastname (@PathVariable String lastname){
        List<Employee> employees = employeeRepository.getEmployeesbyLastname(lastname);
        if(employees.isEmpty()){
            throw new ResourceNotFoundException("lastname not exist");
        }
        return ResponseEntity.ok(employees);
    }

    //Delete  employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity <Map<String,Boolean>> deleteEmployee (@PathVariable Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee not exist with id :" + id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    /*@GetMapping("/employees/{name}")
    public Employee getEmployeesByName(@PathVariable String name){
        return employeeRepository.findUserNameAchraf(name);
    }*/
}
