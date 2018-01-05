package cn.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;





import cn.company.dao.IStudentDAO;
import cn.company.vo.Student;

public class StudentDAO implements IStudentDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public StudentDAO(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean add(Student student) throws Exception {
		// TODO 自动生成的方法存根

		boolean flag = false;
		String sql = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student.getSNo());
		pstmt.setString(2, student.getFamilyNum());
		pstmt.setString(3,student.getDNo());
		pstmt.setString(4, student.getRoomNum());
		pstmt.setString(5, student.getBuildingNum());
		pstmt.setString(6, student.getANo());
		pstmt.setString(7, student.getSex());
		pstmt.setString(8, student.getName());
		pstmt.setDate(9, (java.sql.Date) student.getEnter_Date());
		pstmt.setString(10,student.getSphoneNum());
		pstmt.setDate(11, (java.sql.Date)student.getBirthday());
		pstmt.setString(12, student.getMidSch());
		pstmt.setString(13, student.getExScore());
		pstmt.setString(14, student.getIdcard());
		pstmt.setString(15, student.getGoWhere());
		pstmt.setString(16, student.getQqNum());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Student> findAll(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		List<Student> all=new LinkedList<Student>();
		String sql="SELECT * FROM Student WHERE SNo LIKE ?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "%"+SNo+"%");
		ResultSet rs=pstmt.executeQuery();
		Student student=null;
		while(rs.next()){
			student=new Student();
			student.setSNo(rs.getString(1));
			student.setFamilyNum(rs.getString(2));
			student.setDNo(rs.getString(3));
			student.setRoomNum(rs.getString(4));
			student.setBuildingNum(rs.getString(5));
			student.setANo(rs.getString(6));
			student.setSex(rs.getString(7));
			student.setName(rs.getString(8));
			student.setEnter_Date(rs.getDate(9));
			student.setSphoneNum(rs.getString(10));
			student.setBirthday(rs.getDate(11));
			student.setMidSch(rs.getString(12));
			student.setExScore(rs.getString(13));
			student.setIdcard(rs.getString(14));
			student.setGoWhere(rs.getString(15));
			student.setQqNum(rs.getString(16));
			all.add(student);
		}
		pstmt.close();
		return all;
	}


	@Override
	public boolean deleteById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM Student WHERE SNo=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, SNo);
		if(pstmt.executeUpdate()>0){
			pstmt.close();
			return true;
		}
		return false;
	}
	@Override
	public boolean update(Student student) throws Exception {
		// TODO 自动生成的方法存根
		String sql="UPDATE Student SET qqNum=?,FamilyNum=?,DNo=?,RoomNum=?,BuildingNum=?,ANo=?,sex=?,name=?,Enter_Date=?,SphoneNum=?,birthday=?,MidSch=?,ExScore=?,Idcard=?,GoWhere=? WHERE SNo=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, student.getQqNum());
		
		pstmt.setString(2, student.getFamilyNum());
		pstmt.setString(3, student.getDNo());
		pstmt.setString(4, student.getRoomNum());
		pstmt.setString(5, student.getBuildingNum());
		pstmt.setString(6, student.getANo());
		pstmt.setString(7, student.getSex());
		pstmt.setString(8, student.getName());
		pstmt.setDate(9, student.getEnter_Date());
		pstmt.setString(10, student.getSphoneNum());
		pstmt.setDate(11, student.getBirthday());
		pstmt.setString(12, student.getMidSch());
		pstmt.setString(13, student.getExScore());
		pstmt.setString(14, student.getIdcard());
		pstmt.setString(15, student.getGoWhere());
		pstmt.setString(16, student.getSNo());
		if(pstmt.executeUpdate()>0){
			return true;
		}
		pstmt.close();
		return false;
	}
	@Override
	public Student getStudentBySNo(String SNo) throws Exception {
		String sql="SELECT * FROM Student WHERE SNo=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, SNo);
		ResultSet rs=pstmt.executeQuery();
		Student student=new Student();
		while(rs.next()){
			student.setSNo(rs.getString(1));
			student.setFamilyNum(rs.getString(2));
			student.setDNo(rs.getString(3));
			student.setRoomNum(rs.getString(4));
			student.setBuildingNum(rs.getString(5));
			student.setANo(rs.getString(6));
			student.setSex(rs.getString(7));
			student.setName(rs.getString(8));
			student.setEnter_Date(rs.getDate(9));
			student.setSphoneNum(rs.getString(10));
			student.setBirthday(rs.getDate(11));
			student.setMidSch(rs.getString(12));
			student.setExScore(rs.getString(13));
			student.setIdcard(rs.getString(14));
			student.setGoWhere(rs.getString(15));
			student.setQqNum(rs.getString(16));
		}
		return student;
	}
	
}
