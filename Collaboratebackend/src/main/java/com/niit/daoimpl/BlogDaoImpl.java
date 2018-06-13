package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.BlogDao;
import com.niit.model.Blog;

@Repository(value="blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {
@Autowired
private SessionFactory sessionFactory;

public Blog getBlogById(int blogId) {
	try {
		System.out.println(blogId);
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogId);
	} catch (Exception e) {
		return null;
	}
}

public boolean addBlog(Blog blog) {
	boolean flag = false;
	try {
		Session session = sessionFactory.getCurrentSession();
		session.save(blog);
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;
}

public boolean deleteBlog(int blogId) {
	boolean flag = false;
	try {
		Blog blog = getBlogById(blogId);
		blog.setBlogStatus("inactive");
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		session.flush();
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;

}

public Blog getBlogByName(String blogName) {
	try {
		Query query = sessionFactory.getCurrentSession().createQuery("from Blog where blogName= :blogname");
		query.setString("blogname", blogName);
		return (Blog) query.uniqueResult();
	} catch (Exception e) {
		return null;
	}

}

public boolean updateBlog(Blog blog) {
	boolean flag = false;
	try {
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		session.flush();
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;

}

public boolean updateLikes(int blogId) {
	boolean flag = false;
	try {
		Blog blog = getBlogById(blogId);
		blog.setBlogLikes(blog.getBlogLikes() + 1);
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
		session.flush();
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;
}

public List<Blog> getAllBlog(String userId) {
	try {
		System.out.println(userId);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Blog where userEmailId = :userid and blogStatus= :active");
		query.setString("userid", userId);
		query.setString("active", "active");
		List<Blog> blog = (List<Blog>) query.list();
		return blog;
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public boolean editBlog(Blog blog) {
	// TODO Auto-generated method stub
	return false;
}
}
