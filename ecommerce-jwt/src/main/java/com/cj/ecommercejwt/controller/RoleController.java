package com.cj.ecommercejwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cj.ecommercejwt.entity.Role;
import com.cj.ecommercejwt.services.RoleServices;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

	@Autowired
	private RoleServices roleService;

	@PostMapping("/create")
	public Role createNewRole(@RequestBody Role role) {
		return roleService.createNewRole(role);
	}
}
