package com.cj.ecommercejwt.services;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.cj.ecommercejwt.dao.RoleDao;
import com.cj.ecommercejwt.dao.UserDao;
import com.cj.ecommercejwt.entity.Role;
import com.cj.ecommercejwt.entity.User;

import io.jsonwebtoken.lang.Arrays;

@Service
public class UserServices {

	private UserDao userDao;
	private RoleDao roleDao;

	public UserServices(UserDao userDao, RoleDao roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	public User createUser(User user) {
		return userDao.save(user);
	}

	public void initRolesAndUser() {
		Role admin = new Role();
		admin.setRoleName("Admin");
		admin.setRoleDescription("Admin Role");
		roleDao.save(admin);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default Role for new created record");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setFirstName("admin");
		adminUser.setLastName("admin");
		adminUser.setPassword("admin");
		adminUser.setUserName("admin123");
		//adding role for the the adming user as ROLE : ADMIN
		adminUser.setRole(new HashSet<Role>(java.util.Arrays.asList(admin)));

		userDao.save(adminUser);

		User user = new User();
		user.setFirstName("Chinmay");
		user.setLastName("Jain");
		user.setPassword("Cj@1234");
		user.setUserName("ChinmayJain@1234");
		// adding role for the user role of ROLE : Default User
		user.setRole(new HashSet<Role>(java.util.Arrays.asList(userRole)));

		userDao.save(user);
	}

}
