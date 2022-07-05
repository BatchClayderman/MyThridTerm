package testC3;
import java.util.Scanner;

public class TestC3
{
	public static void helixMatrix(int n)
	{
        int[][] arr = new int[n][n];
        int i = 0,j = 0;//�����±�
        int num = 1;//���������һ����ӡ������
        int steps = 0;//���ƴ�ӡȦ��
        int times = (n % 2) == 1 ? (n >> 1) + 1 : n >> 1;//��ӡ��Ȧ��
        for(int t = times ; t >= 0; --t)
        {
            while(j < n - steps)
            {
                arr[i][j] = num++;
                j++;
            }
            j--;//���һ��ѭ�����ж����� j++ �����һ�Σ�j--֮������������һ��
            i++;//����ڶ���
            while(i < n - steps)
            {
                arr[i][j] = num++;
                i++;
            }
            i--;//ͬ��
            j--;//j�ص������ڶ���
            while(j >= steps)
            {
                arr[i][j] = num++;
                j--;
            }
            j++;
            i--;//�������ڶ���
            //����ӡ��һȦ���� steps ���� 0 ʱ������ӡ�� steps + 1 = 2 �У���һȦ��ӡ��
            //����ӡ��һȦ���� steps ���� 1 ʱ������ӡ�� steps + 2 = 3 �У��ڶ�Ȧ��ӡ��
            while(i >= steps + 1)
            {
                arr[i][j] = num++;
                i--;
            }
            i++;
            j++;//�ڶ���
            steps++;//���ƴ�ӡȦ��

        }
        for (i = 0; i < n; ++i)
        {
        	for (j = 0; j < n; ++j)
        		System.out.print(arr[i][j] + "\t");//�� \t ��Ϊ�ָ������
        	System.out.print("\n");//�������
        }
        return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		for (;;)
		{
			try
			{
				System.out.print("���������ı���������������˳����򣩣�");
				n = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println(e + "");//�������
				continue;
			}
			if (n <= 0)
				break;
			helixMatrix(n);
			break;
		}
		System.out.println("\n\n������ϣ��������˳���");
		sc.close();
		return;
	}
}