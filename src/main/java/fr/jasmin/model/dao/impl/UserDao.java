package fr.jasmin.model.dao.impl;


import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import fr.jasmin.entity.User;
import fr.jasmin.enums.ProfileUserEnum;
import fr.jasmin.model.connector.HibernateConnector;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class UserDao implements IUserDao {
	
	public UserDao() {
		
	}
	
	
	@Override
	public User addUser(User user) throws Exception {
		//le cryptage de passeword
				user.encryptUser();
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null;
		
		
		try {
			
			tx = session.beginTransaction();
			
					
				
			session.save(user);
		//	user.getCartesPaiemants().forEach(cp -> session.save(cp));
		//	user.getAdresses().forEach(a -> session.save(a));
			tx.commit();
			
		} catch (RollbackException e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public User getUser(Integer id) throws Exception {
		
		
		Session session = HibernateConnector.getSession();
		User user = null;
		try {
			
			
			//magasinier = session.find(Utilisateur.class, id);
			
			
			Query query = session.createQuery("select u from User u  WHERE u.profile = :profile and u.id =:id");
			//query.setParameter("profil","magasinier" );
			query.setParameter("profile",ProfileUserEnum.MAGASINIER.getValue() );
			//super.marque.equals(MarqueVoitureEnum.FERRARI.getValue()
			query.setParameter("id", id);
			//magasiners = query.getResultList();
			user = (User) query.getSingleResult();
			user.decryptUser();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}


	@Override
	public void updateUser(User user) throws Exception {
		
		Session session = HibernateConnector.getSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			session.update(user);
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
	public void removeUser(Integer id) throws Exception {
		User magasinier = new User();
		magasinier = getUser(id);
		removeUser(magasinier);
		
	}
	
	
	@Override
	public void removeUser(User user) throws Exception {
		Session session = HibernateConnector.getSession();
		Transaction tx = null ;
		try {
			tx = session.beginTransaction();
			session.remove(user);
			//session.delete(id);
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
	public List<User> getUsers() throws Exception {
		Session session = HibernateConnector.getSession();
		List<User> magasiners ;
		//User user = new User();
		
		try {
			
			//user.decrypt();
			
			//Query query = session.createQuery("select u from Utilisateur u");
			
			Query query = session.createQuery("select u from User u  WHERE u.profile = :profile");
			query.setParameter("profile",ProfileUserEnum.MAGASINIER.getValue() );
			magasiners = query.getResultList();
			for (User user : magasiners) {
				user.decryptUser();
			}
			
			
		} finally {;
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return magasiners;
		
	}

	

	@Override
	public User getUserByEmail(String email) throws Exception {
		
		Session session = HibernateConnector.getSession();
		User user = null;
		try {
			// requête JPQL
			Query<User> query = session.createQuery("FROM User u WHERE u.email = ?1", User.class);
			query.setParameter(1, email);
			user = query.uniqueResult();   //user = query.getSingleResult();

			// requête prédéfinie
//			Query<User> query = session.createNamedQuery("User:findByEmail", User.class);
//			query.setParameter("email", email);
//			user = query.uniqueResult();
			
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	
}
