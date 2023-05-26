package fr.jasmin.main;


import fr.jasmin.entity.User;
import fr.jasmin.model.dao.impl.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;

public class MainDeleteMagasinier {

	public static void main(String[] args) {

		IUserDao storekeeperDao = new UserDao();

		try {
			
			User storekeeper = storekeeperDao.getUser(2);
			System.out.println(storekeeper);
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println(storekeeper.getId());
			//userDao.removeUser(user);
			storekeeperDao.removeUser(2);
			System.out.println(storekeeper);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
