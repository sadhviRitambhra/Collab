package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.BlogCommentDao;
import com.niit.model.BlogComments;

@Repository(value="blogCommentsDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {
@Autowired
private SessionFactory sessionFactory;

public boolean addBlogComment(BlogComments blogComments) {
	boolean flag=false; 
	try {
		sessionFactory.getCurrentSession().save(blogComments);
		flag = true;
	} catch (Exception e) {
		e.printStackTrace();
		flag = false;
	}
	return flag;
}

public BlogComments getBlogCommentById(int blogCommentId) {
	try {
		return (BlogComments) sessionFactory.getCurrentSession().get(BlogComments.class, blogCommentId);
	} catch (Exception e) {
		return null;
	}

}

public boolean deleteBlogComment(int blogCommentId) {
	boolean flag = false;
	try {
		BlogComments blogComments = getBlogCommentById(blogCommentId);
		blogComments.setBlogCommentStatus("inactive");
		sessionFactory.getCurrentSession().update(blogComments);
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;
}

public List<BlogComments> getAllComments(int blogComments) {
	try {
		Query query = sessionFactory.getCurrentSession().createQuery("from BlogComments where (blogId= :blogid and (blogCommentStatus = :active or blogCommentStatus =  :edited ) )");
		query.setParameter("blogid", blogComments);
		query.setParameter("active", "active");
		query.setParameter("edited", "edited");
		return (List<BlogComments>) query.list();
	} catch (Exception ex) {
		return null;
	}
}

public boolean editBlogComment(BlogComments blogComments) {
	boolean flag = false;
	try {
		sessionFactory.getCurrentSession().update(blogComments);
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;

}

public boolean updateBlogCommentLikes(int blogCommentId) {
	boolean flag = false;
	try {
		BlogComments blogComments = getBlogCommentById(blogCommentId);
		blogComments.setBlogCommentLikes(blogComments.getBlogCommentLikes() + 1);
		sessionFactory.getCurrentSession().update(blogComments);
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;
}

}
