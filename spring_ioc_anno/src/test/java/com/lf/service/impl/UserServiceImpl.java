package com.lf.service.impl;

import com.lf.dao.UserDao;
import com.lf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
//    @Autowired
//    @Qualifier("userDao")
    @Resource(name="userDao")
    private UserDao userDao;


    @Value("${jdbc.driver}")
    private String driver;
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory");
    }

}
