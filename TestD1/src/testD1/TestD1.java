package testD1;
import java.util.Scanner;

public class TestD1
{
	public static int min(int a, int b)
	{
		return (a < b ? a : b); 
	}
	public static int Strcmp(String s1, String s2)
	{
		for (int i = 0; i < min(s1.length(), s2.length()); ++i)
		{
			if (s1.charAt(i) > s2.charAt(i))
				return 1;
			else if (s1.charAt(i) < s2.charAt(i))
				return -1;				
		}
		if (s1.length() > s2.length())
			return 1;
		else if (s1.length() < s2.length())
			return -1;
		else
			return 0;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s1, s2;
		System.out.println("请输入第一个字符串：");
		s1 = sc.next();
		System.out.println("请输入第二个字符串：");
		s2 = sc.next();
		sc.close();
		System.out.println("\nresult = " + Strcmp(s1, s2));
		return;
	}
}