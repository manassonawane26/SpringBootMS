package com.manas.springboot.cruddemo.dao;

import com.manas.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entityManager
    private EntityManager entityManager;

    // sertup up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee employee = entityManager.find(Employee.class, theId);

        // return the employee
        return employee;
    }

    @Override
    // @tramnsactional is not here because it will be in service layer
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);
    }
}
