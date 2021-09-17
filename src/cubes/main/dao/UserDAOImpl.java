package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Role;
import cubes.main.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<User> getAllUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		return session.createQuery("from User", User.class).getResultList();
	}
	
	@Transactional
	@Override
	public void saveUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(user);
		
	}
	
	@Transactional
	@Override
	public void deleteUser(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		
		 Query query = session.createQuery("delete from User where username=:u");
		 query.setParameter("u", username);
		 query.executeUpdate();
		
	}
	
	@Transactional
	@Override
	public User getUserByName(String username) {
		
		Session session = sessionFactory.getCurrentSession();

		User user = session.get(User.class, username);
		
		return user;
	}
	
	@Transactional
	@Override
	public List<Role> getUserRoles() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Role> list = session.createQuery("from Role", Role.class).getResultList();
		return list;
	}

}
