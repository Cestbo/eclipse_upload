package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;

import com.sun.media.sound.SoftInstrument;

import cn.company.dao.IAdministratorDAO;

import cn.company.vo.Administrator;

public class AdministratorDAO implements IAdministratorDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public AdministratorDAO(Connection conn) {
		this.conn = conn;
	}
		
	@Override
	public boolean updatePassword(Administrator administrator) throws Exception {
		// TODO 自动生成的方法存根
		String sql="UPDATE Administrator SET ad_password=? WHERE ad_name=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, administrator.getAd_password());
		pstmt.setString(2, administrator.getAd_name());
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public Administrator getAdministratorByName(String Name) throws Exception {
		// TODO Auto-generated method stub
		Administrator administrator=new Administrator();
		String sql="SELECT * FROM Administrator WHERE ad_name=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, Name);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			administrator.setAd_name(rs.getString(1));
			administrator.setAd_password(rs.getString(2));
		}
		
		return administrator;
	}



}
