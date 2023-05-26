package fr.jasmin.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.jasmin.entity.Address;

@ManagedBean(name = "adressbean")
public class AdressBean {

	@ManagedProperty(name = "number", value = "30")
	private String number;

	@ManagedProperty(name = "street", value = "Rue la gloire")
	private String street;

	
	@ManagedProperty(name = "city", value = "paris")
	private String city;
	
	@ManagedProperty(name = "postalCode", value = "70500")
	private String postalCode;


	private static List<Address> adresses = new ArrayList<Address>();
	//private  List<Adress> adresses = new ArrayList<Adress>();

	public AdressBean() {
		//adresses.clear();
	}

	

	public AdressBean(String number, String street, String city, String postalCode) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}



	public void addAdressBean() {
		Address adress = new Address(number, street, city, postalCode);			
		adresses.add(adress);
		initializeAdress();
	}

	public void initializeAdress() {
		this.number = "";
		this.street = "";
		this.postalCode = "";
		this.city = "";
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public  List<Address> getAdresses() {
		return adresses;
	}
	
	

}
