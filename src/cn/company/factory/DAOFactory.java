package cn.company.factory;

import cn.company.dao.IAcademyDAO;
import cn.company.dao.IAdministratorDAO;
import cn.company.dao.IAwardDAO;
import cn.company.dao.IDepartmentDAO;
import cn.company.dao.IDormitoryDAO;
import cn.company.dao.IFamilyDAO;
import cn.company.dao.IPunishmentDAO;
import cn.company.dao.IStudentDAO;
import cn.company.dao.IUserDAO;
import cn.company.dao.proxy.AcademyDAOProxy;
import cn.company.dao.proxy.AdministratorDAOProxy;
import cn.company.dao.proxy.AwardDAOProxy;
import cn.company.dao.proxy.DepartmentDAOProxy;
import cn.company.dao.proxy.DormitoryDAOProxy;
import cn.company.dao.proxy.FamilyDAOProxy;
import cn.company.dao.proxy.PunishmentDAOProxy;
import cn.company.dao.proxy.StudentDAOProxy;
import cn.company.dao.proxy.UserDAOProxy;


public class DAOFactory {
	public static IDormitoryDAO getIDormitoryDAOInstance() throws Exception{
		 return  new DormitoryDAOProxy();
		
	}
	public static IStudentDAO getIStudentDAOInstance() throws Exception{
		 return  new StudentDAOProxy();
		
	}
	public static IAcademyDAO getIAcademyDAOInstance() throws Exception{
		 return  new AcademyDAOProxy();
		
	}
	public static IDepartmentDAO getIDepartmentDAOInstance() throws Exception{
		 return  new DepartmentDAOProxy();
		
	}
	public static IFamilyDAO getIFamilyDAOInstance() throws Exception{
		 return  new FamilyDAOProxy();
		
	}
	public static IAwardDAO getIAwardDAOInstance() throws Exception{
		 return  new AwardDAOProxy();
		
	}
	public static IPunishmentDAO getIPunishmentDAOInstance() throws Exception{
		 return  new PunishmentDAOProxy();
		
	}
	public static IUserDAO getIUserDAOInstance() throws Exception{
		
		 return  new UserDAOProxy();
		
	}
	public static IAdministratorDAO IAdministratorDAO() throws Exception{
		 return  new AdministratorDAOProxy();
		
	}
}
