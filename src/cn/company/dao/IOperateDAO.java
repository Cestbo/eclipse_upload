package cn.company.dao;

import java.util.List;

public interface IOperateDAO <T> {
	public boolean add(T t) throws Exception;
	public List<T> findAll(String id)throws Exception;
	public T findById(String id) throws Exception;
	public boolean deleteById(String id) throws Exception;
	public boolean update(String id)throws Exception;
}
