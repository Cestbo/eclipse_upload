package cn.company.dao.proxy;

import java.util.List;

import cn.company.dao.IDormitoryDAO;
import cn.company.dao.impl.DormitoryDAO;
import cn.company.dbc.DatabaseConnection;
import cn.company.vo.Dormitory;

public class DormitoryDAOProxy implements IDormitoryDAO {
	private DatabaseConnection dbc=null;
	private DormitoryDAO dao=null;
	
	public DormitoryDAOProxy() throws Exception {
		// TODO �Զ����ɵĹ��캯�����
		this.dbc=new DatabaseConnection();
		this.dao=new DormitoryDAO(this.dbc.getConnection());
	}

	@Override
	public boolean add(Dormitory dormitory) throws Exception {
		// TODO �Զ����ɵķ������
		boolean flag=false;
		try {
			Dormitory d=dao.findById(dormitory.getRoomNum(), dormitory.getBuildingNum());
			if(d==null){
				flag=dao.add(dormitory);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			throw e;
		}finally{
			dbc.close();
		}
		return flag;
	}

	@Override
	public List<Dormitory> findAll(String keyWord) throws Exception {
		// TODO �Զ����ɵķ������
		List<Dormitory> all=null;
		try {
			all=dao.findAll(keyWord);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			throw e;
		}finally{
			dbc.close();
		}
		return all;
		
	}

	@Override
	public Dormitory findById(String RoomNum, String BuildingNum) throws Exception {
		// TODO �Զ����ɵķ������
		Dormitory dormitory=null;
		try {
			dormitory=dao.findById(RoomNum, BuildingNum);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			throw e;
		}finally{
			dbc.close();
		}
		return dormitory;
	}

	@Override
	public boolean deleteById(String RoomNum, String BuildingNum) throws Exception {
		// TODO �Զ����ɵķ������
		if(dao.deleteById(RoomNum, BuildingNum)){
			return true;
			
		}else{
			return false;
		}
	}


	@Override
	public boolean update(String RoomNum, String BuildingNum) throws Exception {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public List<String> getBuildingNums() throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getBuildingNums();
	}

	@Override
	public List<String> getRoomNumByBuildingNum(String BuildingNum) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.getRoomNumByBuildingNum(BuildingNum);
	}
	
}
