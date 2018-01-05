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
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new FamilyDAO(this.dbc.getConnection());
	}

	@Override
	public boolean add(Family family) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.add(family);
	}

	@Override
	public List<Family> findAll(String FamilyNum) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Family findById(String SNo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.findById(SNo);
	}

	@Override
	public boolean deleteById(String SNo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.deleteById(SNo);
	}

	@Override
	public boolean update(Family family) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.update(family);
	}

}
