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
@Table(name="forumMember")
public class ForumMember implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumMemberId;
	private int forumId;
	@Column(unique=true)
	private String memberEmailId;
	private String forumStatus;
	private Date forumDate;
	public int getForumMemberId() {
		return forumMemberId;
	}
	public void setForumMemberId(int forumMemberId) {
		this.forumMemberId = forumMemberId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getMemberEmailId() {
		return memberEmailId;
	}
	public void setMemberEmailId(String memberEmailId) {
		this.memberEmailId = memberEmailId;
	}
	public String getForumStatus() {
		return forumStatus;
	}
	public void setForumStatus(String forumStatus) {
		this.forumStatus = forumStatus;
	}
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	
	
	
}
