package testB2;

import java.lang.Math;
public class TestB2
{
	public static boolean isSati(int n)
	{
		if (n < 0)
			return false;
		String output = n + "";
		boolean flag = false;
		int a = 0, b = 0, c = 0;
		for (a = 0; a < ((int)Math.sqrt(n)) + 1; ++a)
			for (b = a; b < ((int)Math.sqrt(n)) + 1; ++b)
				for (c = b; c < ((int)Math.sqrt(n)) + 1; ++c)
					if (a * a + b * b + c * c == n)
					{
						output += (" = " + a + "^2 + " + b + "^2 + " + c + "^2");
						if (flag)
						{
							System.out.println(output);
							return true;
						}
						else
							flag = true;
					}
		return false;
	}
	public static void main(String[] args)
	{
		int count = 0, n = 0;
		while (count < 10)
		{
			n++;
			if (isSati(n))
				count++;
		}
	    return;
	}
}