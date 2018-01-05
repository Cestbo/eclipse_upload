package cn.company.formBean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;



public class StudentRegist {
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	private String SNo;
	private String FamilyNum;
	private String DNo;
	private String RoomNum;
	private String BuildingNum;
	private String ANo;
	private String sex;
	private String name;
	private String Enter_Date;
	private String SphoneNum;
	private String birthday;
	private String MidSch;
	private String ExScore;
	private String Idcard;
	private String GoWhere;
	private String qqNum;
	private Map<String,String> errors=new HashMap<String, String>();
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
	public String getEnter_Date() {
		return Enter_Date;
	}
	public void setEnter_Date(String enter_Date) {
		Enter_Date = enter_Date;
	}
	public String getSphoneNum() {
		return SphoneNum;
	}
	public void setSphoneNum(String sphoneNum) {
		SphoneNum = sphoneNum;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
	public boolean isLeagal(){
		
		boolean isOk=true;
		if(SNo==null||SNo.trim().equals("")){
			errors.put("SNo", "用户名不能为空");
			isOk=false;
		}else{
			if(!SNo.matches("[0-9]{3,8}")){
				errors.put("SNo", "用户名必须3-8位数字");
				isOk=false;
			}
		}
		if(birthday==null||birthday.trim().equals("")){
			errors.put("birthday", "出生日期不能为空");
			isOk=false;
		}
		if(birthday!=null&&!birthday.trim().equals("")){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			try {
				sm.parse(birthday);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				errors.put("birthday", "出生日期格式不对");
				isOk=false;
			}
		}
		if(Enter_Date==null||Enter_Date.trim().equals("")){
			errors.put("Enter_Date", "入学日期不能为空");
			isOk=false;
		}
		if(Enter_Date!=null&&!Enter_Date.trim().equals("")){
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
			try {
				sm.parse(Enter_Date);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				errors.put("Enter_Date", "入学日期格式不对");
				isOk=false;
			}
		}
		
		
		if(Idcard==null||Idcard.trim().equals("")){
			errors.put("Idcard", "身份证不能为空");
			isOk=false;
		}else{
			if(!Idcard.matches("[0-9]{18}")){
				errors.put("Idcard", "身份证必须18位数字");
				isOk=false;
			}
		}
		
		if(SphoneNum==null||SphoneNum.trim().equals("")){
			errors.put("SphoneNum", "电话证不能为空");
			isOk=false;
		}else{
			if(!SphoneNum.matches("[0-9]{11}")){
				errors.put("SphoneNum", "电话必须11位数字");
				isOk=false;
			}
		}
		return isOk;
		

	}
	public StudentRegist() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public StudentRegist(String sNo, String familyNum, String dNo,
			String roomNum, String buildingNum, String aNo, String sex,
			String name, String enter_Date, String sphoneNum, String birthday,
			String midSch, String exScore, String idcard, String goWhere,
			String qqNum) {
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
	
}
