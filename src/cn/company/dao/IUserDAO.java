package cn.company.dao;

import java.util.List;

import cn.company.vo.User;

public interface IUserDAO {
	public boolean add(User user) throws Exception;
	public boolean delete(String user_id) throws Exception;
	public boolean update(User user) throws Exception;
	public User getUserByUser_id(String user_id)throws Exception;
}
