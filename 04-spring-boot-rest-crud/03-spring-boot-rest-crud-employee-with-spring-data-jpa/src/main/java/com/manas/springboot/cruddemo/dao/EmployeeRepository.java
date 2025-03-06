package com.manas.springboot.cruddemo.dao;

import com.manas.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any extra code
}
