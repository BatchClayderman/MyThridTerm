package testB1;

import java.util.Scanner;
public class TestB1
{
	public static void main(String[] args)
	{
		int a, b;//����
	    int c, d;//��ʱ����
	    System.out.print("��������Ӻͷ�ĸ���ÿո��������");
	    Scanner sc = new Scanner(System.in);
	    try
	    {
	    	a = sc.nextInt();
	    	b = sc.nextInt();
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e + "");//�������
	    	sc.close();
	    	return;
	    }
	    sc.close();
	    if (a >= b)
	    {
	    	System.out.println("Input Error!");//�������
	        return;
	    }
	    System.out.print(a + "/" + b + " = ");
	    while (1 != a && 0 != b % a )//ѭ����
	    {
	    	d = b / a;
	    	c = d + 1;
	    	System.out.print("1/" + c + " + ");
	    	a = a * c -b;
	    	b *= c;
	    }
	    System.out.println("1/" + (b/a));//���һ���Ҫ���" + "
	    return;
	}
}