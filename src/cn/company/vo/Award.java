package cn.company.vo;

import java.util.Date;

public class Award {
	private String AwardNum;
	private String SNo;
	private String AwardText;
	private int Money;
	private Date A_Date;
	
	
	public Award() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Award(String awardNum, String sNo, String awardText, int money,
			Date a_Date) {
		super();
		AwardNum = awardNum;
		SNo = sNo;
		AwardText = awardText;
		Money = money;
		A_Date = a_Date;
	}
	public String getAwardNum() {
		return AwardNum;
	}
	public void setAwardNum(String awardNum) {
		AwardNum = awardNum;
	}
	public String getSNo() {
		return SNo;
	}
	public void setSNo(String sNo) {
		SNo = sNo;
	}
	public String getAwardText() {
		return AwardText;
	}
	public void setAwardText(String awardText) {
		AwardText = awardText;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int d) {
		Money = d;
	}
	public Date getA_Date() {
		return A_Date;
	}
	public void setA_Date(Date a_Date) {
		A_Date = a_Date;
	}
	@Override
	public String toString() {
		return "Award [AwardNum=" + AwardNum + ", SNo=" + SNo + ", AwardText="
				+ AwardText + ", Money=" + Money + ", A_Date=" + A_Date + "]";
	}
	

}
