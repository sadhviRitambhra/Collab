package com.niit.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="blog")
public class Blog implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogId;
	private String blogDescription;
	@Column(unique=true)
	private String blogName;
	private int blogLikes;
	private String userEmailid;
	private String blogStatus;
	private Date blogDate;

	public Blog() {}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public int getBlogLikes() {
		return blogLikes;
	}

	public void setBlogLikes(int blogLikes) {
		this.blogLikes = blogLikes;
	}

	public String getUserEmailid() {
		return userEmailid;
	}

	public void setUserEmailid(String userEmailid) {
		this.userEmailid = userEmailid;
	}

	public String getBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}

	public Date getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
	

}
