package testD3;
import java.util.Scanner;

public class TestD3
{
	public static int Josephus(int n, int m)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)//��������
			arr[i] = i + 1;
		int p = n;//�ֳ���ʣ�ĺ�������
		int q = -1;//ָ��ĺ���������
		while (p > 1)
		{
			for (int kk = 0; kk < m; ++kk)//��ʾ�ƶ�ָ����
			{
				do
				{
					q++;
					q %= n;
				} while (arr[q] == 0);//�ҵ���һֻ���ڳ��ϵĺ���
			}
			arr[q] = 0;//�����Ƴ�Ȧ������
			p--;//���ϵĺ���������һ
			//System.out.println("��Ϣ���� " + (q + 1) + " �ź��ӱ��Ƴ�Ȧ�⣬���ϻ�ʣ " + p +" ֻ���ӡ�");
		}
		for (int i = 0; i < n; ++i)
			if (arr[i] != 0)
				return arr[i];
		return 0;
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
		if (n <= 0 || m <= 0)
		{
			System.out.println("�������󣬽������˳���");
			return;
		}
		System.out.println("�����ǵ� " + Josephus(n, m) + " �ź��ӣ��������˳���");
		return;
	}
}