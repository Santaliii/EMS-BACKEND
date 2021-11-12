package com.omar.emsbackend.service;

import com.omar.emsbackend.exception.DuplicateResourceException;
import com.omar.emsbackend.exception.ResourceNotFoundException;
import com.omar.emsbackend.model.Employee;
import com.omar.emsbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }


  public ResponseEntity<Employee> getEmployeeById(@PathVariable long employeeId) {
    Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee with id " + employeeId + " does not exist."));
    return ResponseEntity.ok(employee);
  }

  public boolean checkEmailExistence(String email) {
    if(employeeRepository.existsByEmail(email))
      throw new DuplicateResourceException("Email already exists");
    else
      return false;
  }


  public void addEmployee(@RequestBody Employee employee) {
      employeeRepository.save(employee);
  }



  public void deleteEmployeeById(@PathVariable long employeeId) {
    employeeRepository.deleteEmployeeById(employeeId);
  }

}
