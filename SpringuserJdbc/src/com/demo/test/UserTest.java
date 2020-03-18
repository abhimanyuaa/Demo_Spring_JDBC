package com.demo.test;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.Dao.userDao;
import com.demo.bean.User;

public class UserTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("resources/spring.xml");

		userDao dao = context.getBean("userdao", userDao.class);
		
		/*
		 * int i=dao.insertuser(new User(104, "Prakash"));
		 * 
		 * System.out.println("Inserted Succesfully"+i);
		 
	User u=dao.serchbyid(102);
	
	System.out.println(u);
	*/
	ArrayList<User> al= new ArrayList<User>();
	
	al=(ArrayList<User>) dao.getAll();
	
	
	for (User user : al) {
		
		System.out.println(user);
	}
	}

}
