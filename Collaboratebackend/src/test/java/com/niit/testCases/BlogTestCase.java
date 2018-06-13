package com.niit.testCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.BlogCommentDao;
import com.niit.dao.BlogDao;
import com.niit.dao.UserDao;
import com.niit.model.Blog;
import com.niit.model.BlogComments;
import com.niit.model.User;

public class BlogTestCase {

	
	AnnotationConfigApplicationContext context;
	private BlogDao blogDao;
	private BlogCommentDao blogCommentsDao;
    private BlogComments blogComments;
	private	Blog blog;
		
	//@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blog = (Blog) context.getBean("blog");
		blogComments = (BlogComments) context.getBean("blogComments");
		blogDao = (BlogDao) context.getBean("blogDao");
		blogCommentsDao =(BlogCommentDao) context.getBean("blogCommentsDao");
	}
	

	//@Test
	public void testAddBlog() {
		
		boolean flag= false;
		if(blogDao.getBlogByName("TesBlog")!=null)
		{   
			flag =true;
		}

		else 
		{
		blog.setBlogStatus("active");
		blog.setBlogName("TesBlog");
		blog.setUserEmailid("test@gmail.com");
		blog.setBlogDescription("This is a test  a blog !!!");
		blog.setBlogDate(Date.valueOf("1889-06-06"));
		blog.setBlogLikes(0);
		flag =blogDao.addBlog(blog);
		}
			assertEquals(true, flag);
		}
			
			//@Test
			public void testgetBlogById()
			{ 
				blog =blogDao.getBlogById(blogDao.getBlogByName("TesBlog").getBlogId());
				assertNotNull(blog);		
			}
			
			//@Test
			public void testdeleteBlog()
			{
				
				assertEquals(true, blogDao.deleteBlog(blogDao.getBlogByName("TesBlog").getBlogId()));		
			}
			//@Test
			public void testupdateBlog()
			{
				blog=blogDao.getBlogByName("TesBlog");
				blog.setBlogStatus("active");
				assertEquals(true, blogDao.updateBlog(blog));
			}
			//@Test
			public void testupdateLikes()
			{
					assertEquals(true, blogDao.updateLikes(blogDao.getBlogByName("TesBlog").getBlogId()));		
			}

			
			
			
			
			
			
			//@Test
			public void testaddBlogComment() {
				boolean flag =true;
				
				if ((blogCommentsDao.getAllComments(blogDao.getBlogByName("TesBlog").getBlogId()).size()==0)) {
				blogComments.setBlogComment("This is First Bog Comment for Test Blog");
				blogComments.setBlogCommentLikes(0);
				blogComments.setBlogCommenterEmailId("test@gmail.com");
				blogComments.setBlogCommentDate(null);
				blogComments.setBlogId(blogDao.getBlogByName("TesBlog").getBlogId());
				blogComments.setBlogCommentStatus("active");
				//blogComments.setBlogCommentId(2);
			flag =blogCommentsDao.addBlogComment(blogComments);
			}
			assertEquals(true, flag);
		 }
			//@Test
			public void testdeleteBlogComment() {
			assertEquals(true, blogCommentsDao.deleteBlogComment(blogCommentsDao.getAllComments(blogDao.getBlogByName("TesBlog").getBlogId()).get(0).getBlogCommentId()));
			 
		 }  
		 //@Test
		 public void testeditBlogComment() {
			 blogComments= blogCommentsDao.getAllComments(blogDao.getBlogByName("TesBlog").getBlogId()).get(0);
			 blogComments.setBlogCommentStatus("active");
				assertEquals(true, blogCommentsDao.editBlogComment(blogComments));
			 
		 } 
		 }