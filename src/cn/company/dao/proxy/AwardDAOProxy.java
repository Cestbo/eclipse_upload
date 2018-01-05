package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IAwardDAO;
import cn.company.dao.impl.AcademyDAO;
import cn.company.dao.impl.AwardDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Award;

public class AwardDAOProxy implements IAwardDAO {
	private DatabaseConnection dbc=null;
	private AwardDAO dao=null;
	
	public AwardDAOProxy() throws Exception {
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new AwardDAO(this.dbc.getConnection());
	}
	@Override
	public boolean add(Award award) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.add(award);
	}

	@Override
	public List<Award> findAll(String AwardNum) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public List<Award> findBySNo(String SNo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.findBySNo(SNo);
	}

	@Override
	public boolean deleteById(String AwardNum) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.deleteById(AwardNum);
	}

	@Override
	public boolean update(Award award) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.update(award);
	}
	@Override
	public int getAwardSize() throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getAwardSize();
	}

}
