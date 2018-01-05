package cn.company.vo;

public class Academy {
	private String ANo;
	private String AName;
	
	
	
	public Academy() {
		super();
	}
	public Academy(String aNo, String aName) {
		super();
		ANo = aNo;
		AName = aName;
	}
	public String getANo() {
		return ANo;
	}
	public void setANo(String aNo) {
		ANo = aNo;
	}
	public String getAName() {
		return AName;
	}
	public void setAName(String aName) {
		AName = aName;
	}
	@Override
	public String toString() {
		return "Academy [ANo=" + ANo + ", AName=" + AName + "]";
	}

}
