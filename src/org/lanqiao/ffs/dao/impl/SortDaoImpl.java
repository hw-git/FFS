package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.ffs.dao.ISortDao;
import org.lanqiao.ffs.domain.Sort;
import org.lanqiao.ffs.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class SortDaoImpl implements ISortDao {
    @Override
    public List<Sort> getSortListByParent(String parentVal) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select sname from ffs_sort where  1=1";
        List<Sort> sortList = new ArrayList<>();
        if (!"收入/支出".equals(parentVal)){
            sql+=  " and parent=?";
            sortList = queryRunner.query(sql,new BeanListHandler<Sort>(Sort.class),parentVal);
        }else{
            sortList = queryRunner.query(sql,new BeanListHandler<Sort>(Sort.class));
        }

        return sortList;
    }

    @Override
    public String querySnamebySid(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from  ffs_sort where sid = ?";
       Sort sort =  queryRunner.query(sql,new BeanHandler<>(Sort.class),sid);
        return sort.getSname();
    }
}
