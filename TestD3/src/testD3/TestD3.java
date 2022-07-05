package testD3;
import java.util.Scanner;

public class TestD3
{
	public static int Josephus(int n, int m)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)//创建猴子
			arr[i] = i + 1;
		int p = n;//现场还剩的猴子数量
		int q = -1;//指向的猴子索引号
		while (p > 1)
		{
			for (int kk = 0; kk < m; ++kk)//表示移动指针数
			{
				do
				{
					q++;
					q %= n;
				} while (arr[q] == 0);//找到下一只还在场上的猴子
			}
			arr[q] = 0;//猴子移出圈外置零
			p--;//场上的猴子数量减一
			//System.out.println("信息：第 " + (q + 1) + " 号猴子被移出圈外，场上还剩 " + p +" 只猴子。");
		}
		for (int i = 0; i < n; ++i)
			if (arr[i] != 0)
				return arr[i];
		return 0;
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
		if (n <= 0 || m <= 0)
		{
			System.out.println("输入有误，进程已退出。");
			return;
		}
		System.out.println("国王是第 " + Josephus(n, m) + " 号猴子，进程已退出。");
		return;
	}
}