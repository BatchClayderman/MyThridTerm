package testD2;

public class TestD2
{
	public static boolean isCon(char a, String s)//是否含有某个字符
	{
		for (int i = 0; i < s.length(); ++i)
			if (a == s.charAt(i))
				return true;
		return false;
	}
	public static boolean isConEqu(int ordInt, int mulInt)//是否含有相同数字字符
	{
		if ((mulInt > 999999 || ordInt > 999999) || (mulInt < 100000 || ordInt < 100000))
			return false;
		 String s1 = ordInt + "", s2 = mulInt + "";
		 for (int i = 0; i < s1.length(); ++i)
			 if (!isCon(s1.charAt(i), s2))
				 return false;
		 return true;
	}
	public static boolean isSix(int six)//实现乘后的循环
	{
		for (int i = 2; i <= 6; ++i)
			if (!isConEqu(six, six * i))
				return false;
		return true;
	}
	public static void main(String[] args)//循环
	{
		for (int a = 1; a < 2; ++a)//不可能超过二十万
			for (int b = 0; b < 10; ++b)
			{
				if (b == a)
					continue;
				for (int c = 0; c < 10; ++c)
				{
					if (c == a || c == b)
						continue;
					for (int d = 0; d < 10; ++d)
					{
						if (d == a || d == b || d == c)
							continue;
						for (int e = 0; e < 10; ++e)
						{
							if (e == a || e == b || e == c || e == d)
								continue;
							for (int f = 0; f < 10; ++f)
							{
								if (f == a || f == b || f == c || f == d || f == e)
									continue;
								int myNum = a * 100000 + b * 10000 + c * 1000 + d * 100 + e * 10 + f;
								if (isSix(myNum))
									System.out.println(myNum);
							}
						}
					}
				}
			}
		//System.out.println("输出完毕，进程已退出。");
		return;
	}
}