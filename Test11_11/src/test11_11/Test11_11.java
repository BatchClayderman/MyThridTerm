package test11_11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Test11_11
{
	public static void swap(ArrayList<Integer> list, int i, int j)
	{
		Integer tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
        return;
	}
	
	public static int getIndex(ArrayList<Integer> list, int left, int right)
	{
		int i = left, j = right, base = list.get(right).intValue();
        while (i < j)
        {
            while (i < j && list.get(i).intValue() <= base)
                ++i;
            while (i < j && list.get(j).intValue() >= base)
                --j;
            swap(list, i, j);
        }
        swap(list, i, right);
        return i;
	}
	
	public static void sort(ArrayList<Integer> list)
	{
		Stack<Integer> stack = new Stack<>();
        stack.push(list.size() - 1);
        stack.push(0);

        while (!stack.isEmpty())
        {
        	int left = stack.pop().intValue(), right = stack.pop().intValue();
            if (left >= right)
                continue;

            int index = getIndex(list, left, right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
		return;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = "";
		ArrayList<Integer> list = new ArrayList<>();
		for (;;)
		{
			System.out.print("Enter 5 integers: ");
			str = sc.nextLine().replace("\t", " ");
			while (str.contains("  "))
				str = str.replace("  ", " ");
			if (str.startsWith(" "))
				str = str.substring(1);
			if (str.endsWith(" "))
				str = str.substring(0, str.length() - 1);
			String[] strings = str.split(" ");
			if (strings.length != 5)
				continue;
			boolean flag = true;
			for (String s : strings)
			{
				try
				{
					list.add(Integer.parseInt(s));
				}
				catch (Throwable e)
				{
					list.clear(); // Reset List
					flag = false; // Set flag
					break;
				}
			}
			if (flag)
				break;
		}
		sc.close();
		
		System.out.println(list);
		sort(list);
		System.out.println(list);
		
        return;
	}
}