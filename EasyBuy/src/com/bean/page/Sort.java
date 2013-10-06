package com.bean.page;

public class Sort {
	public final static int SORT_ASCENDING = 0;
	public final static int SORT_DESCENDING = 1;
	private String key;
	private int dir;

	public int getDir() {
		return dir;
	}

	public String getKey() {
		return key;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
