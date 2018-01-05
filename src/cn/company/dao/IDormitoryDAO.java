package cn.company.dao;

import java.util.List;

import cn.company.vo.Dormitory;

public interface IDormitoryDAO {
	public boolean add(Dormitory dormitory) throws Exception;
	public List<Dormitory> findAll(String keyWord)throws Exception;
	public Dormitory findById(String RoomNum,String BuildingNum) throws Exception;
	public boolean deleteById(String RoomNum,String BuildingNum) throws Exception;
	public boolean update(String RoomNum,String BuildingNum)throws Exception;
	public List<String> getBuildingNums() throws Exception;
	public List<String> getRoomNumByBuildingNum(String BuildingNum ) throws Exception;
}
