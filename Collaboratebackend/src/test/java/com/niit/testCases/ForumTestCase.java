package com.niit.testCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumCommentsDao;
import com.niit.dao.ForumDao;
import com.niit.dao.ForumMemberDao;
import com.niit.model.Forum;
import com.niit.model.ForumComments;
import com.niit.model.ForumMember;

public class ForumTestCase {

	AnnotationConfigApplicationContext context;
	private ForumDao forumDao;
	private Forum forum;
	private ForumCommentsDao forumCommentsDao;
	private ForumComments forumComments;
	private ForumMember forumMember;
	private ForumMemberDao forumMemberDao;
	

		@Before
		public void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			forumCommentsDao = (ForumCommentsDao) context.getBean("forumCommentsDao");
			forumComments = (ForumComments) context.getBean("forumComments");
			forum = (Forum) context.getBean("forum");
			forumDao = (ForumDao) context.getBean("forumDao");
			forumMember = (ForumMember) context.getBean("forumMember");
			forumMemberDao = (ForumMemberDao) context.getBean("forumMemberDao");
		}
		
		//@Test
	    public void testAddForum() {
			boolean flag=false;
			if (forumDao.getForumByName("TestForum") == null) {
				forum.setUserEmailId("testAdmin@gmail.com");
				forum.setForumName("TestForum");
				forum.setForumPost("This is my first forum");
				forum.setStatus("active");
				forum.setForumLikes(0);
				forum.setForumDate(null);
				flag = forumDao.addForum(forum);
			} 
			
			else {
				forum = forumDao.getForumByName("TestForum");
				forum.setStatus("active");
				flag = forumDao.updateForum(forum);
			}
			assertEquals(true, flag);
		}

		//@Test
		public void testAddForumComment() {

			forumComments.setForumComment("first forum comment");
			forumComments.setForumCommenterEmailId("TestAdmin@gmial.com");
			forumComments.setForumStatus("active");
			forumComments.setForumId(forumDao.getForumByName("TestForum").getForumId());
			assertEquals(true, forumCommentsDao.addForumComment(forumComments));
		}

		//@Test
		public void testEditForumComment() {
			forumComments = forumCommentsDao.getAllComments(forumDao.getForumByName("TestForum").getForumId()).get(0);
			forumComments.setForumStatus("active");
			assertEquals(true, forumCommentsDao.editForumComment(forumComments));
		}

		//@Test
		public void testDeleteForumComment() {
			forumComments = forumCommentsDao.getAllComments(forumDao.getForumByName("TestForum").getForumId()).get(0);
			assertEquals(true, forumCommentsDao.deleteForumComment((forumComments.getForumCommentId())));
		}

		//@Test
		public void testUpdateForumCommentLikes() {
			forumComments = forumCommentsDao.getAllComments(forumDao.getForumByName("TestForum").getForumId()).get(0);
			assertEquals(true, forumCommentsDao.updateForumCommentLikes(forumComments.getForumCommentId()));
		}

		//@Test
		public void testdeleteForum() {
			assertEquals(true, forumDao.deleteForum(forumDao.getForumByName("TestForum").getForumId()));
		}

		//@Test
		public void testupdateForum() {
			forum = forumDao.getForumByName("TestForum");
			forum.setStatus("active");
		}

		//@Test
		public void testupdateLikes() {
			assertEquals(true, forumDao.updateLikes(forumDao.getForumByName("TestForum").getForumId()));
		}

		//@Test
		public void testgetAllForum() {
			assertNotEquals(0, forumDao.getAllForum("testAdmin@gmail.com").size());
		}

		/*//@Test
		public void testdeleteForumMember() {
			assertEquals(true, forumMemberDao.deleteForumMember("testAdmin@gmail.com"));
		}
*/
		//@Test
		public void testeditForumMember() {
			forumMember = forumMemberDao.getMemberByEmailId("testAdmin@gmail.com");
			forumMember.setForumStatus("active");
			assertEquals(true, forumMemberDao.editForumMember(forumMember));
		}

		//@Test
		public void testgetAllMembersByForumId() {
			forumMember = forumMemberDao.getMemberByEmailId("testAdmin@gmail.com");
			assertNotNull(forumMemberDao.getAllMembersByForumId(forumMember.getForumId()));
		}
}


