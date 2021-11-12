package com.omar.emsbackend.controller;


import com.omar.emsbackend.model.Employee;
import com.omar.emsbackend.repository.EmployeeRepository;
import com.omar.emsbackend.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;


  @GetMapping("employees")
  public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }

  @GetMapping("employees/{employeeId}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @GetMapping("employees/checkemail/{email}")
  public boolean checkEmailExistence(@PathVariable String email) {
    return employeeService.checkEmailExistence(email);
  }

  @PostMapping("employees")
  public void addEmployee(@RequestBody Employee employee) {
    employeeService.addEmployee(employee);
  }

  @Transactional
  @DeleteMapping("employees/{employeeId}")
  public void deleteEmployeeById(@PathVariable long employeeId) {
    employeeService.deleteEmployeeById(employeeId);
  }






}
