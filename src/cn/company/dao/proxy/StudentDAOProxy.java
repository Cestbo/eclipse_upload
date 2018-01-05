package cn.company.dao.proxy;

import java.util.Iterator;
import java.util.List;

import cn.company.dao.IStudentDAO;
import cn.company.dao.impl.StudentDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Student;

public class StudentDAOProxy implements IStudentDAO {
	private DatabaseConnection dbc=null;
	private StudentDAO dao=null;
	
	public StudentDAOProxy() throws Exception {
		// TODO 自动生成的构造函数存根
		this.dbc=new DatabaseConnection();
		this.dao=new StudentDAO(this.dbc.getConnection());
	}
	@Override
	public boolean add(Student student) throws Exception {
		// TODO 自动生成的方法存根
//		if(!student.getSNo().isEmpty()&&!isExit(student.getSNo())){
//			
//		}
		dao.add(student);
		return true;
	}

	@Override
	public List<Student> findAll(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public boolean deleteById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.deleteById(SNo);
	}
	@Override
	public boolean update(Student student) throws Exception {
		// TODO 自动生成的方法存根
		dao.update(student);
		return true;
	}
	public boolean isExit(String SNo) throws Exception{
		List<Student> all=null;
			all=findAll(SNo);
			Iterator<Student> it=all.iterator();
			while(it.hasNext()){
				String sno=it.next().getSNo();
				if(sno.equals(SNo)){
					return true;
				}
			}
		return false;
	}
	public boolean isLimitSize(String SNo){
		return false;
	}
	@Override
	public Student getStudentBySNo(String SNo) throws Exception {
		
		return dao.getStudentBySNo(SNo);
	}

}
