package test11_13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test11_13
{
	public static void removeDuplicate(ArrayList<Integer> list)
	{
		HashSet<Integer> set = new HashSet<>(); // to make it faster
		ArrayList<Integer> toRemove = new ArrayList<>();
		for (int i = 0; i < list.size(); ++i)
			if (set.contains(list.get(i)))
				toRemove.add(i); // store the index
			else
				set.add(list.get(i));
		//System.out.println(toRemove);
		for (int i = toRemove.size() - 1; i >= 0; --i)
			list.remove(toRemove.get(i).intValue());
		return;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = "";
		ArrayList<Integer> list = new ArrayList<>();
		for (;;)
		{
			System.out.print("Enter 10 integers: ");
			str = sc.nextLine().replace("\t", " ");
			while (str.contains("  "))
				str = str.replace("  ", " ");
			if (str.startsWith(" "))
				str = str.substring(1);
			if (str.endsWith(" "))
				str = str.substring(0, str.length() - 1);
			String[] strings = str.split(" ");
			if (strings.length != 10)
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
		
		//System.out.println(list);
		removeDuplicate(list);
		System.out.print("The distinct integers are");
		for (Integer item : list)
			System.out.print(" " + item);
		System.out.println();
		
        return;
	}
}