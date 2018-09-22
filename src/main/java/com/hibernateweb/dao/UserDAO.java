package com.hibernateweb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
import com.hibernateweb.bean.User;
 
public class UserDAO {
 
    public User addUserDetails(String userName, String password, String email, String phone, String city) {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setCity(city);
            user.setPhone(phone);
            session.save(user);
//            user.setValid(true);
            transaction.commit();
            session.close();
            return user;
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
		return null;
 
    }
 
}