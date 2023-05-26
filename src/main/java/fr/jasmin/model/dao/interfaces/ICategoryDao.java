package fr.jasmin.model.dao.interfaces;

import java.util.List;

import fr.jasmin.entity.Category;
import fr.jasmin.entity.User;

public interface ICategoryDao {
	
	Category addCategory(Category category) throws Exception ;
	Category getCategory(Integer id) throws Exception;
	void updateCategory(Category category) throws Exception;
	void removeCategory(Integer id) throws Exception;
	void removeCategory(Category category) throws Exception;
	List<Category> getCategorys() throws Exception;	
	
	
	
//	void removeUser2(Integer id) throws Exception;
	
//	User getUserByEmail(String email);
//	List<User> getUsersOfVille(String ville);
//	Map<String, List<User>> getUsersByVille();

}
