package fr.jasmin.main;

import java.util.List;


import fr.jasmin.entity.User;
import fr.jasmin.model.dao.impl.UserDao;
import fr.jasmin.model.dao.interfaces.IUserDao;


public class MainGetMagasinier {

	public static void main(String[] args) {

		IUserDao storekeeperDao = new UserDao();
		
		try {
			List<User> users = storekeeperDao.getUsers();
			for (User storekeeper : users) {
				System.out.println(storekeeper);
				storekeeper.getAdresses().forEach(a -> System.out.println("  -> " + a));
			}
			
			System.out.println("==========================================");
			System.out.println("=========by id===========================");
			User storekeeper = storekeeperDao.getUser(8);
			System.out.println(storekeeper);
			storekeeper.getAdresses().forEach(a -> System.out.println("  -> " + a));
			
//			
//			User user = userDao.getUserByEmail("blaise@gmail.com");
//			System.out.println(user);
//			user.getAdresses().forEach(a -> System.out.println("  -> " + a));
//
//			System.out.println("==========================================");
//			
//			List<User> users2 = userDao.getUsersOfVille("Paris");
//			for (User user2 : users2) {
//				System.out.println(user2);
//				user2.getAdresses().forEach(a -> System.out.println("  -> " + a));
//			}
//
//			System.out.println("==========================================");
//			
//			Map<String, List<User>> map = userDao.getUsersByVille();
//			for (Map.Entry<String, List<User>> entry : map.entrySet()) {
//				String ville = entry.getKey();
//				System.out.println("Ville : " + ville);
//				List<User> users3 = entry.getValue();
//				for (User user3 : users3) {
//					System.out.println("  => " + user3);
//					user3.getAdresses().forEach(a -> System.out.println("  -> " + a));
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
