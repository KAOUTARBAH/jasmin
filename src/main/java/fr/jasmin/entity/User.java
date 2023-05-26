package fr.jasmin.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import fr.jasmin.encryption.algo.EncryptionAlgorithm;





@Entity
@Table(name = "user")
@XmlRootElement

public class User  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	
	@NotEmpty
	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@NotEmpty
	@Column(name = "first_name", length = 20, nullable = false)
	private String firstName;
	
//	@NotNull
//	@Column(name = "birh_date", length = 30, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birhDate;
	
//	@NotNull
//	@Column(name = "is_actif",  nullable = false)
	private Boolean isActif;
	
//	@NotEmpty
//	@Column(name = "profile", length = 20, nullable = false)
	private String profile;
	
//	@NotEmpty
//	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;
	
	
//	@NotEmpty
//	@Column(name = "pasword", length = 30, nullable = false)
//	@Size(min = 8, max = 30)
	private byte[] password;
	
	@Transient
	private String passwordClear ;
	
//	@NotEmpty
//	@Column(name = "phone", length = 13, nullable = false)
	private String phone;
	
	
	//@ManagedProperty(value = "#{adressebean}")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Address> adresses = new ArrayList<Address>();
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<Order> orders =  new  ArrayList<Order>();
//	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user" )
	private List<BankCard> bankCardList =  new  ArrayList<BankCard>();
	
//	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<Comment> comments =  new  ArrayList<Comment>();
//	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<ItemCart> basket = new ArrayList<ItemCart>();
	
	public User() {
		
	}

	
	public User(@NotEmpty String name, @NotEmpty String firstName) {
		
		this.name = name;
		this.firstName = firstName;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	

	


	

	public Date getBirhdate() {
		return birhDate;
	}


	public void setBirhDate(Date birhDate) {
		this.birhDate = birhDate;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


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


	public String getPasswordClear() {
		return passwordClear;
	}


	public void setPasswordClear(String passwordClear) {
		this.passwordClear = passwordClear;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<ItemCart> getBasket() {
		return basket;
	}


	

	public List<Address> getAdresses() {
		return adresses;
	}


	

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstName=" + firstName + ", birhdate=" + birhDate
				+ ", isActif=" + isActif + ", profile=" + profile + ", email=" + email + ", password="
				+ Arrays.toString(password) + ", passwordClear=" + passwordClear + "]";
	}


	public void encryptUser() throws Exception {
		setPassword(EncryptionAlgorithm.encrypt(getPasswordClear()));
		for (BankCard bk : this.getBankCardList()) {
			bk.encryptCryptogram();
			bk.encryptNumber();
		}
	}
	
	
	public void decryptUser() throws Exception {
		setPasswordClear(EncryptionAlgorithm.decrypt(getPassword()));
		for (BankCard bk : this.getBankCardList()) {
			bk.decryptCryptogram();
			bk.decryptNumber();
		}
		
	}


	public List<BankCard> getBankCardList() {
		return bankCardList;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//
	

//
//	public List<Comment> getComments() {
//		return comments;
//	}
	
	
	
	
	
	
	
}
