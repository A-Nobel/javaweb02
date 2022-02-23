package com.lf.dao.impl;

import com.lf.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running");
    }
}
