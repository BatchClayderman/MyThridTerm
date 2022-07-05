package testA2;

public class TestA2
{
	public static void main(String[] args)
	{
		boolean cc1, cc2, cc3;//cc1到cc3代表3位选手的逻辑判定
		int A = 0, B = 0, C = 0, D = 0;//代表四位选手
		boolean flag = false;
		while (A <= 4) 
		{
			A++;
			B = 0;
			while (B <= 4)
			{
				B++;
				if (B == A)
					B++;
				C = 0;
				while (C <= 4)
				{
					C++;
					if (C == A)
						C++;
					if (C == B)
						C++;
					D = 0;
					while (D <= 4)
					{
						D++;
						if (D == A)
							D++;
						if (D == B)
							D++;
						if (D == C)
							D++;
						cc1 = ((A == 1) && (!(B == 2))) || ((!(A == 1)) && (B == 2));
						cc2 = ((C == 1) && (!(D == 3))) || ((!(C == 1)) && (D == 3));
						cc3 = ((D == 2) && (!(A == 3))) || ((!(D == 2)) && (A == 3));
						if ((cc1 && cc2 && cc3)
								&& ((A < 5) && (B < 5) && (C < 5) && (D < 5))
								&& (A != B) && (A != C) && (A != D) && (B != C) && (B != D) && (C != D)
								)
						{
							flag = true;
							System.out.println("A = " + A);
							System.out.println("B = " + B);
							System.out.println("C = " + C);
							System.out.println("D = " + D);
						}
					}
				}
			} 
		}
		if (!flag)
			System.out.println("很抱歉，没有满足的结果！");
		return;
	}
}