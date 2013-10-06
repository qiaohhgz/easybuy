package com.facade;

import com.dao.UsersDao;
import com.entity.Users;

public class UsersFacade {
	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	// TODO getUsersByLoginName
	public Users getUsersByLoginName(String loginName) {
		return usersDao.findByLoginName(loginName);
	}

	// TODO Auto-generated method stub isLoginNameExist
	public boolean isLoginNameExist(String loginName) {
		Users users = usersDao.findByLoginName(loginName);
		return users != null;
	}

}
