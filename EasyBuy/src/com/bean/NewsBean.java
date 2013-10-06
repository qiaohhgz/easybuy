package com.bean;

import java.util.Date;

public class NewsBean {
	private Integer id;
	private String title;
	private String content;
	private Date createOn;
	private boolean isDisabled;

	public String getContent() {
		return content;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public Integer getId() {
		return id;
	}

	public boolean getIsDisabled() {
		return isDisabled;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
