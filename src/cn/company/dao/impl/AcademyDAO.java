package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;

import cn.company.dao.IAcademyDAO;
import cn.company.vo.Academy;
import cn.company.vo.Dormitory;

public class AcademyDAO implements IAcademyDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public AcademyDAO(Connection conn) {
		this.conn = conn;
	}
		
	@Override
	public List<Academy> findAll(String ANo) throws Exception {
		// TODO 自动生成的方法存根
		List<Academy> all=new ArrayList<Academy>();
		Academy academy=null;
		String sql="SELECT * FROM academy WHERE ANo LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+ANo+"%");
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			academy=new Academy();
			academy.setANo(rs.getString(1));
			academy.setAName(rs.getString(2));
			all.add(academy);
		}
		this.pstmt.close();
		return all;
	}
	@Override
	public String getANameByANo(String ANo) throws Exception {
		List<Academy> list=findAll(ANo);
		String AName=list.get(0).getAName();
		return AName;
	}

	@Override
	public String getANoByAName(String AName) throws Exception {
		// TODO 自动生成的方法存根
		String ANo=null;
		String sql="SELECT ANo from Academy WHERE AName=?";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setString(1, AName);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			ANo=rs.getString(1);
			System.out.println(ANo);
		}
		this.pstmt.close();
		return ANo;
	}


}
