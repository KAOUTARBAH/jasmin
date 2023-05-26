package fr.jasmin.entity;

import java.util.ArrayList;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "category")
@XmlRootElement
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//@NotEmpty
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	
	//@NotNull
	//@Column(name = "discount", nullable = false)
	private Integer discount;
	
	
	//@NotNull
	//@Column(name = "is_discount_cumulate", nullable = false)
	private Boolean isDiscountCumulate;
	
	
	
	//@Column(name = "picture", nullable = false)
	private String picture ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Item> Items = new ArrayList<Item>();

	public Category() {
	
	}

	public Category(String name, Integer discount, Boolean isDiscountCumulate, String picture) {
		this.name = name;
		this.discount = discount;
		this.isDiscountCumulate = isDiscountCumulate;
		this.picture = picture;
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

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Boolean getIsDiscountCumulate() {
		return isDiscountCumulate;
	}

	public void setIsDiscountCumulate(Boolean isDiscountCumulate) {
		this.isDiscountCumulate = isDiscountCumulate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Item> getItems() {
		return Items;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", discount=" + discount + ", isDiscountCumulate="
				+ isDiscountCumulate + ", picture=" + picture + "]";
	}
	
	
	
	
	
	

}
