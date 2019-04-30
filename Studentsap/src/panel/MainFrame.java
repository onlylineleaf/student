package panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.midi.MidiSystem;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
  JFrame jf=this;
  JButton jb1=new JButton("教师登录");
  JButton jb2=new JButton("学生登录");
  JButton jb3=new JButton("退出");
  
	public MainFrame() {
	// TODO Auto-generated constructor stub

		this.setLocation(380, 60);

	   this.setSize(580, 600);
	   this.setLayout(new GridLayout(4,1));	   
	   this.add(new MainPanel());
	   this.add(jb1);
	   this.add(jb2);
	   this.add(jb3);
	   this.setVisible(true);      
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	   jb1.addMouseListener(new MouseAdapter() {
		   @Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			jf.dispose();
			new TeacherLoginFrame();
			
			
		}
		   
	});
	   jb2.addMouseListener(new MouseAdapter() {
		   @Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			jf.dispose();
			new StudentLoginFrame();
			
			
		}
		   
	});
	   
	   jb3.addMouseListener(new MouseAdapter() {
		   
		   @Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
		    jf.dispose();
		   }
	});
	   
   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame main=new MainFrame();
	}

}
