package cn.company.vo;

public class Administrator {
	private String ad_name;
	private String ad_password;
	
	
	public Administrator() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Administrator(String ad_name, String ad_password) {
		super();
		this.ad_name = ad_name;
		this.ad_password = ad_password;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	@Override
	public String toString() {
		return "Administrator [ad_name=" + ad_name + ", ad_password="
				+ ad_password + "]";
	}
	
}
