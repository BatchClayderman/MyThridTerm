package jgcx;

import java.util.Scanner;
public class Class
{
	public static void jg_ditui(int n)//����ʵ��
	{
		int m = n;
		while (m != 1)
		{
			System.out.println(m);
			if (m % 2 == 0)//ż��
				m >>= 1;//m ���� 2
			else//����
				m = m * 3 + 1;
		}
		System.out.println(1);
		return;
	}
	public static void jg_digui(int n)//�ݹ�ʵ��
	{
		if (n == 1)//�ݹ��������
		{
			System.out.println(1);
			return;
		}
		else if (n % 2 == 0)//ż��
		{
			System.out.println(n);
			jg_digui(n >> 1);//���� 2 ��ݹ�
		}
		else
		{
			System.out.println(n);
			jg_digui(n * 3 + 1);
		}
		return;
	}
	public static void main(String[] args)
	{
		int n = 1;
		System.out.print("������������ n��");
		Scanner sc = new Scanner(System.in);
		try
		{
			n = sc.nextInt();
		}
		catch (Exception e)
		{
			sc.close();//�ر� Scanner
			System.out.println(e + "");
			return;
		}
		sc.close();//�ر� Scanner
		if (n <= 0)//����Ƿ�Ϊ������
		{
			System.out.println("����Ĳ������������������˳���");
			return;
		}
		System.out.println("����ʵ�֣�");
		try
		{
			jg_ditui(n);
		}
		catch (Exception e)
		{
			System.out.println(e + "");
		}
		System.out.println("\n�ݹ�ʵ�֣�");
		try
		{
			jg_digui(n);
		}
		catch (Exception e)
		{
			System.out.println(e + "");
		}
		return;
	}
}
