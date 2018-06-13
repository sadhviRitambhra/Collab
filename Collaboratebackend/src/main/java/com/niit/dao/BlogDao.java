package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDao {

	Blog getBlogById(int i);
	Blog getBlogByName(String blogName);
	boolean addBlog(Blog blog);
	boolean deleteBlog(int blogId);
	boolean updateBlog(Blog blog);
	boolean updateLikes(int blogId);
	List<Blog>getAllBlog(String UserId);
	boolean editBlog(Blog blog);
}
