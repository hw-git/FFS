package org.lanqiao.ffs.dao;

import java.sql.SQLException;
import java.util.List;

public interface ILedgerDao {
    public Double getTotleMoney(String parent) throws SQLException;
    public List<Object[]> getSumBySid(String parent) throws SQLException;
}
