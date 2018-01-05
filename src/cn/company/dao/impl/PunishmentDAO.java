package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.company.dao.IPunishmentDAO;
import cn.company.vo.Punishment;

public class PunishmentDAO implements IPunishmentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public PunishmentDAO(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean add(Punishment punishment) throws Exception {
		// TODO 自动生成的方法存根
		
		String sql="INSERT INTO Punishment (Pno,SNo,PText,P_Date)values(?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, punishment.getPno());
		pstmt.setString(2, punishment.getSNo());
		pstmt.setString(3, punishment.getPText());
		pstmt.setDate(4,  (java.sql.Date)punishment.getP_Date());
		if (pstmt.executeUpdate() >0){
			return true;
		}
		pstmt.close();
		return false;
	}

	@Override
	public List<Punishment> findAll(String SNo) throws Exception {
		List<Punishment> all=new ArrayList<Punishment>();
		String sql="SELECT * FROM Punishment WHERE SNo=? ";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, SNo);
		ResultSet rs=pstmt.executeQuery();
		Punishment punishment=null;
		while(rs.next()){
			punishment=new Punishment();
			punishment.setPno(rs.getString(1));
			punishment.setSNo(rs.getString(2));
			punishment.setPText(rs.getString(3));
			punishment.setP_Date(rs.getDate(4));
			all.add(punishment);
		}
		pstmt.close();
		return all;
	}



	@Override
	public boolean deleteById(String Pno) throws Exception {
		// TODO 自动生成的方法存根
		String sql="DELETE  FROM Punishment WHERE Pno=? ";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, Pno);
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}
	@Override
	public int getPunishmentSize() throws Exception {
			// TODO 自动生成的方法存根
			int size=0;
			String sql="SELECT COUNT(*) FROM Punishment";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				size=rs.getInt(1);
			}
			return size;
	
	}



}
