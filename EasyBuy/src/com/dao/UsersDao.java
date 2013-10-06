package com.dao;

import com.entity.Users;

public class UsersDao extends BaseDao<Users> {
	public Users findById(int id) {
		return super.loadByUniqueAttribute("userId", id);
	}

	public Users findByLoginName(String loginName) {
		return super.loadByUniqueAttribute("loginName", loginName);
	}

	public Users update(Users user) {
		return super.update(user);
	}

	public Users save(Users user) {
		return super.save(user);
	}
}
