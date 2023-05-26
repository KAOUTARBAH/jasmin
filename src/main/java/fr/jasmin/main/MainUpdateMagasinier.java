package fr.jasmin.main;


import fr.jasmin.entity.User;
import fr.jasmin.model.dao.impl.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class MainUpdateMagasinier {

	public static void main(String[] args) {

		IUserDao storekeeperDao = new UserDao();
		
		try {
		
			
			User storekeeper = storekeeperDao.getUser(2);
			storekeeper.setName(storekeeper.getName() + "-MAJ");
			storekeeper.setFirstName(storekeeper.getFirstName() + "-MAJ");
			storekeeperDao.updateUser(storekeeper);
			
			//Utilisateur updatedUser = userDao.getUserById(id);
			System.out.println(storekeeper);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
