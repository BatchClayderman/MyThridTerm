package vcode;
import java.util.Scanner;

public class Vcode
{
	final static int EXIT_SUCCESS = 0;
	final static int EXIT_FAILURE = 1;
	final static int EOF = (-1);
	final static String Alpha = "abcdefghijklmnopqrstuvwxyz";//Сд��ĸ
	final static String Num = "0123456789";//�����ַ�

	public static boolean isAlpha(char ch)//�Ƿ�Ϊ��ĸ
	{
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');//���� ASCII �ж�
	}

	public static boolean isDigital(char ch)//�Ƿ�Ϊ����
	{
		return ch <= '9' && ch >= '0';
	}

	public static int find(char ch, String s)//����ĳ���ַ����ַ����е�λ��
	{
		for (int i = 0; i < s.length(); ++i)
			if (ch == s.charAt(i))
				return i;
		return -1;//�Ҳ���
	}
	
	public static int mod(int a, int b)//ȡ��
	{
		while (a < b)
			a += b;
		return a % b;
	}
	
	
	public static String Vencode(String n1, String n2)//�����㷨
	{
		String r = "";
		String text1 = "";
		String text2 = "";
		
		/* ���ַ��� n1 ת��ΪȫСд�ַ��������˷���ĸ�ַ� */
		n1 = n1.toLowerCase();
		for (int i = 0; i < n1.length(); ++i)//���� n1
			if (isAlpha(n1.charAt(i)))//�ж��Ƿ�Ϊ��ĸ
				text1 += n1.charAt(i);//�������ĸ�ͼ��� text1 ��

		/* ���ַ��� n2 ���������ַ� */
		for (int i = 0; i < n2.length(); ++i)//���� n2
			if (isDigital(n2.charAt(i)))//�ж��Ƿ�Ϊ�����ַ�
				text2 += n2.charAt(i);//����������ַ��ͼ��� text2 ��
		
		/* �жϹ��������ַ��� text1��text2 �Ƿ�Ϊ�� */
		if (text1 == "" || text2 == "")
			return r;//Ϊ�շ��ؿմ�
		
		/* ����������� */
		System.out.println("\n�������ַ�����" + "\n" + text1 + "\n" + text2 + "\n" + "\n" + "��������������");
		for (int i = 0; i < Math.max(text1.length(), text2.length()); ++i)//ά�������㷨���Ĳ���
			r += Alpha.charAt(mod((find(text1.charAt(mod(i, text1.length())), Alpha) + find(text2.charAt(mod(i, text2.length())), Num)), 26));
		return r;
	}

	public static String Vdecode(String n1, String n2)//�����㷨
	{
		String r = "";
		String text1 = "";
		String text2 = "";

		/* ���ַ��� n1 ת��ΪȫСд�ַ��������˷���ĸ�ַ� */
		n1 = n1.toLowerCase();
		for (int i = 0; i < n1.length(); ++i)//���� n1
			if (isAlpha(n1.charAt(i)))//�ж��Ƿ�Ϊ��ĸ
				text1 += n1.charAt(i);//�������ĸ�ͼ��� text1 ��

		/* ���ַ��� n2 ���������ַ� */
		for (int i = 0; i < n2.length(); ++i)//���� n2
			if (isDigital(n2.charAt(i)))//�ж��Ƿ�Ϊ�����ַ�
				text2 += n2.charAt(i);//����������ַ��ͼ��� text2 ��

		/* �жϹ��������ַ��� text1��text2 �Ƿ�Ϊ�� */
		if (text1 == "" || text2 == "")
			return r;//Ϊ�շ��ؿմ�

		/* ����������� */
		System.out.println("\n�������ַ�����" + "\n" + text1 + "\n" + text2 + "\n" + "\n" + "��������������");
		for (int i = 0; i < Math.max(text1.length(), text2.length()); ++i)//ά�������㷨���Ĳ���
			r += Alpha.charAt(mod((find(text1.charAt(mod(i, text1.length())), Alpha) - find(text2.charAt(mod(i, text2.length())), Num)), 26));
		return r;
	}


	public static int help(String option)//�����а�������
	{
		System.out.println("");
		if (option != "/?" && option != "-?")
			System.out.println("������Ч�������в�������" + option + "����");
		System.out.println("������ά�������㷨���ܻ���ܡ�\n\n�����б�\n\t[Strings]\tӢ���ַ���\n\t[+/-]\t\t�����\n\t[Numbers]\t�����ַ���\n");
		System.out.println("�����и�ʽ��\n\tVcode.exe [Strings] [+/-] [Numbers]\n");
		System.out.println("ʾ����\n\tVcode.exe \"I love you for ever\" + 5203344\n\tVcode.exe jmpwfzpvgpsfwfs - 1\n");
		if (option != "/?" && option != "-?")
			return EXIT_SUCCESS;//��������
		else
			return EOF;//�Ƿ�����
	}

	public static void main(String[] args)
	{
		/* ��һ���ֿ��������Բ��ùܣ�ֻ��һ����ʹ���ߵ��������Ż� */
		int argc = args.length;
		for (int i = 0; i < argc; ++i)//�����÷�
		{
			if ("/?".equals(args[i]) || "-?".equals(args[i]))
			{
				//return(help("/?"));
				help("/?");
				return;
			}
		}
		if (argc == 3)//���������в���
		{
			if (args[1] == "+")
			{
				String result = Vencode(args[0], args[2]);//����
				if (result == "")
				{
					System.out.println("�������Ĳ�����ĸ����Կ�������֡�");
					//return EXIT_FAILURE;
					return;
				}
				System.out.println(result);//��ӡСд�汾
				System.out.println(result.toUpperCase());//��ӡ��д�汾
				System.out.println("");//�����Ż�����
			}
			else if (args[1] == "-")
			{
				String result = Vdecode(args[0], args[2]);//����
				if (result == "")
				{
					System.out.println("�������Ĳ�����ĸ����Կ�������֡�");
					//return EXIT_FAILURE;
					return;
				}
				System.out.println(result);//��ӡСд�汾
				System.out.println(result.toUpperCase());//��ӡ��д�汾
				System.out.println("");//�����Ż�����
			}
			else
			{
				//return(help(args[1]));//������Ŀ��ȷ���÷�����ȷ
				help(args[1]);
				return;
			}
			//return EXIT_SUCCESS;
			return;
		}
		else if (argc != 0)//���ǽ���ģʽ
			//return (help("������Ŀ����ȷ"));
			return;

		/* Ҫ�����Ĳ��� */
		Scanner sc = new Scanner(System.in);
		for (;;)//��������ѭ��
		{
			System.out.print("1 = ����\t2 = ����\t0 = �˳�����" + "\n" + "��ѡ��һ���Լ�����");
			String n1, n2, result;
			int c = 0;
			try
			{
				c = sc.nextInt();
			}
			catch (Throwable e)
			{
				continue;
			}
			sc.nextLine();//���˻س�
			switch (c)
			{
			case 1:
				System.out.print("���������ģ�");
				n1 = sc.nextLine();
				System.out.print("�����������ַ�����");
				n2 = sc.nextLine();
				result = Vencode(n1, n2);
				if (result == "")
					System.out.println("\n���Ĳ�����ĸ����Կ�������֣��밴��������ء�");
				else
					System.out.println(result + "\n" + result.toUpperCase() + "\n\n\n�밴�س������ء�");
				sc.nextLine();
				break;
			case 2:
				System.out.print("���������ģ�");
				n1 = sc.nextLine();
				System.out.print("�����������ַ�����");
				n2 = sc.nextLine();
				result = Vdecode(n1, n2);
				if (result == "")
					System.out.println("\n���Ĳ�����ĸ����Կ�������֣��밴�س������ء�");
				else
					System.out.println(result + "\n" + result.toUpperCase() + "\n\n\n�밴�س������ء�");
				sc.nextLine();
				break;
			case 0:
				System.out.println("\n\n\n\n\n\n\n\n\n��ӭ�ٴ�ʹ�ã��������˳���");
				return;
			default:
				break;
			}
			System.out.println("\n\n\n\n");
		}
	}
}