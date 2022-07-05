package combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


/**
 *	���
 * 	@author Batch Clayderman
 *
 *	����һ�ֻ���ַ��������һ Set ���ϵ���һԪ��������ȫ���Ӽ�����������µ�����������ϡ�
 */

class PAC//������ϼ���
{
	public static final String name = "������ϼ���";
	public static final int EOF = (-1);//����
	public static int fact(int n)//��׳�
	{
		if (n < 0)
			return EOF;
		try
		{
			if (n == 0 || n == 1)//��
				return 1;
			else//��
				return n * fact(n - 1);
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static long fact(long n)//��׳�
	{
		if (n < 0)
			return EOF;
		try
		{
			if (n == 0 || n == 1)//��
				return 1;
			else//��
				return n * fact(n - 1);
		}
		catch (Throwable e)
		{
			return EOF;
		}
	}
	public static int fact(int m, int n)//���
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
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
	public static long fact(long m, long n)//���
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
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
	public static int A(int n, int m)//����
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
			return EOF;
		else
			return fact(n) / Math.abs(fact(n - m));// Math.abs() ����ȷ�Ϸ��� 0 �� -1 ʱ�������� 
	}
	public static long A(long n, long m)//����
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
			return EOF;
		else
			return fact(n) / Math.abs(fact(n - m));
	}
	public static int C(int n, int m)//���
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
			return EOF;
		else
			return fact(n - m + 1, n) / Math.abs(fact(m));
	}
	public static long C(long n, long m)//���
	{
		if (n < m || m <= 0 || n <= 0)//�ų��쳣
			return EOF;
		else
			return fact(n - m + 1, n) / Math.abs(fact(m));
	}
}


class ComMethod
{
	public static final String name = "�ַ�������������ٷ�";
	private static ArrayList<Integer> tmpArr = new ArrayList<>();//������ʹ��
	private static Stack<Integer> prStack = new Stack<Integer>();//������ʹ��
	private static void _method_1(int n, int m, int a[], String s[])
	{
		if (m == 1)//�ݹ����
		{
			for (int i = m; i <= n; ++i)//��˵ ++i Ҫ�� i++ ��һ���
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
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		int[] a = new int[m];//���ڿ������
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в���
		_method_1(n, m, a, s);
		System.out.println("");//������׷��һ������
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
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в���
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		while (!stack.empty())//ջ�ǿ�
		{
			if (stack.size() == m)
			{
				_method_2(stack, s);
				int topVar = stack.peek();
				if (topVar + 1 <= n)
				{
					stack.pop();//��ջ
					stack.push(topVar + 1);//ѹջ
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
				tmpArr.forEach((j) -> System.out.print(s[j - 1] + "\t"));// lambda ���ʽ
				System.out.println("");
				tmpArr.remove((Object)arr[i]);
			}
		}
		else if (k > 1)
			for (int i = index; i <= arr.length - k; ++i)
			{
				tmpArr.add(arr[i]); //tmpArr������ʱ�Դ洢һ��
				_method_3(i + 1, k - 1, arr, s); //�������ƣ��ڲ�ѭ������Ȼ�ų��Ѿ�ѡ���Ԫ��
				tmpArr.remove((Object)arr[i]); // tmpArr ��Ϊ����ʱ�洢�ģ���һ������ҳ���͸��ͷſռ䣬�洢��һ��Ԫ�ؼ���ƴ�������
			}
		return;// tmpArr ����ҲΪ��
	}
	public static void method_3(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		int[] a = new int[n];//���ڿ������
		for (int i = 0; i < n; ++i)
			a[i] = i + 1;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в���
		_method_3(0, m, a, s);
		System.out.println("");
		return;
	}
	
	private static void _method_4(int[] a, int targ, int has, int cur, String[] s)
	{
        if (has == targ)//��
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
                prStack.pop();//������ɺ� stack Ϊ��
            }
        }
        return;
	}
	public static void method_4(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		int[] a = new int[n];//���ڿ������
		for (int i = 0; i < n; ++i)
			a[i] = i + 1;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в���
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
		if (resultCount > resultLen)//ȫ��ѡ����ʱ�����Ͻ��
		{
			Arrays.asList(resultList).forEach((i)->{// lambda ���ʽ
				if (i != null)//�ų� null
				{
					System.out.print(i);
					System.out.print("\t");
				}
			});
			System.out.println("");//����
		}
		else//����ݹ�ѡ����һ��  
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
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в���
		_method_5(s, 0, new String[n], n - m);//�ǵ��� n - m ������ m
		System.out.println("");
		return;
	}
	
	private static void _method_6(String[] s, int m, List<String> result) 
	{
		if (m == 0)// m == 0 ��ݹ���� 
		{ 
			for (int i = 0; i < result.size(); ++i) 
				System.out.print(result.get(i) + "\t");
			System.out.println("");
			return;
		}
		if (s.length != 0) 
		{
			result.add(s[0] + ""); //ѡ��ǰԪ��
			String[] tmp = new String[s.length - 1];
			for (int i = 0; i < s.length - 1; ++i)//ȡ���� 1 ��ʼ�� n ������������Ӧ�ĵ��ַ���
				tmp[i] = s[i + 1];
			_method_6(tmp, m - 1, result); 
			result.remove(result.size() - 1);
			_method_6(tmp, m, result);//��ѡ��ǰԪ��  
		}
		return;
	} 
	public static void method_6(Set<String> set, int m)
	{
		int n = set.size();
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в��� 
		List<String> result = new ArrayList<String>();
		/*
		for (int i = 1; i <= n; ++i)//�� 1 ��ʼ 
			_method_6(s, i, result);
		*/
		_method_6(s, m, result);
		System.out.println("");
		return;
	}
	
	private static void _method_7(String[] s, int begin, int number, Stack<String> stack)
	{
        if (number == 0)//��
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
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в��� 
		Stack<String> stack = new Stack<String>();
		/*
		for (int i = 1; i <= s.length; ++i)//�������
			_method_7(s, 0, i, stack);
		*/
		_method_7(s, 0, m, stack);
		System.out.println("");
		return;
	}
	
	private static void _method_8(
			int arr[], int data[],//˫����
			int start, int end,//��ʼ��ĩβ
			int index, int r,
			String[] s
	)
	{
	    if (index == r)//��
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
		if (n < m || m <= 0 || n <= 0)//�ų����󴫲�
			return;
		String[] s = new String[set.size()];
		set.toArray(s);//ת��������в��� 
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
	public static void main(String[] args)//���Բ���Ϊ args = [3, aaa, bbb, ccc, ddd, eee]
	{
		Set<String> hs = new HashSet<String>();
		int m = 0, n = 0;
		try//���Խ��������в���
		{
			n = args.length - 1;
			if (n > 0)
				m = Integer.parseInt(args[0]);
		}
		catch (Throwable e)
		{
			n = 0;
		}
		if (n < m || m <= 0 || n <= 0)//���û����ȷ������������
		{
			Scanner sc = new Scanner(System.in);
			try 
			{
				System.out.print("�������ַ������� n��");
				n = sc.nextInt();
				System.out.print("�������ȡԪ������ m��");
				m = sc.nextInt();
			}
			catch (Throwable e)//�ų��Ƿ�����
			{
				sc.close();
				System.out.println("��������" + e);
				return;
			}
			if (n < m || m <= 0 || n <= 0)//�ų���������
			{
				sc.close();
				System.out.println("�������󣬽������˳���");
				return;
			}
			sc.nextLine();//���ʣ���һ���س�
			for (int i = 0; i < n; ++i)
			{
				System.out.print("������� " + (i + 1) + " ���ַ�����");
				String tmp = sc.nextLine();
				if (tmp.length() <= 0 || hs.contains(tmp))
				{
					--i;//����
					continue;
				}
				hs.add(tmp);
			}
			sc.close();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//α����
		}
		else
		{
			for (int i = 1; i <= n; ++i)
				hs.add(args[i]);
			n = hs.size();//���¼������յ� n ֵ
			if (n < m || m <= 0 || n <= 0)//�ų����ظ���� n ���ٵ�
			{
				System.out.println("�����в������󣬽������˳���");
				return;
			}
		}
		
        System.out.println(hs + " with C(" + n + ", " + m + ") = " + PAC.C(n, m) + "\n\n");
        System.out.println("����һ��");
        ComMethod.method_1(hs, m);//ʹ�� int[] �ĵݹ鷨
        System.out.println("��������");
        ComMethod.method_2(hs, m);//ʹ�� Stack ��ѭ����
        System.out.println("��������");
        ComMethod.method_3(hs, m);//ʹ�� ArrayList �ĵݹ鷨
        System.out.println("�����ģ�");
        ComMethod.method_4(hs, m);//ʹ�� Stack �ĵݹ鷨֮һ
        System.out.println("�����壺");
        ComMethod.method_5(hs, m);//ʹ�� String[] �ĵݹ鷨
        System.out.println("��������");
        ComMethod.method_6(hs, m);//ʹ�� List �ĵݹ鷨
        System.out.println("�����ߣ�");
        ComMethod.method_7(hs, m);//ʹ�� Stack �ĵݹ鷨֮��
        System.out.println("�����ˣ�");
        ComMethod.method_8(hs, m);//ʹ�� ˫���� �ĵݹ鷨
        System.out.println("\n\n������ϣ��������˳���");
		return;
	}
}