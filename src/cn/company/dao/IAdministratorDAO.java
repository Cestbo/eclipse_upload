package cn.company.dao;

import java.util.List;

import cn.company.vo.Administrator;;

public interface IAdministratorDAO {
	public boolean updatePassword(Administrator administrator) throws Exception;
	public Administrator getAdministratorByName(String Name)throws Exception;
}
