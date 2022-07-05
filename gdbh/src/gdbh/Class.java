package gdbh;

import java.util.Scanner;
public class Class
{
	public static boolean isPrime(int q)
	{
		if (q == 0 || q == 1)//0 �� 1 �Ȳ�������Ҳ���Ǻ���
			return false;
		else if (q == 2)//2 ����С������
			return true;
		else
		{
			for (int i = 2; i <= (int)(Math.sqrt(q)); ++i)//��Сʱ�临�Ӷ�
			{
				if (q % i == 0)//��������
				{
					return false;//��ֹ����ֱ�ӷ��ز�������
				}
			}
		}
		return true;
	}
	public static void decompose(int os)
	{
		if (os < 4 || os % 2 != 0)
		{
			System.out.println("����Ĳ��Ǵ��� 2 ��ż���������˳���");
			return;
		}
		for (int i = 2; i <= (int)(os / 2); ++i)
		{
			if (isPrime(i) && isPrime(os - i))
			{
				System.out.println(os + " = " + i + " + " + (os - i));
				return;
			}
		}
		System.out.println("�����Ҳ�����������������������");
	}
	public static void main(String[] args)
	{
		int os;
		System.out.print("������һ������ 2 ��ż����");
		Scanner sc = new Scanner(System.in);
		try
		{
			os = sc.nextInt();//�Ӷ�����ַ����л�ȡ int
		}
		catch (Exception e)
		{
			System.out.println(e + "");
			sc.close();//�ر� Scanner
			return;
		}
		sc.close();//�ر� Scanner
		decompose(os);
		return;
	}
}
