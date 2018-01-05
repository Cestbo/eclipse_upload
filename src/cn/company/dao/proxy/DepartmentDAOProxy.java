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
		// TODO 自动生成的构造函数存根
		this.dbc=new DatabaseConnection();
		this.dao=new DepartmentDAO(this.dbc.getConnection());
	}

	@Override
	public String getDnameByDNo(String DNo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.getDnameByDNo(DNo);
	}

	@Override
	public List<Department> findByANo(String ANo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.findByANo(ANo);
	}

	@Override
	public String getDNoByDname(String Dname) throws SQLException {
		// TODO 自动生成的方法存根
		return dao.getDNoByDname(Dname);
	}


}
