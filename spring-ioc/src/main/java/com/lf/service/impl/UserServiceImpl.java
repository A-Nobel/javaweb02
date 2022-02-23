package com.lf.service.impl;

import com.lf.dao.UserDao;
import com.lf.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    //    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save(){
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserDao userDao = (UserDao) app.getBean("userDao");
        //UserDao userDao2 = (UserDao) app.getBean("userDao");
        userDao.save();
        //System.out.println(userDao1==userDao2);
    }
}
