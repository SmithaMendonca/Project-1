package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;			
		}
		catch(Exception e) {
			System.out.println("Error:"+e);
			return false;			
		}				
		
	}

	@Override
	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;			
		}
		catch(Exception e) {
			System.out.println("Error:"+e);
			return false;			
		}					
	}

	@Override
	public UserDetail getUserDetail(int userId) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,userId);
		session.close();
		return user;
	}

}
