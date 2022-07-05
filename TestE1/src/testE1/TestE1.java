package testE1;
import java.util.Scanner;

public class TestE1
{
	public static String D2R(int n, int b)
	{
		if (n < b)
		{
			if (n < 10)
				return String.valueOf(n);	
			else if (10 == n)
				return "A";
			else if (11 == n)
				return "B";
			else if (12 == n)
				return "C";
			else if (13 == n)
				return "D";
			else if (14 == n)
				return "E";
			else 
				return "F";	
		}
		else
		{
			if ((n % b)<10)
				return D2R(n / b, b).concat(String.valueOf(n % b));
			if ((n % b) == 10)
				return D2R(n / b, b).concat("A");
			else if ((n % b) == 11)
				return D2R(n / b, b).concat("B");
			else if ((n % b) == 12)
				return D2R(n / b, b).concat("C");
			else if ((n % b) == 13)
				return D2R(n / b, b).concat("D");
			else if ((n % b) == 14)
				return D2R(n / b, b).concat("E");
			else 
				return D2R(n / b, b).concat("F");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int r = 0, n = 0;
		do
		{
			System.out.print("请输入 n 的值：");
			try
			{
				n = sc.nextInt();
			}
			catch (Throwable e) {}
		} while (n <= 0);
		do
		{
			System.out.print("请输入要转换的进制（2-15）：");
			try
			{
				r = sc.nextInt();
			}
			catch (Throwable e) {}
		} while (r <= 1 || r > 16);
		sc.close();
		System.out.printf(n + " 的 " + r + " 进制为："+ D2R(n, r));
		return;
	}
}