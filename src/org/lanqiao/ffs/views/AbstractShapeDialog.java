package org.lanqiao.ffs.views;


import org.lanqiao.ffs.tools.GUITools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractShapeDialog extends JDialog {
	

	public AbstractShapeDialog(JDialog dialog) throws SQLException {
		super(dialog);
		
	}
	
	protected void initDialog() throws SQLException {
		this.addComponent();
		this.init();
	}
	
	private void init() {
		this.pack();
		GUITools.center(this);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public abstract List<String> getImagePaths() throws SQLException;
	
	/*
	 * 调用子类重写方法getImagePaths,获取生成的图片的路径
	 * 遍历集合List,获取所有的图片路径
	 * 放到组件Label中
	 */
	private void addComponent() throws SQLException {
		List<String> imagePaths = getImagePaths();
		if(imagePaths == null) {
			return;
		}
		JPanel panel = new JPanel();
		this.add(panel);
		for(String imagePath : imagePaths) {
			try {
				Image image = ImageIO.read(new File(imagePath));
				panel.add(new JLabel(new ImageIcon(image)));
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
