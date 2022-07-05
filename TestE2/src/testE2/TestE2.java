package testE2;
import java.util.Scanner;

public class TestE2
{
	final static int maxLength = 10000;
	public static void WordCounter(String words)
	{
		String cut = " ";	// 分割串，此处为一个空格
		String[] newStr = words.split(cut);	// 分割成数组
		int[] allLength = new int[maxLength];//各种长度
		for (int i = 0; i < newStr.length; ++i)
			if (newStr[i].length() < maxLength)
				allLength[newStr[i].length()]++;
		System.out.println("单词长度\t\t出现次数");
		for (int i = 0; i < allLength.length; ++i)
			if (allLength[i] != 0)
				System.out.println((i + "\t") + ("\t" + allLength[i]));
		return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String txt;
		System.out.print("请输入字符串：");
		txt = sc.nextLine();
		sc.close();
		WordCounter(txt);
		return;
	}
}