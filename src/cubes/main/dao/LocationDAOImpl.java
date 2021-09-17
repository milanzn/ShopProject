package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Location;
@Repository
public class LocationDAOImpl implements LocationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Location> getLocationList() {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Location", Location.class).getResultList();
	}
	
	@Transactional
	@Override
	public void saveLocation(Location location) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(location);
		
	}
	
	@Transactional
	@Override
	public Location getLocationByID(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Location location = session.get(Location.class, id);
		
		return location;
	}
	
	@Transactional
	@Override
	public void deleteLocationByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Location where id=:i");
		q.setParameter("i", id);
		q.executeUpdate();
		
	}

}
