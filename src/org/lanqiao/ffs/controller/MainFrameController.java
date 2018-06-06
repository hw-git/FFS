package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.views.AbstractLedgerMngDialog;
import org.lanqiao.ffs.views.AbstractMainFrame;

public class MainFrameController extends AbstractMainFrame {
    @Override
    public void ledgerMng() {//账务管理按钮对应的事件
        AbstractLedgerMngDialog ledegerMngDialog = new LedgerMngController(this);
        ledegerMngDialog.setVisible(true);

    }

    @Override
    public void sortMng() {//分类管理对应的事件

    }
}
