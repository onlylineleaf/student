package panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Bean.Student;

public class Studentmain extends JFrame {
	JFrame jf = this;

	Student stu;

	JButton jb1 = new JButton("查询成绩");

	JButton jb2 = new JButton("退出");

	public Studentmain(Student stu) {
		// TODO Auto-generated constructor stub
		this.stu = stu;
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));

		this.add(new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString(stu.getName() + "欢迎登陆(学生)", 80, 50);

			}

		});

		this.add(jb1);
		this.add(jb2);

		// 查看成绩事件
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				new ShowGrade(stu, null);

			}
		});

		// 关闭事件
		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);

				jf.dispose();

			}
		});

	}

}
