package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.setFont(new Font("黑体", Font.BOLD, 30));

		g.drawString("学生管理系统", 140, 70);

	}

}
