package org.lanqiao.ffs.views;

import javax.swing.*;
import java.awt.*;

public class BackImgPanel extends JPanel {
    ImageIcon icon;
    Image img;
    public BackImgPanel(String imgPath) {
        //  /img/HomeImg.jpg 是存放在你正在编写的项目的bin文件夹下的img文件夹下的一个图片
        icon=new ImageIcon(imgPath);
        img=icon.getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
    }

}
