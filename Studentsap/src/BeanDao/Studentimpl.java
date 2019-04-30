package BeanDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Bean.Student;
import BeanMapper.StudentMapper;
import util.Page;

public class Studentimpl implements StudentMapper {
	SqlSession sqlsession;

	public Studentimpl(SqlSession sqlsession)  {
		// TODO Auto-generated constructor stub
		this.sqlsession = sqlsession;

	}

	@Override
	public void insertstudent(Student student)  throws Exception {
		// TODO Auto-generated method stub

		sqlsession.insert("student.insertstudent", student);
		sqlsession.commit();

	}

	@Override
	public void delstudentbyid(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.delete("student.delstudentbyid", id);
		sqlsession.commit();

	}

	@Override
	public void mostudent(Student student) throws Exception {
		// TODO Auto-generated method stub

		sqlsession.update("student.mostudent", student);
		sqlsession.commit();
	}

	@Override
	public List<Student> showallstudent()  throws Exception{
		// TODO Auto-generated method stub
		List<Student> students = sqlsession.selectList("student.showallstudent");
		return students;
	}

	@Override
	public List<Student> showstudentbypage(Page page) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students = sqlsession.selectList("student.showstudentbypage", page);

		return students;
	}

	@Override
	public int adselpage() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("student.adselpage");
	}

	@Override
	public Student selstudentbyid(String id) throws Exception {
		// TODO Auto-generated method stub
		Student student=sqlsession.selectOne("student.selstudentbyid",id);
		return student;
	}

	@Override
	public List<Student> selstudentbyname(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students = sqlsession.selectList("selstudentbyname",name);
		return students;
	}
	public List<Student> showstudentbypageOrderbygrade(Page page) throws Exception
	{
		List<Student> students = sqlsession.selectList("showstudentbypageOrderbygrade",page);
		return students;
	}
	@Override
	public List<Student> showstudentbypageorderbycla(Page page) throws Exception {
		// TODO Auto-generated method stub
		List<Student> students = sqlsession.selectList("showstudentbypageorderbycla",page);
		return students;
	}

}
