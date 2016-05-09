package com.Bean.java;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
// 创建实体
public class User {
	private int user_id;
	private String user_name;
	private List<Cart> CartList = new ArrayList<Cart>();
    public User (){
    
    }
    public User (String user_name){
    	this.user_name=user_name;
    }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_user_id", referencedColumnName = "user_id")
	public List<Cart> getCartList() {
		return CartList;
	}

	public void setCartList(List<Cart> CartList) {
		this.CartList = CartList;
	}

}
