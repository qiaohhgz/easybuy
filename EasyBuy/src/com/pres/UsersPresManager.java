package com.pres;

import com.bean.UsersBean;
import com.entity.Users;
import com.facade.UsersFacade;

public class UsersPresManager {

	private UsersFacade usersFacade;

	public void setUsersFacade(UsersFacade usersFacade) {
		this.usersFacade = usersFacade;
	}

	// TODO getCurrentUsers
	public Users getCurrentUsers() {
//		HttpSession session = WebContextFactory.get().getSession();

		return null;
	}

	// TODO isLoginName
	public boolean isLoginNameExist(String loginName) {
		return usersFacade.isLoginNameExist(loginName);
	}

	// TODO register
	public Users regUsers(UsersBean bean) {

		return null;
	}

	// TODO login
	public Users login(String loginName, String password) {

		return null;
	}
}
