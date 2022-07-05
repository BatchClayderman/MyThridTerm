package gcd;

import java.util.Scanner;
public class Class
{
	public static int GCD1(int a, int b)//爆破（直接扫描）
	{
		int tmp = 1, minNum = (a < b ? b : a);//计算二者中的最小值
		for (int i = 1; i <= minNum; ++i)//从 1 到 min(a, b)
			if (a % i == 0 && b % i == 0)//两个数都可以除尽 i
				tmp = i;
		return tmp;
	}
	public static int GCD2(int a, int b)//辗转相除法（递推实现）
	{ 
		int k = 0; 
		do 
		{
			k = a % b;//得到余数
			a = b;//根据辗转相除法把被除数赋给除数 
			b = k;//余数赋给被除数 
		} while (k != 0);
		return a;//返回被除数 
	} 
	public static int GCD3(int a,int b)//辗转相除法（递归实现） 
	{ 
		if (b == 0)//满足此条件时退出递归 
			return a; 
		if (a < 0)
			return GCD3(-a, b);
		if (b < 0)
			return GCD3(a, -b);
		return GCD3(b, a % b); 
	}
	public static void main(String[] args)
	{
		int m = 0, n = 0;
		System.out.println("请输入正整数 m 和 n（用空格或回车隔开）：");
		Scanner sc = new Scanner(System.in);
		try
		{
			m = sc.nextInt();//从读入的字符串中获取 int
			n = sc.nextInt();
		}
		catch (Exception e)
		{
			sc.close();//关闭 Scanner
			System.out.println(e + "");
			return;
		}
		sc.close();//关闭 Scanner
		if (m <= 0 || n <= 0)//检查是否为整数
		{
			System.out.println("\n输入的不是正整数，程序已退出。");
			return;
		}
		System.out.println("\n直接扫描得二者的最大公因数为 " + GCD1(m, n) + "。");
		System.out.println("利用递推法辗转相除得二者的最大公因数为 " + GCD2(m, n) + "。");
		System.out.println("利用递归法辗转相除得二者的最大公因数为 " + GCD3(m, n) + "。");
		return;
	}
}
