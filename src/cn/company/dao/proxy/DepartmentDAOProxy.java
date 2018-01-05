package cn.company.dao.proxy;

import java.sql.SQLException;
import java.util.List;

import cn.company.dao.IDepartmentDAO;
import cn.company.dao.impl.AcademyDAO;
import cn.company.dao.impl.DepartmentDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Department;

public class DepartmentDAOProxy implements IDepartmentDAO {
	private DatabaseConnection dbc=null;
	private DepartmentDAO dao=null;
	
	public DepartmentDAOProxy() throws Exception {
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new DepartmentDAO(this.dbc.getConnection());
	}

	@Override
	public String getDnameByDNo(String DNo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getDnameByDNo(DNo);
	}

	@Override
	public List<Department> findByANo(String ANo) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.findByANo(ANo);
	}

	@Override
	public String getDNoByDname(String Dname) throws SQLException {
		// TODO �Զ����ɵķ������
		return dao.getDNoByDname(Dname);
	}


}
