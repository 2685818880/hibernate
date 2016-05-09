package com.factory.java;

import com.Bean.java.Cart;
import com.Bean.java.User;

public interface ImpleDao {
 
 public void add(User user);
 public void add(User user,Cart cart);
 public void del(User user);
 public void hqlquery(User user);
 public void update(User user);
 public void select(User user);
 public void select1(Object obj);
 public void getObect(User user);
}
