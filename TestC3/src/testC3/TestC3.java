package testC3;
import java.util.Scanner;

public class TestC3
{
	public static void helixMatrix(int n)
	{
        int[][] arr = new int[n][n];
        int i = 0,j = 0;//数组下标
        int num = 1;//螺旋矩阵第一个打印的数字
        int steps = 0;//控制打印圈数
        int times = (n % 2) == 1 ? (n >> 1) + 1 : n >> 1;//打印的圈数
        for(int t = times ; t >= 0; --t)
        {
            while(j < n - steps)
            {
                arr[i][j] = num++;
                j++;
            }
            j--;//最后一次循环的判断条件 j++ 多加了一次，j--之后是数组的最后一列
            i++;//处理第二行
            while(i < n - steps)
            {
                arr[i][j] = num++;
                i++;
            }
            i--;//同上
            j--;//j回到倒数第二列
            while(j >= steps)
            {
                arr[i][j] = num++;
                j--;
            }
            j++;
            i--;//处理倒数第二行
            //当打印第一圈，即 steps 等于 0 时，左侧打印到 steps + 1 = 2 行（第一圈打印）
            //当打印第一圈，即 steps 等于 1 时，左侧打印到 steps + 2 = 3 行（第二圈打印）
            while(i >= steps + 1)
            {
                arr[i][j] = num++;
                i--;
            }
            i++;
            j++;//第二列
            steps++;//控制打印圈数

        }
        for (i = 0; i < n; ++i)
        {
        	for (j = 0; j < n; ++j)
        		System.out.print(arr[i][j] + "\t");//以 \t 作为分隔符输出
        	System.out.print("\n");//换行输出
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
				System.out.print("请输入矩阵的边数（输入非正数退出程序）：");
				n = sc.nextInt();
			}
			catch (Exception e)
			{
				System.out.println(e + "");//输入错误
				continue;
			}
			if (n <= 0)
				break;
			helixMatrix(n);
			break;
		}
		System.out.println("\n\n运行完毕，进程已退出。");
		sc.close();
		return;
	}
}