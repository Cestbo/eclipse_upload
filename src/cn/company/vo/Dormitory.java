package cn.company.vo;

public class Dormitory {
	private String RoomNum;
	private String BuildingNum;
	private int NumOfStu;
	private String Leader;

	public Dormitory() {

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

	public int getNumOfStu() {
		return NumOfStu;
	}

	public void setNumOfStu(int numOfStu) {
		NumOfStu = numOfStu;
	}

	public String getLeader() {
		return Leader;
	}

	public void setLeader(String leader) {
		Leader = leader;
	}

	public Dormitory(String roomNum, String buildingNum, int numOfStu,
			String leader) {
		super();
		RoomNum = roomNum;
		BuildingNum = buildingNum;
		NumOfStu = numOfStu;
		Leader = leader;
	}

	@Override
	public String toString() {
		return "Dormitory [RoomNum=" + RoomNum + ", BuildingNum=" + BuildingNum
				+ ", NumOfStu=" + NumOfStu + ", Leader=" + Leader + "]";
	}



}
