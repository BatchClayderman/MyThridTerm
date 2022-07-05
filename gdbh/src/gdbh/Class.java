package gdbh;

import java.util.Scanner;
public class Class
{
	public static boolean isPrime(int q)
	{
		if (q == 0 || q == 1)//0 和 1 既不是质数也不是合数
			return false;
		else if (q == 2)//2 是最小的质数
			return true;
		else
		{
			for (int i = 2; i <= (int)(Math.sqrt(q)); ++i)//减小时间复杂度
			{
				if (q % i == 0)//发现因子
				{
					return false;//终止遍历直接返回不是质数
				}
			}
		}
		return true;
	}
	public static void decompose(int os)
	{
		if (os < 4 || os % 2 != 0)
		{
			System.out.println("输入的不是大于 2 的偶数，程序退出。");
			return;
		}
		for (int i = 2; i <= (int)(os / 2); ++i)
		{
			if (isPrime(i) && isPrime(os - i))
			{
				System.out.println(os + " = " + i + " + " + (os - i));
				return;
			}
		}
		System.out.println("错误：找不到满足条件的两个质数。");
	}
	public static void main(String[] args)
	{
		int os;
		System.out.print("请输入一个大于 2 的偶数：");
		Scanner sc = new Scanner(System.in);
		try
		{
			os = sc.nextInt();//从读入的字符串中获取 int
		}
		catch (Exception e)
		{
			System.out.println(e + "");
			sc.close();//关闭 Scanner
			return;
		}
		sc.close();//关闭 Scanner
		decompose(os);
		return;
	}
}
