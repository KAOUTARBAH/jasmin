package fr.jasmin.backingbean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;



import fr.jasmin.control.impl.UserMetier;
import fr.jasmin.control.interfaces.IUserMetier;
import fr.jasmin.entity.User;


@ManagedBean(name = "userbean")
public class UserBean {
	
	// injection de dépendance
//	@ManagedProperty(value = "#{adressbean}")
//	private AdressBean adressBean;
	
	@ManagedProperty(name = "name", value = "DUPONT")
	private String name;

	@ManagedProperty(name = "firstName", value = "Michel")
	private String firstName;
	
	//private Date birhDate;
	
	//@ManagedProperty(name = "profile", value="#{false})
	private Boolean isActif;
	
	
//	@ManagedProperty(name = "profile", value= "Magasinier")
//	private String profile;
	
	@ManagedProperty(name = "email", value = "dupont.michel@doranco.fr")
	private String email;
	
	private byte[] password;
	
	private byte[] passwordConfirmation;
	
	private String passwordClear ;
	
	
//	@ManagedProperty(name = "phone", value = "0753567898")
//	private String phone;
	
	private String messageSuccess;
	private String messageError;
	
	private final IUserMetier userMetier = new UserMetier();
	
	
	public UserBean() {
		
		messageSuccess = "";
		messageError = "";
		
	}

	

//	public UserBean(String name, String firstName) {
//		super();
//		this.name = name;
//		this.firstName = firstName;
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



//	public Date getBirhDate() {
//		return birhDate;
//	}

//
//	public void setBirhDate(Date birhDate) {
//		this.birhDate = birhDate;
//	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


//	public String getProfile() {
//		return profile;
//	}
//
//
//	public void setProfile(String profile) {
//		this.profile = profile;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getPassword() {
		return password;
	}


	public void setPassword(byte[] password) {
		this.password = password;
	}


//	public byte[] getPasswordConfirmation() {
//		return passwordConfirmation;
//	}
//
//
//	public void setPasswordConfirmation(byte[] passwordConfirmation) {
//		this.passwordConfirmation = passwordConfirmation;
//	}


	public String getPasswordClear() {
		return passwordClear;
	}


	public void setPasswordClear(String passwordClear) {
		this.passwordClear = passwordClear;
	}


//	public String getPhone() {
//		return phone;
//	}
//
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	
//	
	
	public String getMessageSuccess() {
		return messageSuccess;
	}


	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}


	public String getMessageError() {
		return messageError;
	}


	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	

//	public AdressBean getAdressBean() {
//		return adressBean;
//	}



	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la récupération de la liste des utilisateurs !\n"
					+ e.getMessage();
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	private void initializeUser() {
		this.name = "";
		this.firstName = "";
		this.email = "";
		//this.birhDate = null;
	//	this.phone="";
	
	}
	
	public String addUserBean() {
		try {
//			if (!password.equals(passwordConfirmation)) {
//				messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
//				messageSuccess = "";
//				return "";
//			}

			User user = new User();
			
			user.setName(name);
			user.setFirstName(firstName);
//			user.setBirhDate(birhDate);
			user.setEmail(email);
//			user.setPassword(password);
//			user.setPhone(phone);
//			user.setIsActif(true);
//			user.setProfile(profile);
//			
			

//			adressBean.getAdresses().forEach(a -> user.getAdresses().add(a));

			User addUser = userMetier.addUser(user);

			messageSuccess = "Compte créé avec succès.";
			messageError = "";
//			adressBean.getAdresses().clear();
			
//			adressBean.initializeAdress();
			initializeUser();

			return "";
			//return "login.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la création de l'utilisateur !\n"
					+ e.getMessage();
			e.printStackTrace();
			return "";
		}
		
		
		
		}
		
	}
	
	
	
	
	


