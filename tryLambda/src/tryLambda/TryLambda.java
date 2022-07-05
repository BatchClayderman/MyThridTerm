package tryLambda;

interface MathOperation
{
	int operation(int a, int b);
}

public class TryLambda
{
	public static void main(String[] args)
	{
		MathOperation addition = (int a, int b) -> a + b;
		System.out.println(addition.operation(5, 6));
	}
}