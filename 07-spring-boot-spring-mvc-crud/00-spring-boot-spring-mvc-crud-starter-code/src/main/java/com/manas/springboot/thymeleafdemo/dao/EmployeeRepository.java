package com.manas.springboot.thymeleafdemo.dao;

import com.manas.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

    // used query methods findAllBy is by default and other is a query spring will calculate result base on this automatically

}

