package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "News")
public class News implements Serializable {
	private static final long serialVersionUID = -8012949517071482896L;
	private Integer id;
	private String title;
	private String content;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "content", nullable = true)
	public String getContent() {
		return content;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "newsId", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	@Column(name = "isDisabled", nullable = false)
	public boolean getIsDisabled() {
		return isDisabled;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setIsDisabled(boolean disabled) {
		this.isDisabled = disabled;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}