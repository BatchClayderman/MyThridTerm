package vcode;
import java.util.Scanner;

public class Vcode
{
	final static int EXIT_SUCCESS = 0;
	final static int EXIT_FAILURE = 1;
	final static int EOF = (-1);
	final static String Alpha = "abcdefghijklmnopqrstuvwxyz";//小写字母
	final static String Num = "0123456789";//数字字符

	public static boolean isAlpha(char ch)//是否为字母
	{
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');//利用 ASCII 判断
	}

	public static boolean isDigital(char ch)//是否为数字
	{
		return ch <= '9' && ch >= '0';
	}

	public static int find(char ch, String s)//查找某个字符在字符串中的位置
	{
		for (int i = 0; i < s.length(); ++i)
			if (ch == s.charAt(i))
				return i;
		return -1;//找不到
	}
	
	public static int mod(int a, int b)//取余
	{
		while (a < b)
			a += b;
		return a % b;
	}
	
	
	public static String Vencode(String n1, String n2)//加密算法
	{
		String r = "";
		String text1 = "";
		String text2 = "";
		
		/* 将字符串 n1 转换为全小写字符串并过滤非字母字符 */
		n1 = n1.toLowerCase();
		for (int i = 0; i < n1.length(); ++i)//遍历 n1
			if (isAlpha(n1.charAt(i)))//判断是否为字母
				text1 += n1.charAt(i);//如果是字母就加入 text1 中

		/* 将字符串 n2 过滤数字字符 */
		for (int i = 0; i < n2.length(); ++i)//遍历 n2
			if (isDigital(n2.charAt(i)))//判断是否为数字字符
				text2 += n2.charAt(i);//如果是数字字符就加入 text2 中
		
		/* 判断过滤所得字符串 text1、text2 是否为空 */
		if (text1 == "" || text2 == "")
			return r;//为空返回空串
		
		/* 计算结果并输出 */
		System.out.println("\n处理后的字符串：" + "\n" + text1 + "\n" + text2 + "\n" + "\n" + "处理后的运算结果：");
		for (int i = 0; i < Math.max(text1.length(), text2.length()); ++i)//维吉尼亚算法核心部分
			r += Alpha.charAt(mod((find(text1.charAt(mod(i, text1.length())), Alpha) + find(text2.charAt(mod(i, text2.length())), Num)), 26));
		return r;
	}

	public static String Vdecode(String n1, String n2)//解密算法
	{
		String r = "";
		String text1 = "";
		String text2 = "";

		/* 将字符串 n1 转换为全小写字符串并过滤非字母字符 */
		n1 = n1.toLowerCase();
		for (int i = 0; i < n1.length(); ++i)//遍历 n1
			if (isAlpha(n1.charAt(i)))//判断是否为字母
				text1 += n1.charAt(i);//如果是字母就加入 text1 中

		/* 将字符串 n2 过滤数字字符 */
		for (int i = 0; i < n2.length(); ++i)//遍历 n2
			if (isDigital(n2.charAt(i)))//判断是否为数字字符
				text2 += n2.charAt(i);//如果是数字字符就加入 text2 中

		/* 判断过滤所得字符串 text1、text2 是否为空 */
		if (text1 == "" || text2 == "")
			return r;//为空返回空串

		/* 计算结果并输出 */
		System.out.println("\n处理后的字符串：" + "\n" + text1 + "\n" + text2 + "\n" + "\n" + "处理后的运算结果：");
		for (int i = 0; i < Math.max(text1.length(), text2.length()); ++i)//维吉尼亚算法核心部分
			r += Alpha.charAt(mod((find(text1.charAt(mod(i, text1.length())), Alpha) - find(text2.charAt(mod(i, text2.length())), Num)), 26));
		return r;
	}


	public static int help(String option)//命令行帮助函数
	{
		System.out.println("");
		if (option != "/?" && option != "-?")
			System.out.println("错误：无效的命令行参数—“" + option + "”。");
		System.out.println("描述：维吉尼亚算法加密或解密。\n\n参数列表：\n\t[Strings]\t英文字符串\n\t[+/-]\t\t运算符\n\t[Numbers]\t数字字符串\n");
		System.out.println("命令行格式：\n\tVcode.exe [Strings] [+/-] [Numbers]\n");
		System.out.println("示例：\n\tVcode.exe \"I love you for ever\" + 5203344\n\tVcode.exe jmpwfzpvgpsfwfs - 1\n");
		if (option != "/?" && option != "-?")
			return EXIT_SUCCESS;//正常参数
		else
			return EOF;//非法参数
	}

	public static void main(String[] args)
	{
		/* 这一部分看不懂可以不用管，只是一个对使用者的命令行优化 */
		int argc = args.length;
		for (int i = 0; i < argc; ++i)//处理用法
		{
			if ("/?".equals(args[i]) || "-?".equals(args[i]))
			{
				//return(help("/?"));
				help("/?");
				return;
			}
		}
		if (argc == 3)//处理命令行参数
		{
			if (args[1] == "+")
			{
				String result = Vencode(args[0], args[2]);//加密
				if (result == "")
				{
					System.out.println("错误：明文不含字母或密钥不含数字。");
					//return EXIT_FAILURE;
					return;
				}
				System.out.println(result);//打印小写版本
				System.out.println(result.toUpperCase());//打印大写版本
				System.out.println("");//换行优化界面
			}
			else if (args[1] == "-")
			{
				String result = Vdecode(args[0], args[2]);//解密
				if (result == "")
				{
					System.out.println("错误：密文不含字母或密钥不含数字。");
					//return EXIT_FAILURE;
					return;
				}
				System.out.println(result);//打印小写版本
				System.out.println(result.toUpperCase());//打印大写版本
				System.out.println("");//换行优化界面
			}
			else
			{
				//return(help(args[1]));//参数数目正确但用法不正确
				help(args[1]);
				return;
			}
			//return EXIT_SUCCESS;
			return;
		}
		else if (argc != 0)//不是交互模式
			//return (help("参数数目不正确"));
			return;

		/* 要看懂的部分 */
		Scanner sc = new Scanner(System.in);
		for (;;)//无条件死循环
		{
			System.out.print("1 = 加密\t2 = 解密\t0 = 退出程序" + "\n" + "请选择一项以继续：");
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
			sc.nextLine();//过滤回车
			switch (c)
			{
			case 1:
				System.out.print("请输入明文：");
				n1 = sc.nextLine();
				System.out.print("请输入数字字符串：");
				n2 = sc.nextLine();
				result = Vencode(n1, n2);
				if (result == "")
					System.out.println("\n明文不含字母或密钥不含数字，请按任意键返回。");
				else
					System.out.println(result + "\n" + result.toUpperCase() + "\n\n\n请按回车键返回。");
				sc.nextLine();
				break;
			case 2:
				System.out.print("请输入密文：");
				n1 = sc.nextLine();
				System.out.print("请输入数字字符串：");
				n2 = sc.nextLine();
				result = Vdecode(n1, n2);
				if (result == "")
					System.out.println("\n密文不含字母或密钥不含数字，请按回车键返回。");
				else
					System.out.println(result + "\n" + result.toUpperCase() + "\n\n\n请按回车键返回。");
				sc.nextLine();
				break;
			case 0:
				System.out.println("\n\n\n\n\n\n\n\n\n欢迎再次使用，进程已退出。");
				return;
			default:
				break;
			}
			System.out.println("\n\n\n\n");
		}
	}
}