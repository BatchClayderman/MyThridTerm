package ch1;

public class Ch1 {
	public static void main(String[] args) {
		double S = 0, tmp = 1;
		for (int i = 1; i <= 100; ++i)
		{
			S += tmp / i;
			tmp = -tmp;
			//System.out.println("S = " + S);
		}
		System.out.println("S = " + S);
	}
}