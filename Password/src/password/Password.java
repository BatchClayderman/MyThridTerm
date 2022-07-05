package password;

import java.util.Scanner;
public class Password {
	public static boolean isContainsCapitalLetter(String pass)//�Ƿ��д�д��ĸ
	{
		for (int i = 0; i < pass.length(); ++i)
		{
			if (pass.charAt(i) <= 'Z' && pass.charAt(i) >= 'A')
				return true;
		}
		return false;
	}
	public static boolean isContainsLowerLetter(String pass)//�Ƿ���Сд��ĸ
	{
		for (int i = 0; i < pass.length(); ++i)
		{
			if (pass.charAt(i) <= 'z' && pass.charAt(i) >= 'a')
				return true;
		}
		return false;
	}
	public static boolean isContainsNumber(String pass)//�Ƿ��������ַ�
	{
		for (int i = 0; i < pass.length(); ++i)
		{
			if (pass.charAt(i) <= '9' && pass.charAt(i) >= '0')
				return true;
		}
		return false;
	}
	public static boolean isContainsSpecialChar(String pass)//�Ƿ��������ַ�
	{
		return pass.replaceAll("\\p{P}", "").length() != pass.length();
	}

	public static boolean isStrong(String pass)
	{
		if (pass.length() < 8 || pass.length() > 16)
			return false;
		int tmp = 0;
		if (isContainsCapitalLetter(pass))
			tmp++;
		if (isContainsLowerLetter(pass))
			tmp++;
		if (isContainsNumber(pass))
			tmp++;
		if (isContainsSpecialChar(pass))
			tmp++;
		return tmp >= 3;
	}
	public static void main(String[] args) {
		String psd;
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("���������룺");
			psd = sc.next();
			sc.close();
		}
		catch (Exception e)
		{
			sc.close();
			System.out.println(e + "");
			return;
		}
		if (isStrong(psd))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}