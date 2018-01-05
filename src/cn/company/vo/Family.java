package cn.company.vo;

public class Family {
	private String FamilyNum;
	private String SNo;
	private String father;
	private String mother;
	private String address;
	private String F_PNum;
	private String M_PNum;
	private String F_job;
	private String M_job;
	private boolean IsAlone;
	public Family(){
		
	}
	@Override
	public String toString() {
		return "Family [FamilyNum=" + FamilyNum + ", SNo=" + SNo + ", father="
				+ father + ", mother=" + mother + ", address=" + address
				+ ", F_PNum=" + F_PNum + ", M_PNum=" + M_PNum + ", F_job="
				+ F_job + ", M_job=" + M_job + ", IsAlone=" + IsAlone + "]";
	}
	public Family(String familyNum, String sNo, String father, String mother,
			String address, String f_PNum, String m_PNum, String f_job,
			String m_job, boolean isAlone) {
		super();
		FamilyNum = familyNum;
		SNo = sNo;
		this.father = father;
		this.mother = mother;
		this.address = address;
		F_PNum = f_PNum;
		M_PNum = m_PNum;
		F_job = f_job;
		M_job = m_job;
		IsAlone = isAlone;
	}
	public String getFamilyNum() {
		return FamilyNum;
	}
	public void setFamilyNum(String familyNum) {
		FamilyNum = familyNum;
	}
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getF_PNum() {
		return F_PNum;
	}
	public void setF_PNum(String f_PNum) {
		F_PNum = f_PNum;
	}
	public String getM_PNum() {
		return M_PNum;
	}
	public void setM_PNum(String m_PNum) {
		M_PNum = m_PNum;
	}
	public String getF_job() {
		return F_job;
	}
	public void setF_job(String f_job) {
		F_job = f_job;
	}
	public String getM_job() {
		return M_job;
	}
	public void setM_job(String m_job) {
		M_job = m_job;
	}
	public boolean isIsAlone() {
		return IsAlone;
	}
	public void setIsAlone(boolean isAlone) {
		IsAlone = isAlone;
	}
	

}
