package testA3;

import java.util.Scanner;
public class TestA3
{
	public static String fun(int num, int n)// n ��ʾĿ�����, num Ҫת����ֵ
	{
		String str = "";
	    int yushu, shang = num;//������������
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
			System.out.print("��������Ȼ�� n��0-1000����");
			n = sc.nextInt();
			if (n < 0 || n > 1000)
			{
				sc.close();
				throw new Exception("��Χ����");
			}
			System.out.print("��������Ȼ�� r��1-16����");
			r = sc.nextInt();
			if (r < 1 || r > 16)
			{
				sc.close();
				throw new Exception("��Χ����");
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