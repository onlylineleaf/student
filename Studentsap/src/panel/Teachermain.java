package panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bean.Teacher;

public class Teachermain extends JFrame {
	JFrame jf = this;

	Teacher teacher;

	JButton jb1 = new JButton("录入学生信息");
	JButton jb2 = new JButton("查看学生信息");
	JButton jb3 = new JButton("修改学生信息");
	JButton jb5 = new JButton("查看全部学生成绩");
	JButton jb4 = new JButton("关闭");

	public Teachermain(Teacher teacher) {
		// TODO Auto-generated constructor stub
		this.teacher = teacher;
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(6, 1));
		this.add(new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString(teacher.getName() + "欢迎登录(教师)", 90, 50);

			}

		});

		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb5);
		this.add(jb4);

		// 插入学生事件
		jb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				new InsertStudentPanel(teacher);

			}
		});

		// 查询学生事件
		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				new selstudent1(teacher);
				jf.dispose();

			}

		});

		// 修改学生事件

		jb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				new modstudent1(teacher);

			}

		});

		jb5.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				try {
					new AllstudentgradeFrame(1, teacher,1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// 关闭事件
		jb4.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();

			}
		});

	}

}
