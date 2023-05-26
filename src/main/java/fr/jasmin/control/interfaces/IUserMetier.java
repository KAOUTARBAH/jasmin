package fr.jasmin.control.interfaces;

import java.util.List;

import fr.jasmin.entity.User;


public interface IUserMetier {

	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void deleteUser(User user) throws Exception;
}
