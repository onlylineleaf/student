package panel;

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

public class modstudent2 extends JFrame {

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
	JPanel jp8 = new JPanel(new GridLayout(1, 3));
	JLabel jl1 = new JLabel("用户名：", JLabel.CENTER);
	JLabel jl2 = new JLabel("姓名：", JLabel.CENTER);
	JLabel jl3 = new JLabel("班级：", JLabel.CENTER);
	JLabel jl4 = new JLabel("数学成绩：", JLabel.CENTER);
	JLabel jl5 = new JLabel("语文成绩：", JLabel.CENTER);
	JLabel jl6 = new JLabel("英语成绩：", JLabel.CENTER);
	JLabel jl7 = new JLabel("密码：", JLabel.CENTER);
	JButton jb2 = new JButton("返回");
	JButton jb1 = new JButton("修改");
	JButton jb3 = new JButton("删除此学生");

	public modstudent2(Student stu, Teacher teacher) {
		// TODO Auto-generated constructor stub
		// 设置窗体
		this.stu = stu;
		this.teacher = teacher;
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(8, 1));

		// 添加各种框
		JTextField jt1 = new JTextField(String.valueOf(stu.getId()));
		JTextField jt2 = new JTextField(stu.getName());
		JTextField jt3 = new JTextField(stu.getCla());
		JTextField jt4 = new JTextField(stu.getMathgrade());
		JTextField jt5 = new JTextField(stu.getChinesegrade());
		JTextField jt6 = new JTextField(stu.getEnglishgrade());
		JTextField jt7 = new JTextField(stu.getPassword());
		jt1.setEditable(false);

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
		jp8.add(jb3);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.add(jp6);
		this.add(jp7);
		this.add(jp8);

		// 修改事件
		jb1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				String id = jt1.getText().trim();
				String name = jt2.getText().trim();
				String cla = jt3.getText().trim();
				String mathgrade = jt4.getText().trim();
				String chinesegrade = jt5.getText().trim();
				String englishgrade = jt6.getText().trim();
				String password = jt7.getText().trim();
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

				}

				try {
					Studentimpl sim = new Studentimpl(SqlSessionUtil.getSqlSession());
					Student stu = new Student(id, name, cla, mathgrade, chinesegrade, englishgrade, password);
					sim.mostudent(stu);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "修改失败，未知原因", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, "修改学生成功");
				jf.dispose();
				new Teachermain(teacher);

			}

		});

		// 返回事件
		jb2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();

				new Teachermain(teacher);

			}

		});
		
		jb3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				

				int valuex=JOptionPane.showConfirmDialog(jf,

						"你确认要删除此学生吗？（不可恢复）", "请确认",

						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
				
				if (valuex==JOptionPane.YES_OPTION) {
					String id = jt1.getText().trim();
					Studentimpl sim;
					try {
						sim = new Studentimpl(SqlSessionUtil.getSqlSession());
						sim.delstudentbyid(id);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "删除失败，未知原因", "提示", JOptionPane.WARNING_MESSAGE);
					    return;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "修改失败，未知原因", "提示", JOptionPane.WARNING_MESSAGE);
					    return;
					}
					
				
					jf.dispose();
					new Teachermain(teacher);

					}
				else {
				
				

				}
			}

		});

	}

}
