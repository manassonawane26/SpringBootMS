package com.manas.cruddemo.dao;

import com.manas.cruddemo.entity.Student;

public interface StudentDAO {
    default void save(Student theStudent){

    }
}
