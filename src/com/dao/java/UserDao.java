package com.dao.java;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Bean.java.Cart;
import com.Bean.java.User;
import com.factory.java.ImpleDao;
public class UserDao  implements ImpleDao{
	@Override
	public void add(User user,Cart cart) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		user.getUser_name();
		cart.getCart_name();
		session.save(cart);
		user.getCartList().add(cart);
		session.save(user);
		tx.commit();
		session.close();	
		/*Configuration c=new Configuration();
		c.configure("/hibernate.cfg.xml");
		SessionFactory s=c.buildSessionFactory();
		Session se=s.openSession();
		Transaction tx = se.beginTransaction();
		user.getUser_name();
		cart.getCart_name();
		se.save(cart);
		user.getCartList().add(cart);
		se.save(user);
		tx.commit();
		se.close();*/
		
	}
	@Override
	public void del(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		user.getUser_id();	
		session.delete(user);
		tx.commit();
		session.close();
		
	}
	@Override
	public void add(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//connection
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
        user.getUser_name();
		//user.setName("key");
		//
		session.save(user);
		tx.commit();
		session.close();
		
	}
	public static void saveByMappingby(User user,Cart cart){//鍐欏叆
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.get(User.class, user.getUser_id());
			
			cart.getCart_name();
			session.save(cart);
			//鏄繖涓敤鎴峰幓鍐欑殑杩欎釜鍗氭枃
			//user.write(bowen);//ruby
			user.getCartList().add(cart);
			session.save(user);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	public void getObect(User user){//鏌ヨ  鍙嶅皠 涓�釜id銆�
		try {

			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			 user = (User)session.get(User.class, user.getUser_id());
			System.out.println(user.getUser_name()+"--"+user.getUser_id());
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hqlquery(User user) {
		try {

			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query  query=null;
			query =session.createQuery("select new User(user_name)from User where user_id="+user.getUser_id()+"");
			user=(User) query.uniqueResult();
			//User user = (User)session.get(User.class, 2);
			System.out.println(user.getUser_name());
			
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User user) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
        //user.getUser_name();
        user.getUser_id();
		//user.setName("key");
		session.update(user);
		tx.commit();
		session.close();

	}

	@Override
	public void select(User user) {
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			user=(User) session.get(User.class, user.getUser_id());
			System.out.println(user.getUser_id()+" "+user.getUser_name());
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void select1(Object obj) {
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			obj=session.get(User.class, ((User) obj).getUser_id());
			System.out.println(((User) obj).getUser_id()+" "+((User) obj).getUser_name());
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
}
