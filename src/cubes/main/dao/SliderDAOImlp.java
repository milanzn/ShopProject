package cubes.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Slider;


@Repository
public class SliderDAOImlp implements SliderDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Slider> getSliderList() {
		Session session = sessionFactory.getCurrentSession();
		List<Slider> list = session.createQuery("from Slider", Slider.class).getResultList();
		
		return list;
	}
	
	@Transactional
	@Override
	public void saveSlider(Slider s) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(s);
	}
	
	@Transactional
	@Override
	public Slider getSliderByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		
		return session.get(Slider.class, id);
	}
	
	@Transactional
	@Override
	public void deleteSliderByID(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		// Slider s = session.get(Slider.class, id); // imamo 2 upita
		// session.delete(s);
		
		Query q = session.createQuery(" delete Slider s where s.id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		
	}

}
