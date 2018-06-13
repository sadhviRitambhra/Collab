package com.niit.dao;

import java.util.List;

import com.niit.model.ForumComments;

public interface ForumCommentsDao {

	boolean addForumComment(ForumComments forumComments); 	
	boolean deleteForumComment(int forumCommentId);
	List<ForumComments> getAllComments(int forumComments);
	boolean editForumComment(ForumComments forumComments);
	boolean updateForumCommentLikes(int forumCommentsId);
	ForumComments getForumCommentById(int forumCommentId);
}
