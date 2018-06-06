package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.domain.User;
import org.lanqiao.ffs.tools.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl  implements IUserDao {
    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(ds);
        String sql = "select * from ffs_user where username=? and password=?";
        User user =  queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);

        return user;
    }
}
