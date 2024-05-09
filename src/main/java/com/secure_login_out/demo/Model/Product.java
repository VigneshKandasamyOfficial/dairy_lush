package com.secure_login_out.demo.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productname;
	private String description;
	private String price;
	private String image;
	//private String quantity;
	public Product() {		
	}
//	public Product(int id, String productname, String brand, String price, String quantity) {
//		super();
//		this.id = id;
//		this.productname = productname;
//		this.brand = brand;
//		this.price = price;
//		this.quantity = quantity;
//	}
	public Product(int id, String productname, String description, String price,String image) {
		super();
		this.id = id;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.image=image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", description=" + description + ", price="
				+ price +  "," + image+"]";
	}	
}