package org.lanqiao.ffs.service.impl;

import javafx.scene.input.PickResult;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.lanqiao.ffs.dao.ILedgerDao;
import org.lanqiao.ffs.dao.ISortDao;
import org.lanqiao.ffs.dao.impl.LedgerDaoImpl;
import org.lanqiao.ffs.dao.impl.SortDaoImpl;
import org.lanqiao.ffs.service.ILegerService;
import org.lanqiao.ffs.tools.ChartUtil;
import org.lanqiao.ffs.tools.DateUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LegerServiceImpl implements ILegerService {
    private ILedgerDao ledgerDao = new LedgerDaoImpl();
    private ISortDao sortDao = new SortDaoImpl();
    @Override
    public List<String> createPie() throws SQLException {
        List<String> imgList = new ArrayList<>();
        /* public static String createPieChart3D(String title,  PieDataset dataset,
                                          String path)
     3D饼图：
        String[] keys = { "王晓博", "李冰", "牛根生", "李开复", "马云", "其它" };
         double[] data = { 60, 60, 55, 77, 80, 50 };
         DefaultPieDataset dataset = new DefaultPieDataset();
         for (int i = 0; i < keys.length; i++) {
          dataset.setValue(keys[i], data[i]);
         }
           */
        //生成收入占比图
        String title = "收入占比图(" +  ledgerDao.getTotleMoney("收入") +")("+DateUtils.getYear()+"年)";
        List<Object[]> list = ledgerDao.getSumBySid("收入");
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Object[] objArr:list){
            Double sum =   (Double) objArr[0];
            int sid = (int)objArr[1];
            String sname = sortDao.querySnamebySid(sid);
            dataset.setValue(sname,sum);
        }

        ChartUtil.createPieChart3D(title,dataset,"chart","in");
        imgList.add("chart/in.png");
//生成支出占比图
        String outtitle = "支出占比图(" +  ledgerDao.getTotleMoney("支出") +")("+DateUtils.getYear()+"年)";
        List<Object[]> listout = ledgerDao.getSumBySid("支出");
        DefaultPieDataset datasetout = new DefaultPieDataset();
        for (Object[] objArr:listout){
            Double sum =   (Double) objArr[0];
            int sid = (int)objArr[1];
            String sname = sortDao.querySnamebySid(sid);
            datasetout.setValue(sname,sum);
        }

        ChartUtil.createPieChart3D(outtitle,datasetout,"chart","out");
        imgList.add("chart/out.png");
        return imgList;
    }
}
