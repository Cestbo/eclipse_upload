package cn.company.dao;

import java.util.List;

import cn.company.vo.Award;
import cn.company.vo.Punishment;

public interface IAwardDAO {
	public boolean add(Award Award) throws Exception;
	public List<Award> findAll(String AwardNum)throws Exception;
	//public List<Award> findBySNo(String SNo) throws Exception;
	public boolean deleteById(String AwardNum) throws Exception;
	public boolean update(Award award)throws Exception;
	List<Award> findBySNo(String SNo) throws Exception;
	public  int getAwardSize()throws Exception;
//	public List<Punishment> findAll(String SNo)throws Exception;
	//public boolean deleteById(String Pno) throws Exception;
}
