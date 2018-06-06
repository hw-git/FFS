package org.lanqiao.ffs.dao;

import org.lanqiao.ffs.domain.Sort;

import java.sql.SQLException;
import java.util.List;

public interface ISortDao {
        public List<Sort> getSortListByParent(String parentVal) throws SQLException;

        public String querySnamebySid(int sid) throws SQLException;
}
