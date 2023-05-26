package fr.jasmin.model.dao.impl;


import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.jasmin.entity.Category;
import fr.jasmin.entity.User;
import fr.jasmin.enums.ProfileUserEnum;
import fr.jasmin.model.connector.HibernateConnector;
import fr.jasmin.model.dao.interfaces.ICategoryDao;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class CategoryDao implements ICategoryDao {
	
	public CategoryDao() {
		
	}
	
	@Override
	public Category addCategory(Category category) throws Exception {
	
		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		
		try {
			
			tx = session.beginTransaction();
			session.save(category.getItems());
			session.save(category);
			//	category.getItems().forEach(item -> session.save(item));
		
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return category;
	}

	
	@Override
	public Category getCategory(Integer id) throws Exception {
		
		
		Session session = HibernateConnector.getSession();
		Category category = null;
		try {
			
			category = session.find(Category.class, id);	
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return category;
	}


	@Override
	public void updateCategory(Category category) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			session.update(category);
			tx.commit();
			
			
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			
		}
		
		
	}


	@Override
	public void removeCategory(Integer id) throws Exception {
		Category category = new Category();
		category = getCategory(id);
		removeCategory(category);
		
	}
	
	
	@Override
	public void removeCategory(Category category) throws Exception {
		Session session = HibernateConnector.getSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			session.remove(category);
			tx.commit();
			
		} catch(Exception ex) {
			if(tx != null) {
				tx.rollback();
			}
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			
		}
		
	}
	
	@Override
	public List<Category> getCategorys() throws Exception {
		Session session = HibernateConnector.getSession();
		List<Category> categorys ;
		
		try {
			
			Query<Category> query = session.createNamedQuery("Category:findAll", Category.class);
			categorys = query.list();  // permet de récupérer toutes les colonnes

			
		} finally {;
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return categorys;
		
	}

	

	

	
}
