package org.lanqiao.ffs.Test;

import org.lanqiao.ffs.dao.ILedgerDao;
import org.lanqiao.ffs.dao.impl.LedgerDaoImpl;
import org.lanqiao.ffs.service.ILegerService;
import org.lanqiao.ffs.service.impl.LegerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
//        ILedgerDao dao = new LedgerDaoImpl();
//      Double out =   dao.getTotleMoney("支出");
//        System.out.println(out);
//      List<Object[]> list =  dao.getSumBySid("支出");
//
//        for(Object[] objArr :list){
//            for(Object obj :objArr){
//                System.out.println(obj);
//            }
//        }
        ILegerService service = new LegerServiceImpl();
        service.createPie();
    }
}
