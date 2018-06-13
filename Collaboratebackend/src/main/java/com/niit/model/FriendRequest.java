package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="FriendRequest")
public class FriendRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendRequestId;
	private String fromEmailId;
	private String toEmailId;
	private String requestStatus;
	
	public FriendRequest(){}
	
	public int getFriendRequestId() {
		return friendRequestId;
	}
	public void setFriendRequestId(int friendRequestId) {
		this.friendRequestId = friendRequestId;
	}
	public String getFromEmailId() {
		return fromEmailId;
	}
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}
	public String getToEmailId() {
		return toEmailId;
	}
	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	
}
