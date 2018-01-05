package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IPunishmentDAO;
import cn.company.dao.impl.AwardDAO;
import cn.company.dao.impl.PunishmentDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Punishment;

public class PunishmentDAOProxy implements IPunishmentDAO {
	private DatabaseConnection dbc=null;
	private PunishmentDAO dao=null;
	
	public PunishmentDAOProxy() throws Exception {
		// TODO 自动生成的构造函数存根
		this.dbc=new DatabaseConnection();
		this.dao=new PunishmentDAO(this.dbc.getConnection());
	}
	@Override
	public boolean add(Punishment punishment) throws Exception {
		// TODO 自动生成的方法存根
		return dao.add(punishment);
	}

	@Override
	public List<Punishment> findAll(String SNo) throws Exception {
		// TODO 自动生成的方法存根
		return dao.findAll(SNo);
	}

	@Override
	public boolean deleteById(String Pno) throws Exception {
		// TODO 自动生成的方法存根
		return dao.deleteById(Pno);
	}
	@Override
	public int getPunishmentSize() throws Exception {
		// TODO 自动生成的方法存根
		return dao.getPunishmentSize();
	}

}
