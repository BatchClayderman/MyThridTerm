package jgcx;

import java.util.Scanner;
public class Class
{
	public static void jg_ditui(int n)//递推实现
	{
		int m = n;
		while (m != 1)
		{
			System.out.println(m);
			if (m % 2 == 0)//偶数
				m >>= 1;//m 除以 2
			else//奇数
				m = m * 3 + 1;
		}
		System.out.println(1);
		return;
	}
	public static void jg_digui(int n)//递归实现
	{
		if (n == 1)//递归结束条件
		{
			System.out.println(1);
			return;
		}
		else if (n % 2 == 0)//偶数
		{
			System.out.println(n);
			jg_digui(n >> 1);//除以 2 后递归
		}
		else
		{
			System.out.println(n);
			jg_digui(n * 3 + 1);
		}
		return;
	}
	public static void main(String[] args)
	{
		int n = 1;
		System.out.print("请输入正整数 n：");
		Scanner sc = new Scanner(System.in);
		try
		{
			n = sc.nextInt();
		}
		catch (Exception e)
		{
			sc.close();//关闭 Scanner
			System.out.println(e + "");
			return;
		}
		sc.close();//关闭 Scanner
		if (n <= 0)//检查是否为正整数
		{
			System.out.println("输入的不是正整数，程序已退出。");
			return;
		}
		System.out.println("递推实现：");
		try
		{
			jg_ditui(n);
		}
		catch (Exception e)
		{
			System.out.println(e + "");
		}
		System.out.println("\n递归实现：");
		try
		{
			jg_digui(n);
		}
		catch (Exception e)
		{
			System.out.println(e + "");
		}
		return;
	}
}
