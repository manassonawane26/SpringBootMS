package com.manas.springboot.cruddemo.dao;

import com.manas.springboot.cruddemo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
