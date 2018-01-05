package cn.company.dao.proxy;

import cn.company.dao.IAdministratorDAO;
import cn.company.dao.impl.AdministratorDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Administrator;

public class AdministratorDAOProxy implements IAdministratorDAO {
	private DatabaseConnection dbc=null;
	private AdministratorDAO dao=null;
	
	public AdministratorDAOProxy() throws Exception {
		// TODO 自动生成的构造函数存根
		this.dbc=new DatabaseConnection();
		this.dao=new AdministratorDAO(this.dbc.getConnection());
	}

	@Override
	public boolean updatePassword(Administrator administrator) throws Exception {
		// TODO 自动生成的方法存根
		return dao.updatePassword(administrator);
	}

	@Override
	public Administrator getAdministratorByName(String Name) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAdministratorByName(Name);
	}


}
