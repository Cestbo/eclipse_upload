package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.company.dao.IFamilyDAO;
import cn.company.vo.Dormitory;
import cn.company.vo.Family;

public class FamilyDAO implements IFamilyDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public FamilyDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean add(Family family) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "INSERT INTO family(FamilyNum,SNo,father,mother,address,F_PNum,M_PNum,F_job,M_job,IsAlone)VALUES(?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1,family.getFamilyNum() );
		pstmt.setString(2,family.getSNo());
		pstmt.setString(3,family.getFather() );
		pstmt.setString(4,family.getMother() );
		pstmt.setString(5,family.getAddress()  );
		pstmt.setString(6,family.getF_PNum() );
		pstmt.setString(7,family.getM_PNum());
		pstmt.setString(8,family.getF_job());
		pstmt.setString(9,family.getM_job() );
		pstmt.setBoolean(10, family.isIsAlone());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Family> findAll(String FamilyNum) throws Exception {
		// TODO 自动生成的方法存根
		return null;
		
	}

	@Override
	public Family findById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		Family family=new Family();
		String sql="SELECT * FROM family WHERE SNo=? ";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, SNo);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			
			family.setFamilyNum(rs.getString(1));
			family.setSNo(rs.getString(2));
			family.setFather(rs.getString(3));
			family.setMother(rs.getString(4));
			family.setAddress(rs.getString(5));
			family.setF_PNum(rs.getString(6));
			family.setM_PNum(rs.getString(7));
			family.setF_job(rs.getString(8));
			family.setM_job(rs.getString(9));
			family.setIsAlone(rs.getBoolean(10));
		}
		this.pstmt.close();
		return family;
	}

	@Override
	public boolean deleteById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		String sql="DELETE  FROM family WHERE SNo=? ";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, SNo);
		if(this.pstmt.executeUpdate(sql)>0){
			this.pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Family family) throws Exception {
		// TODO 自动生成的方法存根
		String sql="UPDATE family set FamilyNum=?,SNo=?,father=?,mother=?,address=?,F_PNum=?,M_PNum=?,F_job=?,M_job=?,IsAlone=? WHERE SNo=?";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setString(1, family.getFamilyNum());
		pstmt.setString(2, family.getSNo());
		pstmt.setString(3, family.getFather());
		pstmt.setString(4, family.getMother());
		pstmt.setString(5, family.getAddress());
		pstmt.setString(6, family.getF_PNum());
		pstmt.setString(7, family.getM_PNum());
		pstmt.setString(8, family.getF_job());
		pstmt.setString(9, family.getM_job());
		pstmt.setBoolean(10, family.isIsAlone());
		pstmt.setString(11, family.getSNo());
		if(this.pstmt.executeUpdate()>0){
			this.pstmt.close();
			return true;
		}
		return false;
	}

}
