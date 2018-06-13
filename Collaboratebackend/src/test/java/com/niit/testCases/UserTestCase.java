package com.niit.testCases;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

//@RunWith(SpringRunner.class)
//@SpringJUnitConfig(classes =AppContext.class)
public class UserTestCase {

	AnnotationConfigApplicationContext context;
	private UserDao userDao;

	//@Autowired
	User user;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user = (User) context.getBean("user");
		userDao = (UserDao) context.getBean("userDao");
	}

	/*@Test
	public void testAddUser() {

		boolean flag = false;
		if (userDao.getUserByUserName("testAdmin") != null) {
			user = userDao.getUserByUserName("testAdmin");
			System.out.println("yes");
			user.setUserJoinDate(Date.valueOf("1994-04-10"));
			user.setUserStatus(true);
			flag = userDao.editUser(user);
		} else {
			user.setUserEmailId("test@gmail.com");
			user.setUserName("testAdmin");
			user.setUserPassword("india");
			user.setUserStatus(true);
			user.setUserGender("test");
			user.setUserPhoneNumber(8712277220L);
			user.setUserJoinDate(Date.valueOf("1994-02-13"));
			flag = userDao.addUser(user);
		}
		assertEquals(true, flag);
	}*/

	
	//@Test
	public void testGetUserByUserName() {
		assertNotNull(userDao.getUserByUserName("testAdmin"));
	}
//	// @Test
//	public void testGetUserByUserName() {
//		assertNotNull(userDao.getUserByUserName("testAdmin"));
//		
		//@Test
		public void testValidUser() {
			fail("Not yet implemented");
		}

		//@Test
		public void testEditUser() {
			User user = new User();
			user = userDao.getUserByUserName("testAdmin");
			user.setUserGender("female");
			assertEquals(true, userDao.editUser(user));
		}

		//@Test
		public void testGetUserbyUserId() {
			User user = new User();
			user = userDao.getUserByUserName("testAdmin");
			assertNotNull(userDao.getUserbyUserId(user.getUserId()));
		}

		//@Test
		public void testGetAllUsers() {
			assertNotNull(userDao.getAllUsers().size());
		}

		//@Test
		public void testDeleteUser() {
			User user = new User();
			user = userDao.getUserByUserName("testAdmin");
			assertEquals(true, userDao.deleteUser(user.getUserId()));
		
	}

}
