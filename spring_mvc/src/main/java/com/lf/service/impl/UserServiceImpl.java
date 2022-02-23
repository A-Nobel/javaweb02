package com.lf.service.impl;

import com.lf.dao.UserDao;
import com.lf.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {

        userDao.save();
    }
}
