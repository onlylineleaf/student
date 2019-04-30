package panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bean.Student;
import Bean.Teacher;
import BeanDao.Studentimpl;
import util.SqlSessionUtil;

public class InsertStudentPanel extends JFrame {
	JFrame jf = this;

	Teacher teacher;

	JPanel jp1 = new JPanel(new GridLayout(1, 2));
	JPanel jp2 = new JPanel(new GridLayout(1, 2));
	JPanel jp3 = new JPanel(new GridLayout(1, 2));
	JPanel jp4 = new JPanel(new GridLayout(1, 2));
	JPanel jp5 = new JPanel(new GridLayout(1, 2));
	JPanel jp6 = new JPanel(new GridLayout(1, 2));
	JPanel jp7 = new JPanel(new GridLayout(1, 2));
	JPanel jp8 = new JPanel(new GridLayout(1, 2));
	JLabel jl1 = new JLabel("学生用户名", JLabel.CENTER);// 不可以为空
	JLabel jl2 = new JLabel("学生姓名", JLabel.CENTER);// 可以为空
	JLabel jl3 = new JLabel("学生所在班级", JLabel.CENTER);// 可以为空
	JLabel jl4 = new JLabel("数学成绩", JLabel.CENTER);// 可以为空
	JLabel jl5 = new JLabel("语文成绩", JLabel.CENTER);// 可以为空
	JLabel jl6 = new JLabel("英语成绩", JLabel.CENTER);// 可以为空
	JLabel jl7 = new JLabel("用户密码", JLabel.CENTER);// 为学生设置初始密码，不可空
	JTextField jt1 = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();
	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();
	JTextField jt7 = new JTextField();
	JButton jb1 = new JButton("提交新学生");
	JButton jb2 = new JButton("返回");

	public InsertStudentPanel(Teacher teacher) {
		// TODO Auto-generated constructor stub

		this.teacher = teacher;
		// 设置窗体
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(9, 1));

		// 头文字
		this.add(new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString("录入学生成绩", 130, 50);

			}

		});

		// 插入8行 各种框
		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jt2);
		jp3.add(jl3);
		jp3.add(jt3);
		jp4.add(jl4);
		jp4.add(jt4);
		jp5.add(jl5);
		jp5.add(jt5);
		jp6.add(jl6);
		jp6.add(jt6);
		jp7.add(jl7);
		jp7.add(jt7);
		jp8.add(jb1);
		jp8.add(jb2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		this.add(jp8);

		// 提交新学生事件
		jb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				// 获取文本框值
				String id = jt1.getText().trim();
				String name = jt2.getText().trim();
				String cla = jt3.getText().trim();
				String mathgrade = jt4.getText().trim();
				String chinesegrade = jt5.getText().trim();
				String englishgrade = jt6.getText().trim();
				String password = jt7.getText().trim();

				if(id==""||password=="")
				{
					JOptionPane.showMessageDialog(null, "用户名和密码不能为空", "提示", JOptionPane.WARNING_MESSAGE);
				}
				// 检测成绩是否为数字
				try {
					if (mathgrade != "") {
						Double.valueOf(mathgrade);
					}
					if (englishgrade != "") {
						Double.valueOf(englishgrade);
					}
					if (chinesegrade != "") {
						Double.valueOf(chinesegrade);
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "成绩输入异常", "提示", JOptionPane.WARNING_MESSAGE);
                       return;
				}

				try {
					Studentimpl sim = new Studentimpl(SqlSessionUtil.getSqlSession());
					Student stu = new Student(id, name, cla, mathgrade, chinesegrade, englishgrade, password);
					sim.insertstudent(stu);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
				
					JOptionPane.showMessageDialog(null, "插入失败，可能由于用户名已存在。", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, "插入学生成功");
				jf.dispose();
				new Teachermain(teacher);

			}

		});

		jb2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);

				jf.dispose();
				new Teachermain(teacher);

			}
		});

	}

}
