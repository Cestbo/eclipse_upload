package cn.company.dao;

import java.util.List;

import cn.company.vo.Family;

public interface IFamilyDAO {
	public boolean add(Family family) throws Exception;
	public List<Family> findAll(String FamilyNum)throws Exception;
	public Family findById(String SNo) throws Exception ;
	public boolean deleteById(String SNo) throws Exception ;
	public boolean update(Family family) throws Exception ;
}
