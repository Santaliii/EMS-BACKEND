package com.omar.emsbackend.repository;

import com.omar.emsbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  public void deleteEmployeeById(long employeeId);
  public boolean existsByEmail(String email);
}
