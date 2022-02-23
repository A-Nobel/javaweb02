package com.lf.dao.impl;

import com.lf.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDao")
//
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save Runing...");
    }
}
