package cn.company.vo;

import java.util.Date;

public class Punishment {
	private String Pno;
	private String SNo;
	private String PText;
	private Date P_Date;
	
	
	public Punishment() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Punishment(String pno, String sNo, String pText, Date p_Date) {
		super();
		Pno = pno;
		SNo = sNo;
		PText = pText;
		P_Date = p_Date;
	}
	public String getPno() {
		return Pno;
	}
	public void setPno(String pno) {
		Pno = pno;
	}
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getPText() {
		return PText;
	}
	public void setPText(String pText) {
		PText = pText;
	}
	public Date getP_Date() {
		return P_Date;
	}
	public void setP_Date(Date p_Date) {
		P_Date = p_Date;
	}
	@Override
	public String toString() {
		return "Punishment [Pno=" + Pno + ", SNo=" + SNo + ", PText=" + PText
				+ ", P_Date=" + P_Date + "]";
	}
	

}
