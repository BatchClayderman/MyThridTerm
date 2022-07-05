package testC2;

import java.lang.Math;
public class TestC2
{
	public static boolean isSquare(int n)
	{
        return Math.sqrt(n) == (int)(Math.sqrt(n));
	}
	public static void main(String[] args)
	{
		for (int a = 1; a <= 9; ++a)
			for (int b = 0; b <= 9; ++b)
			{
				if (b == a)
					continue;
				for (int c = 0; c <= 9; ++c)
				{
					if (c == a || c == b)
						continue;
					int n = 100 * a + 10 * b + c;
					if (isSquare(n))
					{
						int m = (int)(Math.sqrt(n));
						System.out.println(n + " = " + m + " * " + m);
					}
				}
			}
		return;
	}
}