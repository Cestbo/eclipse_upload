package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.company.dao.IAcademyDAO;
import cn.company.dao.IAwardDAO;
import cn.company.vo.Academy;
import cn.company.vo.Award;

public class AwardDAO implements IAwardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public AwardDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean add(Award award) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql="INSERT INTO Award (AwardNum,SNo,AwardText,Money,A_Date)values(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1,award.getAwardNum() );
		pstmt.setString(2, award.getSNo());
		pstmt.setString(3, award.getAwardText());
		pstmt.setDouble(4, award.getMoney());
		pstmt.setDate(5, (java.sql.Date)award.getA_Date());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}

	@Override
	public List<Award> findAll(String AwardNum) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Award> findBySNo(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		List<Award> all=new ArrayList<Award>();
		String sql="SELECT * FROM Award Where SNo=?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, SNo);
		ResultSet rs=pstmt.executeQuery();
		Award award=null;
		while(rs.next()){
		award=new Award();
		award.setAwardNum(rs.getString(1));
		award.setSNo(rs.getString(2));
		award.setAwardText(rs.getString(3));
		award.setMoney(rs.getInt(4));
		award.setA_Date(rs.getDate(5));
		all.add(award);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean deleteById(String AwardNum) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		String sql="DELETE FROM Award WHERE AwardNum=? ";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, AwardNum);
		if(pstmt.executeUpdate()>0){
			this.pstmt.close();
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean update(Award award) throws Exception {
		// TODO 自动生成的方法存根
		String sql="UPDATE Award setAwardNum=?,SNo=?,AwardText=?,Money=?,A_Date=? WHERE AwardNum=? and SNo=? ";
		this.pstmt=this.conn.prepareStatement(sql);
		pstmt.setString(1,award.getAwardNum() );
		pstmt.setString(2, award.getSNo());
		pstmt.setString(3, award.getAwardText());
		pstmt.setInt(4, award.getMoney());
		pstmt.setDate(5, (java.sql.Date)award.getA_Date());
		if(this.pstmt.executeUpdate(sql)>0){
			this.pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public int getAwardSize() throws Exception {
		// TODO 自动生成的方法存根
		int size=0;
		String sql="SELECT COUNT(*) FROM Award";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			size=rs.getInt(1);
		}
		return size;
	}

	


	

}
