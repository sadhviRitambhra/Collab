package com.niit.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="blogComments")
public class BlogComments implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int blogCommentId;
private int blogId;
private String blogComment;
private String blogCommenterEmailId; 
private int blogCommentLikes;
private String blogCommentStatus;
private Date blogCommentDate;

public BlogComments(){}

public int getBlogCommentId() {
	return blogCommentId;
}
public void setBlogCommentId(int blogCommentId) {
	this.blogCommentId = blogCommentId;
}
public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public String getBlogComment() {
	return blogComment;
}
public void setBlogComment(String blogComment) {
	this.blogComment = blogComment;
}
public String getBlogCommenterEmailId() {
	return blogCommenterEmailId;
}
public void setBlogCommenterEmailId(String blogCommenterEmailId) {
	this.blogCommenterEmailId = blogCommenterEmailId;
}
public int getBlogCommentLikes() {
	return blogCommentLikes;
}
public void setBlogCommentLikes(int blogCommentLikes) {
	this.blogCommentLikes = blogCommentLikes;
}
public String getBlogCommentStatus() {
	return blogCommentStatus;
}
public void setBlogCommentStatus(String blogCommentStatus) {
	this.blogCommentStatus = blogCommentStatus;
}
public Date getBlogCommentDate() {
	return blogCommentDate;
}
public void setBlogCommentDate(Date blogCommentDate) {
	this.blogCommentDate = blogCommentDate;
}

}
