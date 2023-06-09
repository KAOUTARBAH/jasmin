package fr.jasmin.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "item_cart")
public class ItemCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@NotNull
	@Column(name = "quantity", nullable = false)
	private int quantity ;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public ItemCart() {
	
	}


	public ItemCart(Integer id, @NotEmpty String item, @NotNull int quantity) {		
		this.id = id;
		this.quantity = quantity;
		
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	@Override
	public String toString() {
		return "ItemCart [id=" + id + ", quantity=" + quantity + "]";
	}


	


}
