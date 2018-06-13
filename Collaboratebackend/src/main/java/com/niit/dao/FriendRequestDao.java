package com.niit.dao;

import java.util.List;

import com.niit.model.FriendRequest;

public interface FriendRequestDao {

	FriendRequest sendRequest(FriendRequest request);
	List<FriendRequest> allFriends(String userEmailId);
	boolean editRequest(FriendRequest request);
	FriendRequest getrequestById(int id);
}
