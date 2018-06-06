package org.lanqiao.ffs.dao;

import org.lanqiao.ffs.domain.User;

import java.sql.SQLException;

public interface IUserDao {

    public User getUserByUsernameAndPassword(String username,String password) throws SQLException;
}
