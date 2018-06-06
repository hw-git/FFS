package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.domain.Sort;
import org.lanqiao.ffs.service.ISortService;
import org.lanqiao.ffs.service.impl.SortServiceImpl;
import org.lanqiao.ffs.views.AbstractLedgerMngDialog;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LedgerMngController extends AbstractLedgerMngDialog{
    private ISortService sortService = new SortServiceImpl();
    public LedgerMngController(JFrame frame ){
        super(frame);
    }

    @Override
    public void addLedger() {
        OperationLedgerDialogController operationLedger = new OperationLedgerDialogController(this);
        operationLedger.setVisible(true);
    }

    @Override
    public void editLedger() {

    }

    @Override
    public void deleteLedger() {

    }

    @Override
    public void queryLedger() {

    }

    @Override
    public void parentChange() {
    String parentBoxVal = (String)parentBox.getSelectedItem();
        List<String> sortList = new ArrayList<>();
        if("-请选择-".equals(parentBoxVal)){
           JOptionPane.showMessageDialog(this,"请选择你要查询的分类","小蓝温馨提示",JOptionPane.WARNING_MESSAGE);
        }else{
          sortList =   sortService.querySortName(parentBoxVal);
            sortBox.setModel(new DefaultComboBoxModel(sortList.toArray()));
        }


    }

    @Override
    public void pie() {
        try {
            new ShapeDiagloController(this).setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
