package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.FriendRequestDao;
import com.niit.model.FriendRequest;
@Repository(value="friendRequestDao")
@Transactional
public class FriendRequestDaoImpl implements FriendRequestDao{
@Autowired
private SessionFactory sessionFactory;

public FriendRequest sendRequest(FriendRequest request) {
	boolean flag = false;
	try {
		Session session = sessionFactory.getCurrentSession();
		request.setRequestStatus("pending");
		session.save(request);
		session.flush();
		return getrequestById(request.getFriendRequestId());
	} catch (Exception e) {
		return null;
	}
	
}

public List<FriendRequest> allFriends(String userEmailId) {

	try {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from FriendRequest where (fromEmailId= :fromemailId or toEmailId= :toemailId)");
		query.setParameter("fromemailId", userEmailId);
		query.setParameter("toemailId", userEmailId);
		List<FriendRequest> listFriends = (List<FriendRequest>) query.list();
		return listFriends;
	} catch (Exception ex) {
		return null;
	}
}

public boolean editRequest(FriendRequest request) {
	boolean flag = false;
	try {
		sessionFactory.getCurrentSession().update(request);
		flag = true;
	} catch (Exception e) {
		flag = false;
	}
	return flag;

}

@Override
public FriendRequest getrequestById(int id) {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().get(FriendRequest.class, id);
}

}

