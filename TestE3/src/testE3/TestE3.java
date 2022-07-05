package testE3;
import java.util.Scanner;

public class TestE3
{
	static int control = 0;//用于控制每 10 个数空一行
	public static void Combine(int n, int m, int a[])//组合
	{
		if (n < 1 || n > 9 || m > n)//排除错误传参
			return;
		if (m == 1)//递归结束
		{
			
			for (int i = m; i <= n; ++i)
			{
				a[0] = i;
				//a[m - 1] = i;
				for (int j = 0; j < a.length; ++j)
					System.out.print(a[j]);
				control++;
				if (control % 10 == 0)
					System.out.println("");
				else
					System.out.print("\t");
			}
			return;
		}
		for (int i = m; i <= n; ++i)
		{
			a[m - 1] = i;
			Combine(i - 1, m - 1, a);
		}
		return;
	}
	public static void Permite(int n, int m, int a[])//排列
	{
		if (n < 1 || n > 9 || m > n)//排除错误传参
			return;
		if (m == 1)//递归结束
		{
			
			for (int i = m; i <= n; ++i)
			{
				a[0] = i;
				//a[m - 1] = i;
				for (int j = 0; j < a.length; ++j)
					System.out.print(a[j]);
				control++;
				if (control % 10 == 0)
					System.out.println("");
				else
					System.out.print("\t");
			}
			return;
		}
		for (int i = 1; i <= n; ++i)
		{
			a[m - 1] = i;
			Permite(n - 1, m - 1, a);
		}
		return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m, n;
		try 
		{
			System.out.print("请输入 n：");
			n = sc.nextInt();
			System.out.print("请输入 m：");
			m = sc.nextInt();
		}
		catch (Throwable e)
		{
			sc.close();
			System.out.println(e + "");
			return;
		}
		sc.close();
		if (n < 1 || n > 9 || m > n)//排除错误输入
		{
			System.out.println("输入有误，进程已退出。");
			return;
		}
		int[] a = new int[m];
		control = 0;
		System.out.println("\n组合输出：");
		Combine(n, m, a);
		System.out.println("\n共有 " + control + " 种组合。\n");
		control = 0;
		System.out.println("\n排列输出：");
		Permite(n, m, a);
		System.out.println("\n共有 " + control + " 种排列。");
		return;
	}
}