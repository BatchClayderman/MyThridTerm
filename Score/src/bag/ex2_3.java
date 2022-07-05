package bag;

import java.util.Scanner;
public class ex2_3 {
	public static void main(String[] args) {
		String a = "123", b = "123";
		String c = new String("123");
		System.out.println(a == b ? "true" : "false");
		System.out.println(a == c ? "true" : "false");
		switch (a)
		{
		case "123":
			System.out.println("123");
			break;
		case "456":
			System.out.println("456");
			break;
		default:
			break;
		}
		switch (c)
		{
		case "123":
			System.out.println("123");
			break;
		case "456":
			System.out.println("456");
			break;
		default:
			break;
		}
		Scanner sc = new Scanner(System.in);
		int mark;
		try
		{
			mark = sc.nextInt();
			sc.close();
			System.out.println(mark >= 80 ? "Good" : (mark >= 60 ? "Pass" : "Fail"));
		}
		catch (Exception e)
		{
			sc.close();
			System.out.println(e + "");
		}
//输出成绩等级
	}
}