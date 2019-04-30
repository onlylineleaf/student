package BeanMapper;

import java.util.List;

import Bean.Teacher;
import util.Page;

public interface TeacherMapper {

		public void insertteacher(Teacher teacher) throws Exception;

		public void delteacherbyid(String id) throws Exception;

		public void moteacher(Teacher teacher) throws Exception;

		public List<Teacher> showallteacher() throws Exception;

		public List<Teacher> showteacherbypage(Page page) throws Exception;

		public int adselpage() throws Exception;

		public Teacher selteacherbyid(String id) throws Exception;

		public List<Teacher> selteacherbyname(String name) throws Exception;

	}
