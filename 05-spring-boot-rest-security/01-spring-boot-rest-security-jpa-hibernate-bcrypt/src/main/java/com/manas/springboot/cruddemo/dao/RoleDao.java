package com.manas.springboot.cruddemo.dao;

import com.manas.springboot.cruddemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
