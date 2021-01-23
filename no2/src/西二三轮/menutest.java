package 西二三轮;

import java.sql.*;
import java.util.*;

public class menutest {
	public void menu() throws Exception {
		Connection c=databases.connectDB();
		Scanner sc=new Scanner(System.in);
		if(!c.isClosed()) {
			System.out.println("欢迎进入简陋的图书管理系统！");
			System.out.println("1.图书目录\t2.增加图书\t3.删除图书\t4.搜索图书\t5.借阅信息\t6.借阅图书\t7.归还图书");
			int num=sc.nextInt();
			Statement stm1=c.createStatement();
			Statement stm2=c.createStatement();
			String sqlbook="select * from book";
			ResultSet rsbook =stm1.executeQuery(sqlbook);
			
			String sqlbor="select * from borrow";
			ResultSet rsbor =stm2.executeQuery(sqlbor);
			
			switch (num) {
				case 1:
					System.out.println("no\tname\tauthor\tstate");
					while(rsbook.next()) {
						System.out.print(rsbook.getInt("no"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("name"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("author"+""));
						System.out.print("\t");
						System.out.print(rsbook.getString("state"+""));
						System.out.println();
					}
					break;
				case 2:
					System.out.println("请依次输入编号，书名，作者，借阅情况");
					book.addbook(sc.nextInt(), sc.next(), sc.next(), sc.next());
					break;
				case 3:
					book.deletebook(sc.nextInt());
					break;
				case 4:
					System.out.println("请选择搜索方式:\t1.书名搜索\t2.作者搜索\t3.编号搜索");
					num=sc.nextInt();
					switch(num) {
						case 1:
							book.searchname(sc.next());
							break;
						case 2:
							book.searchauthor(sc.next());
							break;
						case 3:
							book.searchno(sc.nextInt());
							break;
					}
					break;
				case 5:
					System.out.println("no\tname\tsex\tbook");
					while(rsbor.next()) {
						System.out.print(rsbor.getInt("no"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("name"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("sex"+""));
						System.out.print("\t");
						System.out.print(rsbor.getString("book"+""));
						System.out.println();
					}
					break;
				case 6:
					System.out.println("请依次输入序号，姓名，性别，借阅图书");
					borrow.borrow(sc.nextInt(),sc.next(), sc.next(), sc.next());
					System.out.println("请输入借阅图书编号");
					borrow.borrowstate(sc.nextInt());
					break;
				case 7:
					System.out.println("请输入归还者姓名");
					borrow.Return(sc.next());
					System.out.println("请输入归还图书编号");
					borrow.returnstate(sc.nextInt());
					break;
				}
		}
	}
}
