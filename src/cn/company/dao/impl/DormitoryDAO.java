package cn.company.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.company.dao.*;
import cn.company.vo.Dormitory;

public class DormitoryDAO implements IDormitoryDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public DormitoryDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean add(Dormitory dormitory) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "INSERT INTO dormitory(RoomNum,BuildingNum,NumOfStu,Leader)VALUES(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dormitory.getRoomNum());
		this.pstmt.setString(2, dormitory.getBuildingNum());
		this.pstmt.setInt(3, dormitory.getNumOfStu());
		this.pstmt.setString(4, dormitory.getLeader());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Dormitory> findAll(String keyWord) throws Exception {
		// TODO 自动生成的方法存根
		List<Dormitory> all=new ArrayList<Dormitory>();
		Dormitory dormitory=null;
		String sql="SELECT * FROM dormitory WHERE RoomNum LIKE ? OR BuildingNum LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyWord+"%");
		this.pstmt.setString(2, "%"+keyWord+"%");
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			dormitory=new Dormitory();
			dormitory.setRoomNum(rs.getString(1));
			dormitory.setBuildingNum(rs.getString(2));
			dormitory.setNumOfStu(rs.getInt(3));
			dormitory.setLeader(rs.getString(4));
			all.add(dormitory);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public Dormitory findById(String RoomNum, String BuildingNum) throws Exception{
		// TODO 自动生成的方法存根
		Dormitory dormitory=null;
		String sql="SELECT * FROM dormitory WHERE RoomNum=? AND BuildingNum=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, RoomNum);
		pstmt.setString(2, BuildingNum);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()){
			dormitory=new Dormitory();
			dormitory.setRoomNum(rs.getString(1));
			dormitory.setBuildingNum(rs.getString(2));
			dormitory.setNumOfStu(rs.getInt(3));
			dormitory.setLeader(rs.getString(4));
		}
		pstmt.close();
		return dormitory;
	}

	@Override
	public boolean deleteById(String RoomNum, String BuildingNum) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		String sql="DELETE FROM dormitory WHERE RoomNum=? AND BuildingNum=? ";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, RoomNum);
		pstmt.setString(2, BuildingNum);
		if(pstmt.executeUpdate()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean update(String RoomNum,String BuildingNum) throws Exception {
		// TODO 自动生成的方法存根
		
		return false;
	}

	@Override
	public List<String> getBuildingNums() throws Exception {
		// TODO 自动生成的方法存根
		List<String> all=new ArrayList<String>();
		String sql="SELECT distinct BuildingNum FROM Dormitory";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			all.add(rs.getString(1));
		}
		return all;
	}


	@Override
	public List<String> getRoomNumByBuildingNum(String BuildingNum) throws Exception {
		// TODO 自动生成的方法存根
		List<String> all=new ArrayList<String>();
		String sql="SELECT RoomNum FROM Dormitory WHERE BuildingNum=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, BuildingNum);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			all.add(rs.getString(1));
		}
		return all;
	}
	
	
}