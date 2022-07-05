package gcd;

import java.util.Scanner;
public class Class
{
	public static int GCD1(int a, int b)//���ƣ�ֱ��ɨ�裩
	{
		int tmp = 1, minNum = (a < b ? b : a);//��������е���Сֵ
		for (int i = 1; i <= minNum; ++i)//�� 1 �� min(a, b)
			if (a % i == 0 && b % i == 0)//�����������Գ��� i
				tmp = i;
		return tmp;
	}
	public static int GCD2(int a, int b)//շת�����������ʵ�֣�
	{ 
		int k = 0; 
		do 
		{
			k = a % b;//�õ�����
			a = b;//����շת������ѱ������������� 
			b = k;//�������������� 
		} while (k != 0);
		return a;//���ر����� 
	} 
	public static int GCD3(int a,int b)//շת��������ݹ�ʵ�֣� 
	{ 
		if (b == 0)//���������ʱ�˳��ݹ� 
			return a; 
		if (a < 0)
			return GCD3(-a, b);
		if (b < 0)
			return GCD3(a, -b);
		return GCD3(b, a % b); 
	}
	public static void main(String[] args)
	{
		int m = 0, n = 0;
		System.out.println("������������ m �� n���ÿո��س���������");
		Scanner sc = new Scanner(System.in);
		try
		{
			m = sc.nextInt();//�Ӷ�����ַ����л�ȡ int
			n = sc.nextInt();
		}
		catch (Exception e)
		{
			sc.close();//�ر� Scanner
			System.out.println(e + "");
			return;
		}
		sc.close();//�ر� Scanner
		if (m <= 0 || n <= 0)//����Ƿ�Ϊ����
		{
			System.out.println("\n����Ĳ������������������˳���");
			return;
		}
		System.out.println("\nֱ��ɨ��ö��ߵ��������Ϊ " + GCD1(m, n) + "��");
		System.out.println("���õ��Ʒ�շת����ö��ߵ��������Ϊ " + GCD2(m, n) + "��");
		System.out.println("���õݹ鷨շת����ö��ߵ��������Ϊ " + GCD3(m, n) + "��");
		return;
	}
}
