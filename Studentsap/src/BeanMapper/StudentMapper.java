package BeanMapper;

import java.util.List;

import Bean.Student;
import util.Page;

public interface StudentMapper {

	public void insertstudent(Student student) throws Exception;

	public void delstudentbyid(String id) throws Exception;

	public void mostudent(Student student) throws Exception;

	public List<Student> showallstudent() throws Exception;

	public List<Student> showstudentbypage(Page page) throws Exception;

	public int adselpage() throws Exception;

	public Student selstudentbyid(String id) throws Exception;

	public List<Student> selstudentbyname(String name) throws Exception;

	public List<Student> showstudentbypageOrderbygrade(Page page) throws Exception;
	public List<Student> showstudentbypageorderbycla(Page page) throws Exception;
}
