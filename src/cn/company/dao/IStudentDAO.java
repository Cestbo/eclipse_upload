package cn.company.dao;

import java.util.List;

import cn.company.vo.Dormitory;
import cn.company.vo.Student;

public interface IStudentDAO {
	public boolean add(Student student) throws Exception;
	public List<Student> findAll(String SNo)throws Exception;
	public boolean deleteById(String SNo) throws Exception;
	public boolean update(Student student)throws Exception;
	public Student getStudentBySNo(String SNo)throws Exception;
}
