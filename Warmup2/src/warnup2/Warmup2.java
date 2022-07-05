package warnup2;

public class Warmup2
{
	public static void printLine(int i)
	{
		for (int j = 0; j < 10 - i; ++j)
			System.out.print("  ");
		for (int j = i; j > 0; --j)
			System.out.print(j + " ");
		System.out.print(0);
		for (int j = 1; j <= i; ++j)
			System.out.print(" " + j);
		System.out.println();
		return;
	}
	
	public static void printDiamond(int n)
	{
		if (0 <= n && n <= 9)
		{
			for (int i = 0; i < n; ++i)
				printLine(i);
			for (int i = n; i >= 0; --i)
				printLine(i);
		}
		return;
	}
	
	public static void main(String[] args)
	{
		printDiamond(9);
        return;
	}
}