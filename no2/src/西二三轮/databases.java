package Î÷¶þÈýÂÖ;

import java.sql.*;

public class databases {
	public static Connection connectDB(){
		String url="jdbc:mysql://localhost:3306/book?serverTimezone=GMT";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","wu020605");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
