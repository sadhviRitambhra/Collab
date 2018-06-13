package com.niit.dao;

import java.util.List;

import com.niit.model.ForumMember;

public interface ForumMemberDao {

	boolean addForumMember(ForumMember member);
	boolean deleteForumMember(int id);
	boolean editForumMember(ForumMember member);
	ForumMember getMemberByEmailId(String emailId);
	List<ForumMember> getAllMembersByForumId(int forumId);
}
