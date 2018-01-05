package cn.company.vo;

import java.sql.Date;

public class Student {
	private String SNo;
	private String FamilyNum;
	private String DNo;
	private String RoomNum;
	private String BuildingNum;
	private String ANo;
	private String sex;
	private String name;
	private Date Enter_Date;
	private String SphoneNum;
	private Date birthday;
	private String MidSch;
	private String ExScore;
	private String Idcard;
	private String GoWhere;
	private String qqNum;
	public Student(){
		
	}
	public Student(String sNo, String familyNum, String dNo, String roomNum,
			String buildingNum, String aNo, String sex, String name,
			Date enter_Date, String sphoneNum, Date birthday, String midSch,
			String exScore, String idcard, String goWhere, String qqNum) {
		super();
		SNo = sNo;
		FamilyNum = familyNum;
		DNo = dNo;
		RoomNum = roomNum;
		BuildingNum = buildingNum;
		ANo = aNo;
		this.sex = sex;
		this.name = name;
		Enter_Date = enter_Date;
		SphoneNum = sphoneNum;
		this.birthday = birthday;
		MidSch = midSch;
		ExScore = exScore;
		Idcard = idcard;
		GoWhere = goWhere;
		this.qqNum = qqNum;
	}
	
	
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getFamilyNum() {
		return FamilyNum;
	}
	public void setFamilyNum(String familyNum) {
		FamilyNum = familyNum;
	}
	public String getDNo() {
		return DNo;
	}
	public void setDNo(String dNo) {
		DNo = dNo;
	}
	public String getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}
	public String getBuildingNum() {
		return BuildingNum;
	}
	public void setBuildingNum(String buildingNum) {
		BuildingNum = buildingNum;
	}
	public String getANo() {
		return ANo;
	}
	public void setANo(String aNo) {
		ANo = aNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEnter_Date() {
		return Enter_Date;
	}
	public void setEnter_Date(Date enter_Date) {
		Enter_Date = enter_Date;
	}
	public String getSphoneNum() {
		return SphoneNum;
	}
	public void setSphoneNum(String sphoneNum) {
		SphoneNum = sphoneNum;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMidSch() {
		return MidSch;
	}
	public void setMidSch(String midSch) {
		MidSch = midSch;
	}
	public String getExScore() {
		return ExScore;
	}
	public void setExScore(String exScore) {
		ExScore = exScore;
	}
	public String getIdcard() {
		return Idcard;
	}
	public void setIdcard(String idcard) {
		Idcard = idcard;
	}
	public String getGoWhere() {
		return GoWhere;
	}
	public void setGoWhere(String goWhere) {
		GoWhere = goWhere;
	}
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

}
