package testC1;
import java.util.Scanner;

public class TestC1
{
	public static int[] printArr(int n, int[] Arr)
	{
		if (n < 0)//�����쳣����ֵ n
		{
			int [] newArr = new int[1];
			newArr[0] = 1;
			return newArr;
		}
        int[] newArr = new int[n + 1];
        newArr[0] = 1;//��һ�������� 1
        for (int i = 1; i < n; ++i)//���һ��������
        	newArr[i] = Arr[i - 1] + Arr[i];//�м䲿��ǰһ���뵱ǰ�еĺ�
        newArr[n] = 1;//���һ�������� 1
        for (int i = 0; i < n; ++i)//��ӡ
        	System.out.print(newArr[i] + "\t");
        System.out.println(newArr[n]);
        return newArr;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		for (;;)
		{
			try
			{
				System.out.print("����������������������˳����򣩣�");
				n = sc.nextInt() - 1;
			}
			catch (Exception e)
			{
				System.out.println(e + "");//�������
				continue;
			}
			sc.close();
			if (n < 0)
				break;
			int[] Arr = new int[n];//��ʼ�����빻�㹻��Ŀռ�
			Arr[0] = 1;//��ʼ������ 1
			for (int i = 0; i <= n; ++i)			
				Arr = printArr(i, Arr);
			break;
		}
		if (n >= 0)
			System.out.println("\n\n������ϣ��������˳���");
		else
			System.out.println("\n\n����ȡ�����������˳���");
		return;
	}
}