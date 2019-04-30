package BeanDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Bean.Teacher;
import Bean.Teacher;
import BeanMapper.TeacherMapper;
import util.Page;

public class Teacherimpl implements TeacherMapper {
	SqlSession sqlsession;

	public Teacherimpl(SqlSession sqlsession) {
		// TODO Auto-generated constructor stub
		this.sqlsession = sqlsession;

	}

	
	@Override
	public void insertteacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub

		sqlsession.insert("teacher.insertteacher", teacher);
		sqlsession.commit();

	}

	@Override
	public void delteacherbyid(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.delete("teacher.delteacherbyid", id);
		sqlsession.commit();

	}

	@Override
	public void moteacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub

		sqlsession.update("teacher.moteacher", teacher);
		sqlsession.commit();
	}

	@Override
	public List<Teacher> showallteacher() throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = sqlsession.selectList("teacher.showallteacher");
		return teachers;
	}

	@Override
	public List<Teacher> showteacherbypage(Page page) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = sqlsession.selectList("teacher.showteacherbypage", page);

		return teachers;
	}

	@Override
	public int adselpage() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("teacher.adselpage");
	}

	@Override
	public Teacher selteacherbyid(String id) throws Exception {
		// TODO Auto-generated method stub
		Teacher teacher=sqlsession.selectOne("teacher.selteacherbyid",id);
		return teacher;
	}

	@Override
	public List<Teacher> selteacherbyname(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = sqlsession.selectList("selteacherbyname",name);
		return teachers;
	}

}
