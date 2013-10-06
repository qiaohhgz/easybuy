package com.bean;

public class ProductBean {
	private Integer productId;
	private String title;
	private String content;
	private String location;

	public ProductBean() {
	}

	public ProductBean(Integer productId, String title, String content, String location) {
		this.productId = productId;
		this.title = title;
		this.content = content;
		this.location = location;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
