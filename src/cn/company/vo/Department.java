package cn.company.vo;

public class Department {
	private String DNo;
	private String ANo;
	private String Dname;
	
	
	public Department() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Department(String dNo, String aNo, String dname) {
		super();
		DNo = dNo;
		ANo = aNo;
		Dname = dname;
	}
	public String getDNo() {
		return DNo;
	}
	public void setDNo(String dNo) {
		DNo = dNo;
	}
	public String getANo() {
		return ANo;
	}
	public void setANo(String aNo) {
		ANo = aNo;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	@Override
	public String toString() {
		return "Department [DNo=" + DNo + ", ANo=" + ANo + ", Dname=" + Dname
				+ "]";
	}


}
