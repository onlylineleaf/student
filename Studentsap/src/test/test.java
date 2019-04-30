package test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import Bean.Student;
import BeanDao.Studentimpl;
import BeanMapper.StudentMapper;
import util.Page;
import util.SqlSessionUtil;
public class test {

	@Test
	public void insertstudent() throws Exception
	{
		
		Student student=new Student("test", "name", "cla", "100", "100", "100",
				"123456");
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	sim.insertstudent(student);
	
	
	}
	@Test
	public void delstudent() throws Exception
	{
		
	
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	sim.delstudentbyid("test");
	
	
	}
	@Test
	public void modstudent() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	Student student=new Student("test", "newname", "newcla", "100", "100", "100",
			"new123456");
	 sim.mostudent(student);;
	
		
	}
	
	
	
	@Test
	public void selstudentbyid() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	Student student = sim.selstudentbyid("001");
	System.out.println(student.toString());
		
	}
	
	@Test
	public void selallstudent() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	List<Student> students = sim.showallstudent();
	for(Student student :students)
	{
	System.out.println(student.toString());
	}	
	}
	
	@Test
	public void selstudentbypageorderbyid() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	Page p=new Page();
	p.start=0;
	List<Student> students = sim.showstudentbypage(p);
	System.out.println(students.toString());
		
	}
	
	@Test
	public void selstudentbypageorderbygrade() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	Page p=new Page();
	p.start=0;
	List<Student> students = sim.showstudentbypageOrderbygrade(p);
	System.out.println(students.toString());
		
	}
	@Test
	public void selstudentbypageorderbycla() throws Exception
	{
	Studentimpl sim=new Studentimpl(SqlSessionUtil.getSqlSession());
	Page p=new Page();
	p.start=0;
	List<Student> students = sim.showstudentbypageorderbycla(p);
	System.out.println(students.toString());
		
	}
	

	

}
