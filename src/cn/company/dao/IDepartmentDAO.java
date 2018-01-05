package cn.company.dao;

import java.sql.SQLException;
import java.util.List;

import cn.company.vo.Department;;

public interface IDepartmentDAO {
	//public boolean add(Department DNo) throws Exception;
	
	//public Department findById(String DNo) throws Exception;
	//public boolean deleteById(String DNo) throws Exception;
	public String getDnameByDNo(String DNo)throws Exception;
	public  List<Department> findByANo(String ANo)throws Exception;
	public String  getDNoByDname(String Dname) throws SQLException;
	//public boolean update(String id)throws Exception;
}
