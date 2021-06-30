package com.hcl.capstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="food_id")
    private long foodId;
    
    @Column(name="food_categeory")
    private String foodCategeory;
    
    @Column(name="food_name")
    private String foodName;
    
    @Column(name="food_price")
    private double foodPrice;
    
    
	

	
	public Menu(long foodId, String foodCategeory, String foodName, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodCategeory = foodCategeory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		
	}

	public Menu() {
		super();
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodCategeory() {
		return foodCategeory;
	}

	public void setFoodCategeory(String foodCategeory) {
		this.foodCategeory = foodCategeory;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "Image")
	private List<Image> image;
    
   // @ManyToOne
    //private Restaurant restaurant;

 

}
