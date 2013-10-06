package com;

import com.entity.Users;

public class Common {
	private static Common common;

	private Common() {

	}

	public static Common get() {
		if (common == null) {
			common = new Common();
		}
		return common;
	}
//
//	public Users getCurrentUsers(HttpSession session) {
//		return session.getAttribute("loginUser") == null ? null : ((Users) session.getAttribute("loginUser"));
//	}
}
