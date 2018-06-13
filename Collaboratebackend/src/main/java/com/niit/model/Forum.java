package com.niit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="forum")
public class Forum implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	@Column(unique=true)
	private String forumName;
	private String forumPost;
	private int forumLikes;
	private String userEmailId;
	private String status;
	private Date forumDate;
	
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumPost() {
		return forumPost;
	}
	public void setForumPost(String forumPost) {
		this.forumPost = forumPost;
	}
	public int getForumLikes() {
		return forumLikes;
	}
	public void setForumLikes(int forumLikes) {
		this.forumLikes = forumLikes;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	
}
