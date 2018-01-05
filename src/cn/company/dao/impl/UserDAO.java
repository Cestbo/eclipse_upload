package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import cn.company.dao.IUserDAO;
import cn.company.vo.User;

public class UserDAO implements IUserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public UserDAO(Connection conn) {
		this.conn = conn;
	}
		
	@Override
	public boolean add(User user) throws Exception {
		// TODO 自动生成的方法存根
		String sql="INSERT INTO Users (user_id,user_password) values(?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_id());
		pstmt.setString(2, user.getUser_password());
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String user_id) throws Exception {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM Users WHERE user_id=?";
		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User user) throws Exception {
		// TODO 自动生成的方法存根
		String sql="UPDATE  Users SET user_password=? WHERE user_id=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user.getUser_password());
		pstmt.setString(2, user.getUser_id());
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}

	@Override
	public User getUserByUser_id(String user_id) throws Exception {
		// TODO Auto-generated method stub
		
		User user=new User();
		String sql="SELECT * FROM Users WHERE user_id=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			user.setUser_id(rs.getString(1));
			user.setUser_password(rs.getString(2));
		}
		
		return user;
	}


}
