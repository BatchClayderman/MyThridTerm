package testF1;

class MyFunction
{
	static boolean prime(int n)
	{
		for (int i = 2; i <= (int)Math.sqrt(n); ++i)
			if (n % i == 0)
				return false;
		return true;
	}
	static int sumfactor(int n)
	{
		int sum = 0;
		for (int i = 1; i < n; ++i)
			if (n % i == 0)
				sum += i;
		return sum;
	}
}

public class TestF1
{
	public static void main(String[] args)
	{
		for (int i = 20; i <= 30; i += 2)
		{
			for (int j = 2; j <= i >> 1; ++j)
				if (MyFunction.prime(j) && MyFunction.prime(i - j))
					System.out.print(i + " = " + j + " + " + (i - j) + "\t");
			System.out.println("");//��һ������һ��
		}
		System.out.println("\n");//�Ż�����
		for (int i = 1; i <= 3000; ++i)
			if (MyFunction.sumfactor(i) > i)//�����ظ����
				continue;
			else if (MyFunction.sumfactor(MyFunction.sumfactor(i)) == i)
				System.out.println("(" + i + "," + MyFunction.sumfactor(i) + ")");
		return;
	}
}