package panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Bean.Student;
import Bean.Teacher;
import BeanDao.Studentimpl;
import util.Page;
import util.SqlSessionUtil;

public class AllstudentgradeFrame {
	int type=1;
	Teacher teacher;
	JFrame jf = new JFrame();
	int page;
	List<Student> students;
	JPanel jp1, jp2,jp3;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2, jb3,jb4,jb5,jb6;

	public AllstudentgradeFrame(int page, Teacher teacher,int type) throws Exception {
		// TODO Auto-generated constructor stub
		this.type=type;
		this.page = page;
		this.teacher = teacher;
		Studentimpl sim = new Studentimpl(SqlSessionUtil.getSqlSession());
		Page p = new Page();
		p.start = (page - 1) * p.size;
		if(type==1)
		{
		students = sim.showstudentbypage(p);
		}
		else if(type==2)
		{
			students = sim.showstudentbypageOrderbygrade(p);
		}
		else//3
		{
			students = sim.showstudentbypageorderbycla(p);
		}
		
		jf.setLocation(380, 60);

		jf.setSize(580, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		   int length=students.size()+3;   
//		   jf.setLayout(new GridLayout(5,1));
		jf.setLayout(new BorderLayout());

		jb4=new JButton("按学号排序");
		jb5=new JButton("按成绩排序");
		jb6=new JButton("按班级排序");
		jp3=new JPanel(new GridLayout(1,3));
		jp3.add(jb4);
		jp3.add(jb5);
		jp3.add(jb6);
		jf.add(jp3,BorderLayout.NORTH);
		String[][] datas = {};
		String[] titles = { "学生账号", "学生姓名", "学生班级", "数学成绩", "语文成绩", "英语成绩", "平均成绩" };
		DefaultTableModel model = new DefaultTableModel(datas, titles);
		JTable table = new JTable(model);
		table.setRowHeight(50);
//		   jp1=new JPanel(new GridLayout(1,6));
//		   jl1=new JLabel("学生账号");  jl2=new JLabel("学生姓名");  jl3=new JLabel("学生班级");  jl4=new JLabel("数学成绩");  jl5=new JLabel("语文成绩");  jl6=new JLabel("英语成绩");
//		   jp1.add(jl1);jp1.add(jl2);jp1.add(jl3);jp1.add(jl4);jp1.add(jl5);jp1.add(jl6);
//		   jf.add(jp1);
		for (Student stu : students) {
//			   jp1=new JPanel(new GridLayout(1,6));
//			   jl1=new JLabel(stu.getId());  jl2=new JLabel(stu.getName());  jl3=new JLabel(stu.getCla());  jl4=new JLabel(stu.getMathgrade());  jl5=new JLabel(stu.getChinesegrade());  jl6=new JLabel(stu.getEnglishgrade());
//			   jp1.add(jl1);jp1.add(jl2);jp1.add(jl3);jp1.add(jl4);jp1.add(jl5);jp1.add(jl6);
//			   jf.add(jp1);
			double avegrade = (Double.valueOf(stu.getMathgrade()) + Double.valueOf(stu.getChinesegrade())
					+ Double.valueOf(stu.getEnglishgrade())) / 3;

			DecimalFormat df = new DecimalFormat("0.00");
			String avegrad = df.format(avegrade);
			model.addRow(new String[] { stu.getId(), stu.getName(), stu.getCla(), stu.getMathgrade(),
					stu.getChinesegrade(), stu.getEnglishgrade(), avegrad });

		}
		jf.add(new JScrollPane(table), BorderLayout.CENTER);
		jp2 = new JPanel(new GridLayout(1, 3));
		jb1 = new JButton("上一页");
		jb2 = new JButton("下一页");
		jb3 = new JButton("返回");
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jf.add(jp2, BorderLayout.SOUTH);

		if (students.size() == 0) {
			JOptionPane.showMessageDialog(null, "已到最后一页", "提示", JOptionPane.WARNING_MESSAGE);
			jf.dispose();
			
			new AllstudentgradeFrame(page - 1, teacher,type);

		}
		jb1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);

				try {
					int newpage = page - 1;
					if (newpage > 0) {
						new AllstudentgradeFrame(newpage, teacher,type);
						jf.dispose();
					} else {

						JOptionPane.showMessageDialog(null, "已到第一页", "提示", JOptionPane.WARNING_MESSAGE);
						return;
					}

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

				try {
					int newpage = page + 1;
					jf.dispose();
					new AllstudentgradeFrame(newpage, teacher,type);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		jb3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				new Teachermain(teacher);

			}

		});
		//按学号排序
		jb4.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				try {
					new AllstudentgradeFrame(1, teacher,1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出现异常", "提示", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		//按成绩排序
		jb5.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				try {
					new AllstudentgradeFrame(1, teacher,2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出现异常", "提示", JOptionPane.WARNING_MESSAGE);
				}

			}

		});
		//按班级排序
		jb6.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				jf.dispose();
				try {
					new AllstudentgradeFrame(1, teacher,3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "出现异常", "提示", JOptionPane.WARNING_MESSAGE);
				}

			}

		});

	}

}
