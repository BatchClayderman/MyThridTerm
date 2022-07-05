package testB1;

import java.util.Scanner;
public class TestB1
{
	public static void main(String[] args)
	{
		int a, b;//输入
	    int c, d;//临时变量
	    System.out.print("请输入分子和分母（用空格隔开）：");
	    Scanner sc = new Scanner(System.in);
	    try
	    {
	    	a = sc.nextInt();
	    	b = sc.nextInt();
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e + "");//输入错误
	    	sc.close();
	    	return;
	    }
	    sc.close();
	    if (a >= b)
	    {
	    	System.out.println("Input Error!");//输入错误
	        return;
	    }
	    System.out.print(a + "/" + b + " = ");
	    while (1 != a && 0 != b % a )//循环体
	    {
	    	d = b / a;
	    	c = d + 1;
	    	System.out.print("1/" + c + " + ");
	    	a = a * c -b;
	    	b *= c;
	    }
	    System.out.println("1/" + (b/a));//最后一项不需要输出" + "
	    return;
	}
}