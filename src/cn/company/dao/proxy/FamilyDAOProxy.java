package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IFamilyDAO;
import cn.company.dao.impl.DormitoryDAO;
import cn.company.dao.impl.FamilyDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Family;

public class FamilyDAOProxy implements IFamilyDAO {
	private DatabaseConnection dbc=null;
	private FamilyDAO dao=null;
	
	public FamilyDAOProxy() throws Exception {
		// TODO 自动生成的构造函数存根
		this.dbc=new DatabaseConnection();
		this.dao=new FamilyDAO(this.dbc.getConnection());
	}

	@Override
	public boolean add(Family family) throws Exception {
		// TODO 自动生成的方法存根
		return dao.add(family);
	}

	@Override
	public List<Family> findAll(String FamilyNum) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Family findById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.findById(SNo);
	}

	@Override
	public boolean deleteById(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.deleteById(SNo);
	}

	@Override
	public boolean update(Family family) throws Exception {
		// TODO 自动生成的方法存根
		return dao.update(family);
	}

}
