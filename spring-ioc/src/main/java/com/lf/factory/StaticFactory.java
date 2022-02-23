package com.lf.factory;

import com.lf.dao.UserDao;
import com.lf.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
