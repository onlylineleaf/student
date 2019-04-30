package panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class modstudent1 extends JFrame {
	JFrame jf = this;

	Teacher teacher;
	JPanel jp1 = new JPanel(new GridLayout(1, 2));
	JPanel jp2 = new JPanel(new GridLayout(1, 2));
	JLabel jl1 = new JLabel("请输入要修改学生的学号");
	JTextField jt1 = new JTextField();
	JButton jb1 = new JButton("查找");
	JButton jb2 = new JButton("返回");

	public modstudent1(Teacher teacher1) {
		// TODO Auto-generated constructor stub
		this.teacher = teacher1;
		this.setLocation(380, 60);
		this.setSize(580, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1));

		this.add(new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.setFont(new Font("黑体", Font.BOLD, 30));
				g.drawString("修改学生信息", 90, 50);

			}

		});

		jp2.add(jb1);
		jp2.add(jb2);
		this.add(jl1);
		this.add(jt1);
		this.add(jp2);

		jb1.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {

				String id = jt1.getText().trim();
				try {
					Studentimpl sim = new Studentimpl(SqlSessionUtil.getSqlSession());
					Student stu = sim.selstudentbyid(id);
					if (stu == null) {
						JOptionPane.showMessageDialog(null, "未查到此学生", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}
					new modstudent2(stu, teacher);
					jf.dispose();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
