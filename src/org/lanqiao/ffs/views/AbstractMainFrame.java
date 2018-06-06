package org.lanqiao.ffs.views;

import org.lanqiao.ffs.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author apple
 * 主窗体类，需要子类继承后，显示
 * 包括两个按钮，功能，由子类实现
 */
public abstract class AbstractMainFrame extends JFrame {
	static {
    	try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 组件
	 */
	private JLabel titleLabel = new JLabel();//标题
	private JButton ledgerBtn = new JButton("账务管理");//账务管理
	private JButton sortBtn = new JButton("分类管理");//分类管理
	
	public AbstractMainFrame() {
		this.init();// 初始化操作
		this.addComponent();// 添加组件
		this.addListener();// 添加监听器
	}
	
	// 初始化操作
	private void init() {
		Image icon = Toolkit.getDefaultToolkit().getImage("imgs/logo.png");
		this.setIconImage(icon);
		this.setTitle("欢迎使用小蓝FFS家庭记账软件");// 标题
		this.setSize(600, 400);// 窗体大小与位置
		GUITools.center(this);//设置窗口在屏幕上的位置
		this.setResizable(false);// 窗体大小固定
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口默认操作

	}
	
	// 添加组件
	private void addComponent() {
        ImageIcon image = new ImageIcon("imgs/CC.png");

        image.setImage(image.getImage().getScaledInstance(600,280,Image.SCALE_DEFAULT));
        titleLabel.setIcon(image);
        this.add(this.titleLabel, BorderLayout.NORTH);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(null);
		this.add(btnPanel);
		
		ledgerBtn.setBounds(60, 0, 120, 50);
		sortBtn.setBounds(420, 0, 120, 50);
		
		Font font = new Font("华文彩云", Font.BOLD, 20);
		
		ledgerBtn.setFont(font);
		sortBtn.setFont(font);
		
		btnPanel.add(ledgerBtn);
		btnPanel.add(sortBtn);
	}

	// 添加监听器
	private void addListener() {
		//账务管理模块，开启按钮
		ledgerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ledgerMng();
			}
		});
		//分类管理模块，开启按钮
		sortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortMng();
			}
		});
	}	
	public abstract void ledgerMng();
	public abstract void sortMng();
}
