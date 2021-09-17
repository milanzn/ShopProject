package cubes.main.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cubes.main.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategoryList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category", Category.class).getResultList();
		
		
		return categories;
	}
	

	@Override
	public List<Category> getCategoryListForMainPage() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> list = session.createQuery("from Category c where c.homepage = 1", Category.class).getResultList();
		return list;
	}
	
	@Override
	public void saveCategory(Category category) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		
	}
	
	@Override
	public Category getCategoryByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		if(id==null || id == 0) {
			return null;
		}
		Category cat=session.get(Category.class, id);
		return cat;
	}
	
	@Override
	public void deleteCategoryByID(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		Query query = session.createQuery("delete from Category where id=:i");
		query.setParameter("i", id);
		query.executeUpdate();
		
		
	}


}
