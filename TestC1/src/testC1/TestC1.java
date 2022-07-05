package testC1;
import java.util.Scanner;

public class TestC1
{
	public static int[] printArr(int n, int[] Arr)
	{
		if (n < 0)//处理异常整数值 n
		{
			int [] newArr = new int[1];
			newArr[0] = 1;
			return newArr;
		}
        int[] newArr = new int[n + 1];
        newArr[0] = 1;//第一个数字是 1
        for (int i = 1; i < n; ++i)//最后一个不处理
        	newArr[i] = Arr[i - 1] + Arr[i];//中间部分前一列与当前列的和
        newArr[n] = 1;//最后一个数字是 1
        for (int i = 0; i < n; ++i)//打印
        	System.out.print(newArr[i] + "\t");
        System.out.println(newArr[n]);
        return newArr;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		for (;;)
		{
			try
			{
				System.out.print("请输入行数（输入非正数退出程序）：");
				n = sc.nextInt() - 1;
			}
			catch (Exception e)
			{
				System.out.println(e + "");//输入错误
				continue;
			}
			sc.close();
			if (n < 0)
				break;
			int[] Arr = new int[n];//开始就申请够足够大的空间
			Arr[0] = 1;//初始化数字 1
			for (int i = 0; i <= n; ++i)			
				Arr = printArr(i, Arr);
			break;
		}
		if (n >= 0)
			System.out.println("\n\n运行完毕，进程已退出。");
		else
			System.out.println("\n\n运行取消，进程已退出。");
		return;
	}
}