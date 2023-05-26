package fr.jasmin.main;


import javax.crypto.SecretKey;


import fr.jasmin.entity.Address;
import fr.jasmin.entity.BankCard;
import fr.jasmin.entity.Param;
import fr.jasmin.entity.User;
import fr.jasmin.enums.CryptageEnum;
import fr.jasmin.enums.ProfileUserEnum;
import fr.jasmin.model.dao.impl.ParamDao;
import fr.jasmin.model.dao.impl.UserDao;
import fr.jasmin.model.dao.interfaces.IParamDao;
import fr.jasmin.model.dao.interfaces.IUserDao;
import fr.jasmin.utils.DataTest;
import fr.jasmin.utils.Dates;
import fr.jasmin.utils.Utils;

public class AddUser {

	public static void main(String[] args) {
		System.out.println("***********************début de test**********************");
		IUserDao storekeeperDao = new UserDao();
		IParamDao paramDao = new ParamDao();
		try {	
			
			User user = new User(DataTest.lastname(), DataTest.firstname());
			String firstName = DataTest.firstname();
			String lastName = DataTest.lastname();
			user.setBirhDate(Dates.convertStringToDate("09/07/2004"));
			String email = DataTest.email(firstName, lastName);
			user.setEmail(email);
			user.setPasswordClear("doha_@test2023");
			user.setProfile(ProfileUserEnum.MAGASINIER.getValue());
			user.setIsActif(true);
			user.setPhone(DataTest.phone());
			
			
			Address address = null; 
			BankCard bankCard = null;
	
			for (int index = 0 ; index < 4; index++) {
					
				address = new Address(String.format("%d", Utils.randInt(1, 100)), DataTest.street(), DataTest.city(), DataTest.zipcode()) ;
					
				address.setUser(user);
				
				user.getAdresses().add(address);
				System.out.println(address);
				
				
				bankCard = new BankCard();
				bankCard.setNameOwner(lastName);
				bankCard.setFirstNameOwner(firstName);
				bankCard.setReelNubmer("3467899867454567");
				bankCard.setDateFinValidite(Dates.convertStringToDate("09/07/2024"));
				bankCard.setReelCryptogram("356");
				
				bankCard.setUser(user);	
				user.getBankCardList().add(bankCard);
				System.out.println(bankCard);
				
			}
				
				
//			Address address1 = new Address("100", "Rue Paul Vaillant Couturier", "Paris", "75000");
//			Address address2 = new Address("3", "Avenue Victor Hugo", "Lyon", "69000");
//			
			
			
			
			
			
//			BankCard paiementCard1 = new BankCard();
//			paiementCard1.setNameOwner(lastName);
//			paiementCard1.setFirstNameOwner(firstName);
//			paiementCard1.setReelNubmer("3467899867454567");
//			paiementCard1.setDateFinValidite(Dates.convertStringToDate("09/07/2024"));
//			paiementCard1.setReelCryptogram("356");
//			
//			
//			BankCard paiementCard2 = new BankCard();
//			paiementCard2.setNameOwner("DOHA");
//			paiementCard2.setFirstNameOwner("Jamila");
//			paiementCard2.setReelNubmer("1007668867454457");
//			paiementCard2.setDateFinValidite(Dates.convertStringToDate("09/07/2024"));
//			paiementCard2.setReelCryptogram("120");
			
			
//			address1.setUser(user);
//			user.getAdresses().add(address1);
//			address2.setUser(user);		
//			user.getAdresses().add(address2);
//			
//			
//			paiementCard1.setUser(user);
//			paiementCard2.setUser(user);
//			
//			user.getBankCardList().add(paiementCard1);
//			user.getBankCardList().add(paiementCard2);
//			
			storekeeperDao.addUser(user);
			System.out.println(user);
			user.getAdresses().forEach(a -> System.out.println("  -> " + a));
			user.getBankCardList().forEach(a -> System.out.println("  -> " + a));
			
			
//			User user1 = new User("DOHA", "Jamila");
//			user1.setBirhDate(Dates.convertStringToDate("09/07/2004"));
//			String firstName = DataTest.firstname();
//			String lastName = DataTest.lastname();
//			String email = DataTest.email(firstName, lastName);
//			user1.setEmail(email);
//			//user1.setPassword("testAyoub");
//			//user1.setPassword(EncryptionAlgorithm.encrypt("mrn354596",securityKey1,aes));
//			user1.setPasswordClear("doha_@test2023");
////			user1.setPassword(user1.getPassword());
//			//user1.setProfil("magasinier");
//			user1.setProfile(ProfileUserEnum.MAGASINIER.getValue());
//			user1.setIsActif(true);
//			user1.setPhone("0033567645673");
//			
			
//			User user2 = new User("Ihsanoo", "Amal");
//			user2.setBirhDate(Dates.convertStringToDate("23/08/2007"));
//			user2.setEmail("amal@gmailERER.com");
//			user2.setPassword(user2.getPassword());
//			//user2.setPassword(EncryptionAlgorithm.encrypt("Ehsan56487",securityKey1,aes));
//			//user2.setPassword("testNahla");
//			user2.setProfile(ProfileUserEnum.MAGASINIER.getValue());
//			user2.setIsActif(true);
//			user2.setPhone("0033562224123");
				
			
//			address1.setUser(user1);
//			user1.getAdresses().add(address1);
			//address2.setUser(user2);		
			//user2.getAdresses().add(address2);
			
			
			//ajouter la cles de cryptage dans le tableu param
//			Param cle1 = new Param();
//			cle1.setCleByte(securityKey1.getEncoded());
//			cle1.setAlgoritm(aes);
//			paramDao.addSecurityKey(cle1);
			
			
			
			
//			//user2.getAdresses().add(address2);
//			
//			storekeeperDao.addUser(user1);
//			System.out.println(user1);
//			user1.getAdresses().forEach(a -> System.out.println("  -> " + a));
//			user1.getBankCardList().forEach(a -> System.out.println("  -> " + a));

			
	//		storekeeperDao.addStorekeeper(user2);
	//		System.out.println(user2);
	//		user2.getAdresses().forEach(a -> System.out.println("  -> " + a));
			
			//afficher la cle de sécurite généré
	//		System.out.println("SecurityKey généré : " + cle1.convertCleByeToCleSercet().securityKey1.Param);
			
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
		System.out.println("***********************fin de test**********************");

	}

}
