package org.lanqiao.ffs.app;

import org.lanqiao.ffs.controller.LoginController;
import org.lanqiao.ffs.controller.MainFrameController;
import org.lanqiao.ffs.views.AbstractMainFrame;

public class Main {
    public static void main(String[] args){

//        LoginController login = new LoginController();
//        login.setVisible(true);
//
        AbstractMainFrame mainFrame = new MainFrameController();
        mainFrame.setVisible(true);
    }

}
