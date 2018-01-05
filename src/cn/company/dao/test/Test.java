package cn.company.dao.test;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javafx.scene.chart.PieChart.Data;
import cn.company.dao.IDormitoryDAO;
import cn.company.dao.impl.DepartmentDAO;
import cn.company.dao.proxy.DormitoryDAOProxy;
import cn.company.dao.proxy.UserDAOProxy;
import cn.company.factory.DAOFactory;
import cn.company.vo.Academy;
import cn.company.vo.Department;
import cn.company.vo.Dormitory;
import cn.company.vo.Family;
import cn.company.vo.Student;
import cn.company.vo.User;



public class Test {

	public static void main(String[] args) {
		
		User user =null;
		try {
			UserDAOProxy proxy=new UserDAOProxy();
			proxy.getUserByUser_id("00001");
			//user=DAOFactory.getIUserDAOInstance().getUserByUser_id("00001");
			System.out.println(user.getUser_password());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
