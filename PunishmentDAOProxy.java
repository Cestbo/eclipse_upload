package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IPunishmentDAO;
import cn.company.vo.Punishment;

public class PunishmentDAOProxy implements IPunishmentDAO {

	@Override
	public boolean add(Punishment punishment) throws Exception {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public List<Punishment> findAll(String SNo) throws Exception {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean deleteById(String Pno) throws Exception {
		// TODO �Զ����ɵķ������
		return false;
	}

}
