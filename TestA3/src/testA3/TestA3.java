package testA3;

import java.util.Scanner;
public class TestA3
{
	public static String fun(int num, int n)// n 表示目标进制, num 要转换的值
	{
		String str = "";
	    int yushu, shang = num;//保存余数和商
	    while (shang > 0)
	    {
	    	yushu = shang % n;
	      	shang /= n;
	    	if (yushu > 9)
	    		str = (char)('A'+(yushu-10)) + str;// 10-15 -> a-f
	    	else
	    		str = yushu + str;
	    }
	    return str;
	}
	public static void main(String[] args)
	{
		int n, r;
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("请输入自然数 n（0-1000）：");
			n = sc.nextInt();
			if (n < 0 || n > 1000)
			{
				sc.close();
				throw new Exception("范围有误");
			}
			System.out.print("请输入自然数 r（1-16）：");
			r = sc.nextInt();
			if (r < 1 || r > 16)
			{
				sc.close();
				throw new Exception("范围有误");
			}
			sc.close();
		}
		catch (Exception e)
		{
			sc.close();
			System.out.println("Input Error!");
			return;
		}
		System.out.println(fun(n, r));
		return;
	}
}