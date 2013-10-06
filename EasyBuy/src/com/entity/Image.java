package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class Image implements Serializable {
	private static final long serialVersionUID = 178211207875907766L;
	public static final String JPG = "jpg";
	public static final String PNG = "png";
	public static final String GIF = "gif";
	private Integer id;
	private Integer heigth;
	private Integer width;
	private String name;
	private Integer size;
	private String location;
	private String type;
	private Date createOn;
	private Date modifiedDate;

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Column(name = "height", nullable = false)
	public Integer getHeigth() {
		return heigth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "imageId")
	public Integer getId() {
		return id;
	}

	@Column(name = "location", nullable = false)
	public String getLocation() {
		return location;
	}

	@Column(name = "modifiedDate", nullable = false)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "size", nullable = false)
	public Integer getSize() {
		return size;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	@Column(name = "width", nullable = false)
	public Integer getWidth() {
		return width;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setHeigth(Integer heigth) {
		this.heigth = heigth;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}
