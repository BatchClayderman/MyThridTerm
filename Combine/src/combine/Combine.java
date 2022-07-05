package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


/**
 *	组合
 * 	@author Batch Clayderman
 *
 *	试用一种或多种方法求解任一 Set 集合的任一元素数量的全部子集，可与第七章的输入输出相结合。
 */

class PAC//排列组合计算
{
	public static final String name = "排列组合计算";
	public static final int EOF = (-1);//错误
	public static int fact(int n)//求阶乘
	{
		if (n < 0)
			return EOF;
		try
		{
			if (n == 0 || n == 1)//归
				return 1;
			else//递
				return n * fact(n - 1);
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static long fact(long n)//求阶乘
	{
		if (n < 0)
			return EOF;
		try
		{
			if (n == 0 || n == 1)//归
				return 1;
			else//递
				return n * fact(n - 1);
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static int fact(int m, int n)//求乘
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		try
		{
			int result = 1;
			for (int i = m; i <= n; ++i)
				result *= i;
			return result;
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static long fact(long m, long n)//求乘
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		try
		{
			long result = 1;
			for (long i = m; i <= n; ++i)
				result *= i;
			return result;
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static int A(int n, int m)//排列
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		else
			return fact(n) / Math.abs(fact(n - m));// Math.abs() 用于确认返回 0 或 -1 时发生错误 
	}
	public static long A(long n, long m)//排列
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		else
			return fact(n) / Math.abs(fact(n - m));
	}
	public static int C(int n, int m)//组合
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		else
			return fact(n - m + 1, n) / Math.abs(fact(m));
	}
	public static long C(long n, long m)//组合
	{
		if (n < m || m <= 0 || n <= 0)//排除异常
			return EOF;
		else
			return fact(n - m + 1, n) / Math.abs(fact(m));
	}
}


class ComMethod
{
	public static final String name = "字符串数组的组合穷举法";
	private static ArrayList<Integer> tmpArr = new ArrayList<>();//方法三使用
	private static Stack<Integer> prStack = new Stack<Integer>();//方法四使用
	private static void _method_1(int n, int m, int a[], String s[])
	{
		if (m == 1)//递归结束
		{
			for (int i = m; i <= n; ++i)//据说 ++i 要比 i++ 快一点点
			{
				a[0] = i;
				//a[m - 1] = i;
				for (int j = 0; j < a.length; ++j)
					System.out.print(s[a[j] - 1] + "\t");
				System.out.println("");
			}
			return;
		}
		for (int i = m; i <= n; ++i)
		{
			a[m - 1] = i;
			_method_1(i - 1, m - 1, a, s);
		}
		return;
	}
	public static void method_1(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		int[] a = new int[m];//用于控制输出
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作
		_method_1(n, m, a, s);
		System.out.println("");//输出完毕追加一个空行
		return;
	}
	
	private static void _method_2(Stack<Integer> stack, String[] s)
	{
		if (stack == null)
			return;
		for (int i = 0; i < stack.size(); ++i)
		{
			System.out.print(s[stack.get(i) - 1]);
			if (i < stack.size() - 1)
				System.out.print("\t");
		}
		System.out.println("");
		return;
	}
	public static void method_2(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		while (!stack.empty())//栈非空
		{
			if (stack.size() == m)
			{
				_method_2(stack, s);
				int topVar = stack.peek();
				if (topVar + 1 <= n)
				{
					stack.pop();//出栈
					stack.push(topVar + 1);//压栈
				}
				else
				{
					stack.pop();
					if (stack.empty())
					{
						System.out.println("");
						return;
					}
					int sectopVar = stack.pop();
					stack.push(sectopVar + 1);
				}
			}
			else
			{
				int topVar = stack.peek();
				if (topVar + 1 <= n)
					stack.push(topVar + 1);
				else
				{
					stack.pop();
					if (stack.empty())
					{
						System.out.println("");
						return;
					}
					int sectopVar = stack.pop();
					stack.push(sectopVar + 1);
				}
			}
		}
	}
	
	private static void _method_3(int index, int k,	int[] arr, String[] s)
	{
		if (k == 1)
		{
			for (int i = index; i < arr.length; ++i)
			{
				tmpArr.add(arr[i]);
				tmpArr.forEach((j) -> System.out.print(s[j - 1] + "\t"));// lambda 表达式
				System.out.println("");
				tmpArr.remove((Object)arr[i]);
			}
		}
		else if (k > 1)
			for (int i = index; i <= arr.length - k; ++i)
			{
				tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
				_method_3(i + 1, k - 1, arr, s); //索引右移，内部循环，自然排除已经选择的元素
				tmpArr.remove((Object)arr[i]); // tmpArr 因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
			}
		return;// tmpArr 最终也为空
	}
	public static void method_3(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		int[] a = new int[n];//用于控制输出
		for (int i = 0; i < n; ++i)
			a[i] = i + 1;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作
		_method_3(0, m, a, s);
		System.out.println("");
		return;
	}
	
	private static void _method_4(int[] a, int targ, int has, int cur, String[] s)
	{
        if (has == targ)//归
        {
        	prStack.forEach((i)->System.out.print(s[i - 1] + "\t"));
        	System.out.println("");
            return;
        }
        for (int i = cur; i < a.length; ++i)
        {
            if (!prStack.contains(a[i]))
            {
                prStack.add(a[i]);
                _method_4(a, targ, has + 1, i, s);
                prStack.pop();//最终完成后 stack 为空
            }
        }
        return;
	}
	public static void method_4(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		int[] a = new int[n];//用于控制输出
		for (int i = 0; i < n; ++i)
			a[i] = i + 1;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作
		_method_4(a, m, 0, 0, s);
		System.out.println("");
		return;
	}
	
	private static void _method_5(
		String[] dataList, int dataIndex,
		String[] resultList, int resultIndex
	)
	{
		int resultLen = resultList.length, resultCount = resultIndex + 1;  
		if (resultCount > resultLen)//全部选择完时输出组合结果
		{
			Arrays.asList(resultList).forEach((i)->{// lambda 表达式
				if (i != null)//排除 null
				{
					System.out.print(i);
					System.out.print("\t");
				}
			});
			System.out.println("");//换行
		}
		else//否则递归选择下一个  
			for (int i = dataIndex; i < dataList.length + resultCount - resultLen; ++i) 
			{  
				resultList[resultIndex] = dataList[i];  
				_method_5(dataList, i + 1, resultList, resultIndex + 1);  
			}
		return;
	}  
	public static void method_5(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作
		_method_5(s, 0, new String[n], n - m);//记得是 n - m 而不是 m
		System.out.println("");
		return;
	}
	
	private static void _method_6(String[] s, int m, List<String> result) 
	{
		if (m == 0)// m == 0 则递归结束 
		{ 
			for (int i = 0; i < result.size(); ++i) 
				System.out.print(result.get(i) + "\t");
			System.out.println("");
			return;
		}
		if (s.length != 0) 
		{
			result.add(s[0] + ""); //选择当前元素
			String[] tmp = new String[s.length - 1];
			for (int i = 0; i < s.length - 1; ++i)//取出从 1 开始到 n 结束索引所对应的的字符串
				tmp[i] = s[i + 1];
			_method_6(tmp, m - 1, result); 
			result.remove(result.size() - 1);
			_method_6(tmp, m, result);//不选当前元素  
		}
		return;
	} 
	public static void method_6(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作 
		List<String> result = new ArrayList<String>();
		/*
		for (int i = 1; i <= n; ++i)//从 1 开始 
			_method_6(s, i, result);
		*/
		_method_6(s, m, result);
		System.out.println("");
		return;
	}
	
	private static void _method_7(String[] s, int begin, int number, Stack<String> stack)
	{
        if (number == 0)//归
        {
            stack.forEach((i)->System.out.print(i + "\t"));
            System.out.println("");
            return;
        }
        if (begin == s.length)
            return;
        stack.push(s[begin]);
        _method_7(s, begin + 1, number - 1, stack);
        stack.pop();
        _method_7(s, begin + 1, number, stack);
        return;
    }
	public static void method_7(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作 
		Stack<String> stack = new Stack<String>();
		/*
		for (int i = 1; i <= s.length; ++i)//所有组合
			_method_7(s, 0, i, stack);
		*/
		_method_7(s, 0, m, stack);
		System.out.println("");
		return;
	}
	
	private static void _method_8(
			int arr[], int data[],//双数组
			int start, int end,//起始和末尾
			int index, int r,
			String[] s
	)
	{
	    if (index == r)//归
	    {
	        for (int j = 0; j < r; ++j)
	            System.out.print(s[data[j] - 1] + "\t");
	        System.out.println("");
	        return;
	    }
	    for (int i = start; i <= end && end - i + 1 >= r - index; ++i)
	    {
	        data[index] = arr[i];
	        _method_8(arr, data, i + 1, end, index + 1, r, s);
	    }
	    return;
	}
	public static void method_8(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//排除错误传参
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//转成数组进行操作 
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = i + 1;
		int[] data = new int[m];
		int start = 0, end = n - 1, index = 0;
		_method_8(arr, data, start, end, index, m, s);
		System.out.println("");
		return;
	 }
}



public class Combine
{
	public static void main(String[] args)//测试参数为 args = [3, aaa, bbb, ccc, ddd, eee]
	{
		Set<String> hs = new HashSet<String>();
		int m = 0, n = 0;
		try//尝试解析命令行参数
		{
			n = args.length - 1;
			if (n > 0)
				m = Integer.parseInt(args[0]);
		}
		catch (Throwable e)
		{
			n = 0;
		}
		if (n < m || m <= 0 || n <= 0)//如果没有正确的命令行输入
		{
			Scanner sc = new Scanner(System.in);
			try 
			{
				System.out.print("请输入字符串数量 n：");
				n = sc.nextInt();
				System.out.print("请输入抽取元素数量 m：");
				m = sc.nextInt();
			}
			catch (Throwable e)//排除非法输入
			{
				sc.close();
				System.out.println("发生错误：" + e);
				return;
			}
			if (n < m || m <= 0 || n <= 0)//排除错误输入
			{
				sc.close();
				System.out.println("输入有误，进程已退出。");
				return;
			}
			sc.nextLine();//清除剩余的一个回车
			for (int i = 0; i < n; ++i)
			{
				System.out.print("请输入第 " + (i + 1) + " 个字符串：");
				String tmp = sc.nextLine();
				if (tmp.length() <= 0 || hs.contains(tmp))
				{
					--i;//回退
					continue;
				}
				hs.add(tmp);
			}
			sc.close();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//伪清屏
		}
		else
		{
			for (int i = 1; i <= n; ++i)
				hs.add(args[i]);
			n = hs.size();//重新计算最终的 n 值
			if (n < m || m <= 0 || n <= 0)//排除因重复造成 n 减少的
			{
				System.out.println("命令行参数有误，进程已退出。");
				return;
			}
		}
		
        System.out.println(hs + " with C(" + n + ", " + m + ") = " + PAC.C(n, m) + "\n\n");
        System.out.println("方法一：");
        ComMethod.method_1(hs, m);//使用 int[] 的递归法
        System.out.println("方法二：");
        ComMethod.method_2(hs, m);//使用 Stack 的循环法
        System.out.println("方法三：");
        ComMethod.method_3(hs, m);//使用 ArrayList 的递归法
        System.out.println("方法四：");
        ComMethod.method_4(hs, m);//使用 Stack 的递归法之一
        System.out.println("方法五：");
        ComMethod.method_5(hs, m);//使用 String[] 的递归法
        System.out.println("方法六：");
        ComMethod.method_6(hs, m);//使用 List 的递归法
        System.out.println("方法七：");
        ComMethod.method_7(hs, m);//使用 Stack 的递归法之二
        System.out.println("方法八：");
        ComMethod.method_8(hs, m);//使用 双数组 的递归法
        System.out.println("\n\n运行完毕，进程已退出。");
		return;
	}
}