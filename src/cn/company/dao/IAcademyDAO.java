package cn.company.dao;

import java.util.List;

import cn.company.vo.Academy;

public interface IAcademyDAO {

	public List<Academy> findAll(String ANo)throws Exception;
	public String getANameByANo(String ANo) throws Exception;
	public String getANoByAName(String AName) throws Exception;
	//public boolean deleteById(String ANo) throws Exception;
	//public boolean update(String id)throws Exception;
	//public Academy findById(String ANo) throws Exception;
}
