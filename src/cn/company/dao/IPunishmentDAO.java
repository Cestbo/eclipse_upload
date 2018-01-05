package cn.company.dao;

import java.util.List;

import cn.company.vo.Punishment;

public interface IPunishmentDAO {
	public boolean add(Punishment punishment) throws Exception;
	public List<Punishment> findAll(String SNo)throws Exception;
	public boolean deleteById(String Pno) throws Exception;
	public  int getPunishmentSize()throws Exception;
}
