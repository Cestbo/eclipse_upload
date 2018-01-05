package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.company.dao.IDepartmentDAO;
import cn.company.vo.Department;

public class DepartmentDAO implements IDepartmentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public DepartmentDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Department> findByANo(String ANo) throws Exception {
		// TODO 自动生成的方法存根
		List<Department> all=new ArrayList<Department>();
		Department department=null;
		String sql="SELECT * FROM department WHERE ANo= ? ";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1,ANo );
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			department=new Department();
			department.setDNo(rs.getString(1));
			department.setANo(rs.getString(2));
			department.setDname(rs.getString(3));
			all.add(department);
		}
		this.pstmt.close();
		return all;
		
	}
	@Override
	public String getDnameByDNo(String DNo) throws Exception {
		// TODO 自动生成的方法存根
		String Dname=null;
		String sql="SELECT Dname FROM Department WHERE DNo=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, DNo);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Dname=rs.getString(1);
		}
		this.pstmt.close();
    	return Dname;
	}

	@Override
	public String getDNoByDname(String Dname) throws SQLException {
		String DNo=null;
    	String sql="SELECT DNo FROM Department WHERE Dname=?";
    	pstmt=conn.prepareStatement(sql);
    	this.pstmt.setString(1, Dname);
    	ResultSet rs=pstmt.executeQuery();
    	while(rs.next()){
    		DNo=rs.getString(1);
    	}
    	this.pstmt.close();
    	return DNo;
	}

}
