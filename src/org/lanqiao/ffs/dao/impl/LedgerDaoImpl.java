package org.lanqiao.ffs.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.ffs.dao.ILedgerDao;
import org.lanqiao.ffs.tools.DateUtils;
import org.lanqiao.ffs.tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;


public class LedgerDaoImpl  implements ILedgerDao {
    @Override
    public Double getTotleMoney(String parent) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select  sum(money),sid from  ffs_ledger WHERE parent = ?";
        return (double)qr.query(sql,new ScalarHandler(1),parent);

    }

    @Override
    public List<Object[]> getSumBySid(String parent) throws SQLException {
       QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
       String sql = "select  sum(money) ,sid from  ffs_ledger  WHERE parent = ?  and createtime LIKE ? GROUP BY sid";
       return  qr.query(sql,new ArrayListHandler(),parent,DateUtils.getYear()+"%");
    }
}
