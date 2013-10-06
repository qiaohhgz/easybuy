package com.bean.table;

import java.util.List;

import com.bean.page.State;

public class NewsTableBean {
	private State state;
	private List<NewsTableBean> rowdata;
	private String errors;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<NewsTableBean> getRowdata() {
		return rowdata;
	}

	public void setRowdata(List<NewsTableBean> rowdata) {
		this.rowdata = rowdata;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
}
