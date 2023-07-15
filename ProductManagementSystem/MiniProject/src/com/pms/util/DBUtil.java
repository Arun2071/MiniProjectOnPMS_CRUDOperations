package com.pms.util;
import com.pms.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection() {
	Connection conn = null;
	try {
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mlr_207", "root", "mlritm1234");
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return conn;

}

	public static void  closeConncetion() {
		
		Connection conn =	getDBConnection();
		
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}