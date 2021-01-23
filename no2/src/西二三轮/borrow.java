package 西二三轮;

import java.sql.*;

public class borrow {
	static Connection con=databases.connectDB();
	static PreparedStatement pst;
	static ResultSet rs;
	
	//以下为借阅处理
	
	//修改借阅表信息
	public static void borrow(int no,String name,String sex,String book) {
		String str="insert into borrow(no,name,sex,book) values (?,?,?,?)";
		try {
			pst = con.prepareStatement(str);
			pst.setInt(1, no);
			pst.setString(2, name);
			pst.setString(3, sex);
			pst.setString(4, book);
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改图书列表中的借阅状态
	public static void borrowstate(int no) {
		String str="update book set state = ? where no = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, "已借阅");
			pst.setInt(2, no);
			pst.executeUpdate();
			con.close();
			System.out.println("成功借阅"+no+"号书籍");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//以下为归还处理
	
	//修改借阅表信息
	public static void Return(String name) {
		String str="delete from borrow where name = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改图书列表中的借阅状态
	public static void returnstate(int no) {
		String str="update book set state = ? where no = ?";
		try {
			pst = con.prepareStatement(str);
			pst.setString(1, "未借阅");
			pst.setInt(2, no);
			pst.executeUpdate();
			con.close();
			System.out.println("成功归还"+no+"号书籍");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
