package panel;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bean.Student;
import Bean.Teacher;

public class ShowGrade extends JFrame {

	JFrame jf = this;

	Student stu;
	Teacher teacher;

	JPanel jp1 = new JPanel(new GridLayout(1, 2));
	JPanel jp2 = new JPanel(new GridLayout(1, 2));
	JPanel jp3 = new JPanel(new GridLayout(1, 2));
	JPanel jp4 = new JPanel(new GridLayout(1, 2));
	JPanel jp5 = new JPanel(new GridLayout(1, 2));
	JPanel jp6 = new JPanel(new GridLayout(1, 2));
	JPanel jp7 = new JPanel(new GridLayout(1, 2));
	JLabel jl1 = new JLabel("用户名：", JLabel.CENTER);
	JLabel jl2 = new JLabel("姓名：", JLabel.CENTER);
	JLabel jl3 = new JLabel("班级：", JLabel.CENTER);
	JLabel jl4 = new JLabel("数学成绩：", JLabel.CENTER);
	JLabel jl5 = new JLabel("语文成绩：", JLabel.CENTER);
	JLabel jl6 = new JLabel("英语成绩：", JLabel.CENTER);
	JButton jb1 = new JButton("返回");

	public ShowGrade(Student stu, Teacher teacher) {
		// TODO Auto-generated constructor stub
		// 设置窗体
		this.stu = stu;
		this.teacher = teacher;
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(7, 1));

		// 添加各种框
		JTextField jt1 = new JTextField(String.valueOf(stu.getId()));
		JTextField jt2 = new JTextField(stu.getName());
		JTextField jt3 = new JTextField(stu.getCla());
		JTextField jt4 = new JTextField(stu.getMathgrade());
		JTextField jt5 = new JTextField(stu.getChinesegrade());
		JTextField jt6 = new JTextField(stu.getEnglishgrade());
		jt1.setEditable(false);
		jt2.setEditable(false);
		jt3.setEditable(false);
		jt4.setEditable(false);
		jt5.setEditable(false);
		jt6.setEditable(false);
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
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jb1);

		// 返回事件
		jb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				if (teacher == null) {

					new Studentmain(stu);
				} else {

					new Teachermain(teacher);

				}

			}

		});

	}

}
