package warnup3;

public class Warmup3
{
	public static String diamond(int n, char[] colors)
	{
		if (n < 1 || colors.length < 3) // Unexpected length
			return "";
		
		StringBuffer sb = new StringBuffer(); // to make it faster
		
		/* Print the first line to the middle line (excluded) */
		for (int i = 0; i < n - 1; ++i)
		{
			char[] line = new char[(n << 1) - 1];
			for (int j = 0; j < n - 1 + i; ++j)
				line[j] = colors[1]; // fill background
			for (int j = n - 1 + i; j < (n << 1) - 1; ++j)
				line[j] = colors[2];
			line[n - 1] = colors[0];
			line[n - 1 - i] = colors[0];
			line[n - 1 + i] = colors[0];
			sb.append(line);
			sb.append("\n");
		}
		
		/* Print the middle line */
		for (int i = 0; i < (n << 1) - 1; ++i)
			sb.append(colors[0]);
		sb.append("\n");
			
		/* Print the middle line (excluded) to the last line (excluded) */
		for (int i = n - 1; i > 1; --i)
		{
			char[] line = new char[(n << 1) - 1];
			for (int j = 0; j < n; ++j)
				line[j] = colors[1]; // fill background
			for (int j = n; j < (n << 1) - 1; ++j)
				line[j] = colors[2];
			for (int j = 1; j < i; ++j)
			{
				line[n - 1 - j] = colors[0];
				line[n - 1 + j] = colors[0];
			}
			sb.append(line);
			sb.append("\n");
		}
		
		/* Print the last line */
		for (int i = 0; i < n - 1; ++i)
			sb.append(colors[1]);
		sb.append(colors[0]);
		for (int i = n; i < (n << 1) - 1; ++i)
			sb.append(colors[2]);
		sb.append("\n\n"); // make it more beautiful
		
		return sb.toString();
	}
	
	public static String diamond(int n, char a, char b, char c)
	{
		char[] colors = {a, b, c};
		return diamond(n, colors);
	}
	
	public static String diamond(int n, char foreground, char background)
	{
		return diamond(n, foreground, background, ' ');
	}
	
	public static String diamond(int n, char color)
	{
		return diamond(n, color, ' ');
	}
	
	public static String diamond(int n)
	{
		return diamond(n, '*');
	}
	
	public static String diamond()
	{
		return diamond(8);
	}
	
	public static void main(String[] args)
	{
		System.out.print(diamond());
		System.out.print(diamond(5));
		System.out.print(diamond(7, '$'));
		System.out.print(diamond(6, '@', '.'));
		System.out.print(diamond(6, '@', '.', '_'));
        return;
	}
}