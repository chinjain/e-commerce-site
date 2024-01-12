package com.cj.ecommercejwt.services;

import org.springframework.stereotype.Service;

import com.cj.ecommercejwt.dao.RoleDao;
import com.cj.ecommercejwt.entity.Role;

@Service
public class RoleServices {

	private RoleDao roleDao;

	public RoleServices(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public Role createNewRole(Role role) {
		return roleDao.save(role);

	}

}
