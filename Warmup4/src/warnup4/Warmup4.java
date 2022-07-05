package warnup4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Warmup4
{
	public static void printArray(Object object, boolean root)
	{
		if (null == object)
			System.out.print("null");
		else if (object.getClass().isArray())
		{
			int length = Array.getLength(object);	
			if (length <= 0) // Empty array
				System.out.println("[]");
			else
			{
				System.out.print("[");
				printArray(Array.get(object, 0), false);
				for (int i = 1; i < length; ++i)
				{
					System.out.print(", ");
					printArray(Array.get(object, i), false);
				}
				System.out.print("]");
			}
		}
		else
			System.out.print(object);
		if (root)
			System.out.println();
		return;
	}
	
	public static void printArray(Object object)
	{
		printArray(object, true);
		return;
	}
	
	public static int getN(Scanner sc)
	{
		System.out.print("Enter the number of rows in the matrix: ");
		for (;;)
		{
			try
			{
				int n = Integer.parseInt(sc.nextLine());
				if (n > 0)
					return n;
				else
					System.out.print("Something went wrong, please enter the number again: ");
			}
			catch (Throwable e)
			{
				System.out.print("Something went wrong, please enter the number again: ");
			}
		}
	}
	
	public static int[][] getMatrix(Scanner sc, int n)
	{
		int[][] matrix = new int[n][n];
		System.out.println("Enter the matrix row by row: ");
		for (int i = 0; i < n; ++i)
		{
			System.out.print("Row " + i + ": ");
			String[] line = sc.nextLine().split(" ");
			if (n == line.length)
			{
				boolean errorControll = true;
				for (int j = 0; j < n && errorControll; ++j)
					switch(line[j])
					{
					case "1":
						matrix[i][j] = 1;
						break;
					case "0":
						matrix[i][j] = 0;
						break;
					default:
						errorControll = false;
						--i;
						System.out.println("Something went wrong, please enter the line again. ");
					}
			}
			else
			{
				--i;
				System.out.println("Something went wrong, please enter the line again. ");
			}
		}
		return matrix;
	}
	
	public static int min(int a, int b)
	{
		return a < b ? a : b;
	}
	
	public static int getBlock(int[][] a, int i, int j)
	{
		int cnt = min(a.length - i, a.length - j);
		for (int k = 0; k < cnt; ++k) // Control the judging size of the sub matrix
			for (int m = 0; m <= k; ++m) // judge
				if (0 == a[i + k][j + m] || 0 == a[i + m][j + k])
					return k;
		return cnt;
	}
	
	public static int[][] getBlocks(int[][] a)
	{
		int[][] s = new int[a.length][a.length];
		for (int i = 0; i < a.length; ++i)
			for (int j = 0; j < a.length; ++j)
				s[i][j] = getBlock(a, i, j);
		return s;
	}
	
	public static int findLargestValue(int[][] s)
	{
		int value = 0;
		for (int i = 0; i < s.length; ++i)
			for (int j = 0; j < s.length; ++j)
				if (s[i][j] > value)
					value = s[i][j]; // find the largest value
		return value;
	}
	
	public static ArrayList<ArrayList<Integer>> findLargestBlocks(int[][] s, int value)
	{
		ArrayList<ArrayList<Integer>> array = new ArrayList<>();
		for (int i = 0; i < s.length; ++i)
			for (int j = 0; j < s.length; ++j)
				if (value == s[i][j])
				{
					ArrayList<Integer> subArray = new ArrayList<>();
					subArray.add(i);
					subArray.add(j);
					array.add(subArray);
				}
		return array;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = getN(sc);
		int a[][] = getMatrix(sc, n);
		int s[][] = getBlocks(a);
		int value = findLargestValue(s);
		ArrayList<ArrayList<Integer>> array = findLargestBlocks(s, value);
		
		System.out.println("\na[][]: ");
		for (int i = 0; i < n; ++i)
			printArray(a[i]);
		System.out.println("\ns[][]: ");
		for (int i = 0; i < n; ++i)
			printArray(s[i]);
		System.out.println("\nThe maximum square sub "
			+ (array.size() > 1 ? "matrixes are" : "matrix is")
			+ " at the "
			+ array.size()
			+ (array.size() > 1 ? " locations" : " location")
			+ " with size "
			+ value
			+ " shown as follows. "
		);
		System.out.println(array);
		sc.close();
        return;
	}
}