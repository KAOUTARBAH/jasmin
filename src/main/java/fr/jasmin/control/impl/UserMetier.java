package fr.jasmin.control.impl;

import java.util.ArrayList;
import java.util.List;

import fr.jasmin.control.interfaces.IUserMetier;
import fr.jasmin.entity.User;
import fr.jasmin.model.dao.impl.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;


public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer ne doit pas être null !");
		}
		user.setName(user.getName().toUpperCase());
		user.setFirstName(user.getFirstName().substring(0, 1).toUpperCase()
						.concat(user.getFirstName().substring(1).toLowerCase()));
		return userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		List<User> tempListUser = new ArrayList<User>();
		tempListUser = userDao.getUsers();
		return userDao.getUsers();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userDao.removeUser(user.getId());
		
	}

}
