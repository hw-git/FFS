package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.service.IUserService;
import org.lanqiao.ffs.service.impl.UserServiceImpl;
import org.lanqiao.ffs.tools.VerifiCodeUtil;
import org.lanqiao.ffs.views.AbstractLoginFrame;
import org.lanqiao.ffs.views.AbstractMainFrame;

import javax.swing.*;

public class LoginController extends AbstractLoginFrame {
    private IUserService userService = new UserServiceImpl();
    private String username;
    private String password;
    @Override
    public void login() {
        username = this.userFiled.getText().trim();
        password = new String(this.passwordFile.getPassword());
        boolean loginFlag = false;
        boolean codeFlag = checkCode();
        if(username!=null && !"".equalsIgnoreCase(username) && password!=null && !"".equalsIgnoreCase(password)){
          loginFlag =   userService.login(username ,password);
        }else{
            JOptionPane.showMessageDialog(this,"用户名或密码为空，请确认后重新登陆","小蓝温馨提示",JOptionPane.WARNING_MESSAGE);

        }
        if(loginFlag &&codeFlag){
            JOptionPane.showMessageDialog(this,"登陆成功","小蓝温馨提示",JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            AbstractMainFrame  mainFrame = new MainFrameController();
            mainFrame.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"用户名或密码有误，请确认后重新输入","小蓝温馨提示",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @Override
    public void rest() {
        userFiled.setText("");
        passwordFile.setText("");
        codeFiled.setText("");
    }

    @Override
    public Boolean checkCode() {
        String  userCode = codeFiled.getText().trim();
        String genCode = VerifiCodeUtil.getCode();
        if(userCode!=null && !userCode.equals("")){
            if(!genCode.equalsIgnoreCase(userCode)){
                codeImgLable.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
                message.setText("验证码输入错误，请重新输入");
                return false;
            }else{
                return true;
            }

        }else{
            message.setText("验证码不能为空");
            return false;
        }
    }
}
