package testE2;
import java.util.Scanner;

public class TestE2
{
	final static int maxLength = 10000;
	public static void WordCounter(String words)
	{
		String cut = " ";	// �ָ���˴�Ϊһ���ո�
		String[] newStr = words.split(cut);	// �ָ������
		int[] allLength = new int[maxLength];//���ֳ���
		for (int i = 0; i < newStr.length; ++i)
			if (newStr[i].length() < maxLength)
				allLength[newStr[i].length()]++;
		System.out.println("���ʳ���\t\t���ִ���");
		for (int i = 0; i < allLength.length; ++i)
			if (allLength[i] != 0)
				System.out.println((i + "\t") + ("\t" + allLength[i]));
		return;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String txt;
		System.out.print("�������ַ�����");
		txt = sc.nextLine();
		sc.close();
		WordCounter(txt);
		return;
	}
}