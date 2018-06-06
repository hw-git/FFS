package org.lanqiao.ffs.views;

import com.sun.deploy.panel.JavaPanel;
import org.lanqiao.ffs.tools.GUITools;
import org.lanqiao.ffs.tools.VerifiCodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class AbstractLoginFrame extends JFrame {

    private Font font = new Font("华文楷体",Font.BOLD,14);
    private JLabel logoImg = new JLabel();

    private  JLabel userLable = new JLabel("账   号：");
    protected  JTextField userFiled = new JTextField();

    private JLabel passwordLable = new JLabel("密   码：");
    protected  JPasswordField passwordFile = new JPasswordField();

    private JLabel codeLable = new JLabel("验证码：");
    protected JTextField codeFiled = new JTextField();
    protected JLabel codeImgLable = new JLabel();

    private JButton loginBtn = new JButton("登陆");
    private JButton restBtn = new JButton("重置");
    protected JLabel message = new JLabel();




    public  AbstractLoginFrame(){
        init();
        addCommpant();
        addListener();
    }
    public  void  init(){
        Image icon = Toolkit.getDefaultToolkit().getImage("imgs/logo.png");
        this.setIconImage(icon);
        this.setTitle("欢迎登录小蓝FFS家庭记账软件");
        this.setSize(600,400);
        GUITools.center(this);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public   void   addCommpant(){
        //顶部logo的设置
        //登陆面板
         JPanel loginPanel = new JavaPanel();
         //取消使用布局管理器 使用绝对布局
         loginPanel.setLayout(null);
         //为lable 添加图片
         ImageIcon icon = new ImageIcon("imgs/CC.png") ;
         //图片缩放
         icon.setImage(icon.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT));
         //给lable设置图片
         logoImg.setIcon(icon);
         //设置lable 的位置及大小
         logoImg.setBounds(0,-90,600,300);
         //将lable添加到面板中
         loginPanel.add(logoImg);
         //初始华账号组件
        userLable.setIcon(new ImageIcon("imgs/user.png"));
        userLable.setBounds(150,120,80,28);
        userLable.setFont(font);
        loginPanel.add(userLable);
        userFiled.setToolTipText("请输入您的账号");
        userFiled.setBounds(240,120,180,28);
        userFiled.setColumns(180);
        loginPanel.add(userFiled);
        //初密码组件
        passwordLable.setIcon(new ImageIcon("imgs/pwd.png"));
        passwordLable.setBounds(150,170,80,28);
        passwordLable.setFont(font);
        loginPanel.add(passwordLable);
        passwordFile.setToolTipText("请输入您的密码");
        passwordFile.setBounds(240,170,180,28);
        passwordFile.setColumns(180);
        loginPanel.add(passwordFile);
        //验证码的组件
        codeLable.setIcon(new ImageIcon("imgs/code.png"));
        codeLable.setBounds(150,220,80,28);
        codeLable.setFont(font);
        loginPanel.add(codeLable);
        codeFiled.setBounds(240,220,180,28);
        loginPanel.add(codeFiled);
        codeImgLable.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
        codeImgLable.setBounds(440,210,120,40);
        loginPanel.add(codeImgLable);
        message.setBounds(240,240,250,40);
        message.setForeground(Color.red);
        message.setFont(font);
        loginPanel.add(message);
        loginBtn.setBounds(150,300,120,40);
        Font font = new Font("华文楷体",Font.BOLD,16);
        loginBtn.setFont(font);
        loginPanel.add(loginBtn);
        restBtn.setBounds(300,300,120,40);
        restBtn.setFont(font);
        loginPanel.add(restBtn);








         //将面板添加到窗口中
         this.add(loginPanel);


    }
    public  void addListener(){
        codeImgLable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codeImgLable.setIcon(new ImageIcon(VerifiCodeUtil.getBufferdImage(120,40)));
            }
        });
        codeFiled.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                checkCode();
            }
        });
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login();
            }
        });
        restBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               rest();
            }
        });
    }
    public abstract  void login();
    public abstract void rest();
    public  abstract  Boolean checkCode();
}
