package cn.company.dao.proxy;

import cn.company.dao.IUserDAO;
import cn.company.dao.impl.StudentDAO;
import cn.company.dao.impl.UserDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.User;

public class UserDAOProxy implements IUserDAO {
	private DatabaseConnection dbc=null;
	private UserDAO dao=null;
	
	public UserDAOProxy() throws Exception {
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new UserDAO(this.dbc.getConnection());
	}
	@Override
	public boolean add(User user) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.add(user);
	}

	@Override
	public boolean delete(String user_id) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.delete(user_id);
	}

	@Override
	public boolean update(User user) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.update(user);
	}
	@Override
	public User getUserByUser_id(String user_id) throws Exception {
		// TODO Auto-generated method stub
		User user=dao.getUserByUser_id(user_id);
		System.out.println(user.getUser_id());
		return user;
	}

}
