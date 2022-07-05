package testB3;

import java.util.Scanner;
import java.lang.Math;

public class TestB3
{
	public static boolean isFind(int n)
	{
		boolean flag = false;
		for (int i = 1; i < Math.pow(n, 3); i += 2)// i ��ʾ����
			for (int j = 1; j < Math.pow(n, 3); ++j)// j ��ʾ����
				if (i * j + j * (j - 1) == Math.pow(n, 3))
				{
					System.out.print(n + "**3 = ");
					for (int k = i; k < i + (j << 1) - 2; k += 2)//���һ�������
						System.out.print(k + " + ");
					System.out.println((i + (j << 1) - 2) + "");//����
					flag = true;
				}
		if (flag)
			System.out.println("");//����
		return flag;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		for (;;)
		{
			try
			{
				System.out.print("���������֤�������������� 0 �˳����򣩣�");
				n = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println(e + "");//�������
				continue;
			}
			if (n == 0)
				break;
			else if (n < 0)
			{
				System.out.println("Input Error!\n");//�������
				continue;
			}
			if (!isFind(n))
				System.out.println("Error:" + n);
		}
		System.out.println("\n\n�������˳���");
		sc.close();
		return;
	}
}