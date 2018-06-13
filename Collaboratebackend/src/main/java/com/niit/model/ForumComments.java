package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "forumComments")

public class ForumComments implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  forumCommentId;
	private int forumId;
	private String forumComment;
	private String forumCommenterEmailId;
	private int forumLikes;
	private String forumStatus;
	
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumComment() {
		return forumComment;
	}
	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}
	public String getForumCommenterEmailId() {
		return forumCommenterEmailId;
	}
	public void setForumCommenterEmailId(String forumCommenterEmailId) {
		this.forumCommenterEmailId = forumCommenterEmailId;
	}
	public int getForumLikes() {
		return forumLikes;
	}
	public void setForumLikes(int forumLikes) {
		this.forumLikes = forumLikes;
	}
	public String getForumStatus() {
		return forumStatus;
	}
	public void setForumStatus(String forumStatus) {
		this.forumStatus = forumStatus;
	}

	

}
