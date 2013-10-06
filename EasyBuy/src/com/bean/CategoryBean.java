package com.bean;

import java.util.Date;

public class CategoryBean {
	private Integer id;
	private String name;
	private CategoryBean categoryFather;
	private Date createOn;
	private boolean isDisabled;

	public CategoryBean() {
	}

	public CategoryBean(Integer id, String name, CategoryBean categoryFather) {
		super();
		this.id = id;
		this.name = name;
		this.categoryFather = categoryFather;
	}

	public CategoryBean getCategoryFather() {
		return categoryFather;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean getIsDisabled() {
		return isDisabled;
	}

	public void setCategoryFather(CategoryBean categoryFather) {
		this.categoryFather = categoryFather;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
