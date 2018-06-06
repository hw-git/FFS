package org.lanqiao.ffs.service.impl;

import org.lanqiao.ffs.dao.ISortDao;
import org.lanqiao.ffs.dao.IUserDao;
import org.lanqiao.ffs.dao.impl.SortDaoImpl;
import org.lanqiao.ffs.domain.Sort;
import org.lanqiao.ffs.service.ISortService;
import org.lanqiao.ffs.service.IUserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortServiceImpl implements ISortService {
    ISortDao dao = new SortDaoImpl();
    @Override
    public List<String> querySortName(String parentVal) {
        try {
            List<Sort> sortList = dao.getSortListByParent(parentVal);
            List<String> sortNameList = new ArrayList<>();
            for (Sort s:sortList){
                sortNameList.add(s.getSname());
            }
           return sortNameList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
