package cn.company.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=本科生信息管理";
	private static final String USER="sa";
	private static final String PASSWORD="951115";
	private Connection conn=null;
	public DatabaseConnection() throws Exception{
		try {
			Class.forName(DRIVER);
			this.conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
