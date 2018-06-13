package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComments;

public interface BlogCommentDao {

	boolean addBlogComment(BlogComments blogComments); 	
	boolean deleteBlogComment(int blogCommentId);
	BlogComments getBlogCommentById(int blogCommentId);
	List<BlogComments> getAllComments(int blogComments);
	boolean editBlogComment(BlogComments blogComments);
	boolean updateBlogCommentLikes(int blogCommentId);
}
