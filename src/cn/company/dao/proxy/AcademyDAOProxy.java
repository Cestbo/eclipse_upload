package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IAcademyDAO;
import cn.company.dao.impl.AcademyDAO;
import cn.company.dao.impl.DormitoryDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Academy;

public class AcademyDAOProxy implements IAcademyDAO {
	private DatabaseConnection dbc=null;
	private AcademyDAO dao=null;
	
	public AcademyDAOProxy() throws Exception {
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new AcademyDAO(this.dbc.getConnection());
	}
	@Override
	public List<Academy> findAll(String Ano) throws Exception {
		return dao.findAll(Ano);
	}

	@Override
	public String getANameByANo(String ANo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getANameByANo(ANo);
	}

	@Override
	public String getANoByAName(String AName) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getANoByAName(AName);
	}

}
