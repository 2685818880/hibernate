package com.action.java;

import com.Bean.java.Cart;
import com.Bean.java.User;
import com.dao.java.UserDao;
import com.factory.java.ImpleDao;

public class Action {
	public static void main(String[] args) {
		 ImpleDao impleDao=new UserDao();
		 User user =new User();
		 Cart cart= new Cart();
		 
        //级联添加
		 user.setUser_name("lazy");
		//user.setUser_id(1);
		 cart.setCart_name("hello");
		 impleDao.add(user,cart);

		 
		//删除
		//user.setUser_id(2);
		impleDao.del(user);
		 
		//添加user
		//user.setUser_name("lazy");
		//impleDao.add(user);
		
		//根据id查询名字
		user.setUser_id(1);
		impleDao.getObect(user);
		 
		//根据id更改名字
		// user.setUser_id(2);
		//user.setUser_name("qqq");
	    // impleDao.update(user);
		 
		//查询
		// user.setUser_id(5);
		// impleDao.hqlquery(user);
		 
		//查询r
		user.setUser_id(5);
		impleDao.select1(user);
		 
		// UserDao.saveByMappingby(user,cart);
	}

}
