package cubes.main.dao;


import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Product> getProductList() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("From Product", Product.class).getResultList();

		return list;
	}
	
	@Transactional
	@Override
	public List<Product> getProductListWithStickers() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("From Product", Product.class).getResultList();
		for(Product p: list) {
			Hibernate.initialize(p.getStickers());
		}
		return list;
	}
	
	@Transactional
	@Override
	public List<Product> getProductListForMainPage() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Product> list = session.createQuery("from Product p where p.homepage = 1", Product.class).getResultList();
		
		for(Product p: list) {
			Hibernate.initialize(p.getStickers());
		}
		return list;
	}
	
	@Transactional
	@Override
	public void saveProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(product);
		
	}
	
	@Transactional
	@Override
	public void deleteProduct(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Product where id=:i");
		query.setParameter("i", id);
		query.executeUpdate();
		
		
	}
	
	@Transactional
	@Override
	public Product getProductById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Product p = session.get(Product.class, id);
		Hibernate.initialize(p.getStickers());
		return p;
	}
	
	@Transactional
	@Override
	public List<Product> getProductListByCategoryId(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		String q = "from Product p where p.category.id =" + id;
		List<Product> list = session.createQuery(q, Product.class).getResultList();
		
		return list;
	}
	
	@Transactional
	@Override
	public List<Product> getProductList(Integer category, Integer price, Integer[] stickersArray) {
		Session session = sessionFactory.getCurrentSession();
		
		
		// Kreiram Query String u zavisnosti od ulaznih parametara u metodu:
		
		String queryString = "";
		
		if(stickersArray!=null) {
			
			queryString = "select distinct p from Product p left join p.stickers s ";
		
		}

		else {
			queryString = "from Product p ";
		}
		
		
		if (category!=null && category>0) {
			queryString = queryString + "where p.category.id=: categoryID";
			
		}
		
		if (price!=null && price>0) {
			
			if(!queryString.contains("where")) {
				
				queryString = queryString + "where ";
			}
			else {
				queryString = queryString + " and ";
			}
			
			queryString = queryString + " p.price <: price";
			
		}
		

			// --------------------- STICKER ---------------------
		
		if(stickersArray!=null && stickersArray.length >0) {
			
			if(!queryString.contains("where")) {
				
				queryString = queryString + "where ";
			}
			else {
				queryString = queryString + " and ";
			}
	
			queryString = queryString + "s.id in (:stickers)";
		}
		
		// Stampanje query Stringa u konzoli, radi provere
		System.out.println(queryString);
		
		 Query q = session.createQuery(queryString);
		
		// Dodajem parametre za query
		
		if (category!=null && category>0) {
			q.setParameter("categoryID", category);
			
		}
		
		if (price!=null && price>0) {
			q.setParameter("price", (double)(price * 5000));
			
		}
		
		if(stickersArray!=null && stickersArray.length >0) {
			
				q.setParameterList("stickers", stickersArray);
		
		}
	

	List<Product> list = q.getResultList();
	
	for(Product p: list) {
		Hibernate.initialize(p.getStickers());
	}
	
	return list;
	}
	
	
	/*
	@Transactional
	@Override
	public List<Product> getProductList(String text) {
		
		Session session = sessionFactory.getCurrentSession();
		
		
		String q = "From Product p where p.title like :text or p.description like :text";
		Query query = session.createQuery(q);
		query.setParameter("text", "%" + text + "%");
		List<Product> list = query.getResultList();
		
		for(Product p: list) {
			Hibernate.initialize(p.getStickers());
		}
		
		return list;
	}
*/
	
	
	// Ne treba kombinovati Criteria i Query, ali sledeca metoda je uradjena radi vezbe i demonstracije:
	
	@Transactional
	@Override
	public List<Product> getProductList(String text) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		Criterion criteriaTitle = Restrictions.like("title", "%" + text + "%");
		Criterion criteriaDesription = Restrictions.like("description", "%" + text + "%");
		LogicalExpression orExp = Restrictions.or(criteriaTitle, criteriaDesription);
		criteria.add(orExp);
		
	List<Product> list = criteria.list();
		
		for(Product p: list) {
			Hibernate.initialize(p.getStickers());
			
		}
		
		return list;
	}




}
