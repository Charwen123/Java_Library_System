package 西二三轮;

import java.util.*;

public class test {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		menutest menu=new menutest();
		int num;
		do {
			menu.menu();
			System.out.println("返回主菜单请按0，其他任意数字键结束运行");
			num=sc.nextInt();
		}while(num==0);
	}
}
