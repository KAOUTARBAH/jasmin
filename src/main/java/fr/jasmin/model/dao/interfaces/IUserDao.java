package fr.jasmin.model.dao.interfaces;

import java.util.List;

import fr.jasmin.entity.User;

public interface IUserDao {
	
	User addUser(User user) throws Exception ;
	User getUser(Integer id) throws Exception;
	void updateUser(User user) throws Exception;
	void removeUser(Integer id) throws Exception;
	List<User> getUsers() throws Exception;	
	void removeUser(User user) throws Exception;
	User getUserByEmail(String email) throws Exception;
	
	
//	void removeUser2(Integer id) throws Exception;
	

//	List<User> getUsersOfVille(String ville);
//	Map<String, List<User>> getUsersByVille();

}
