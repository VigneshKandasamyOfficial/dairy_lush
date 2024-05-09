// package com.secure_login_out.demo.Model;

// import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
// public class Cart {
// 	@Id
// 	@GeneratedValue(strategy=GenerationType.IDENTITY)
// 	private int proid;
// 	private int userid;
// 	private String productname;
// 	private String description;
// 	private String price;
// 	private List<Product> cart;
// 	private String quantity;
// 	public int getProid() {
// 		return proid;
// 	}
// 	public void setProid(int proid) {
// 		this.proid = proid;
// 	}
// 	public int getUserid() {
// 		return userid;
// 	}
// 	public void setUserid(int userid) {
// 		this.userid = userid;
// 	}
// 	public String getProductname() {
// 		return productname;
// 	}
// 	public void setProductname(String productname) {
// 		this.productname = productname;
// 	}
// 	public String getDescription() {
// 		return description;
// 	}
// 	public void setDescription(String description) {
// 		this.description = description;
// 	}
// 	public String getPrice() {
// 		return price;
// 	}
// 	public void setPrice(String price) {
// 		this.price = price;
// 	}
// 	public List<Product> getCart() {
// 		return cart;
// 	}
// 	public void setCart(List<Product> cart) {
// 		this.cart = cart;
// 	}
// 	public String getQuantity() {
// 		return quantity;
// 	}
// 	public void setQuantity(String quantity) {
// 		this.quantity = quantity;
// 	}
// 	@Override
// 	public String toString() {
// 		return "Cart [proid=" + proid + ", userid=" + userid + ", productname=" + productname + ", description="
// 				+ description + ", price=" + price + ", cart=" + cart + ", quantity=" + quantity + "]";
// 	}

// }