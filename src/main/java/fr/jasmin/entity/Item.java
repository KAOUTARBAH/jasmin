package fr.jasmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	
	@NotEmpty
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	
	//@Column(name = "description", length = 500, nullable = false)
	private String description;
	
//	@NotNull
//	@Column(name = "price", nullable = false)
	private Float price;
	
//	@NotNull
//	@Column(name = "discount", nullable = false)
	private Integer discount;
	
//	@NotNull
//	@Column(name = "stock", nullable = false)
	private int stock ;
	
	
	//@Column(name = "picture", nullable = false)
	private String picture ;
	
	//@Column(name = "video", nullable = false)
	private String video ;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Item() {
		
	}
	
	

	public Item(@NotEmpty String name, String description) {
		
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", discount="
				+ discount + ", stock=" + stock + ", picture=" + picture + ", video=" + video + "]";
	}
	
	
}
