package testE3;
import java.util.Scanner;

public class TestE3
{
	static int control = 0;//���ڿ���ÿ 10 ������һ��
	public static void Combine(int n, int m, int a[])//���
	{
		if (n < 1 || n > 9 || m > n)//�ų����󴫲�
			return;
		if (m == 1)//�ݹ����
		{
			
			for (int i = m; i <= n; ++i)
			{
				a[0] = i;
				//a[m - 1] = i;
				for (int j = 0; j < a.length; ++j)
					System.out.print(a[j]);
				control++;
				if (control % 10 == 0)
					System.out.println("");
				else
					System.out.print("\t");
			}
			return;
		}
		for (int i = m; i <= n; ++i)
		{
			a[m - 1] = i;
			Combine(i - 1, m - 1, a);
		}
		return;
	}
	public static void Permite(int n, int m, int a[])//����
	{
		if (n < 1 || n > 9 || m > n)//�ų����󴫲�
			return;
		if (m == 1)//�ݹ����
		{
			
			for (int i = m; i <= n; ++i)
			{
				a[0] = i;
				//a[m - 1] = i;
				for (int j = 0; j < a.length; ++j)
					System.out.print(a[j]);
				control++;
				if (control % 10 == 0)
					System.out.println("");
				else
					System.out.print("\t");
			}
			return;
		}
		for (int i = 1; i <= n; ++i)
		{
			a[m - 1] = i;
			Permite(n - 1, m - 1, a);
		}
		return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m, n;
		try 
		{
			System.out.print("������ n��");
			n = sc.nextInt();
			System.out.print("������ m��");
			m = sc.nextInt();
		}
		catch (Throwable e)
		{
			sc.close();
			System.out.println(e + "");
			return;
		}
		sc.close();
		if (n < 1 || n > 9 || m > n)//�ų���������
		{
			System.out.println("�������󣬽������˳���");
			return;
		}
		int[] a = new int[m];
		control = 0;
		System.out.println("\n��������");
		Combine(n, m, a);
		System.out.println("\n���� " + control + " ����ϡ�\n");
		control = 0;
		System.out.println("\n���������");
		Permite(n, m, a);
		System.out.println("\n���� " + control + " �����С�");
		return;
	}
}