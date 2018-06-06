package org.lanqiao.ffs.service.impl;

import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.dao.impl.UserDaoImpl;
import org.lanqiao.ffs.domain.User;
import org.lanqiao.ffs.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public Boolean login(String username, String password) {
        User user = null;
        try {
            user =  userDao.getUserByUsernameAndPassword(username,password);
            if(user !=null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
