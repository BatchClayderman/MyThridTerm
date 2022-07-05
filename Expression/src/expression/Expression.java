package expression;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GCD
{
	/* 0 < a < b */
	public static long gcd_1(long _a, long _b)//���ƣ�ֱ��ɨ�裩
	{
		long a = Math.max(Math.abs(_a), Math.abs(_b)), b = Math.min(Math.abs(_a), Math.abs(_b));
		for (long i = b; i > 1; --i)// from min{a, b} to 1
			if (b % i == 0 && a % i == 0)//���������� i �ı���
				return i;
		return 1;
	}
	public static long gcd_1(int a, int b) { return gcd_1((long)a, (long)b); }
	
	public static long gcd_2(long _a, long _b)//շת�����������ʵ�֣�
	{ 
		long k = 0, a = Math.max(Math.abs(_a), Math.abs(_b)), b = Math.min(Math.abs(_a), Math.abs(_b)); 
		do 
		{
			k = a % b;//�õ�����
			a = b;//����շת������ѱ������������� 
			b = k;//�������������� 
		} while (k != 0);
		return a;//���ر����� 
	}
	public static long gcd_2(int a, int b) { return gcd_2((long)a, (long)b); }
	
	public static long gcd_3(long _a, long _b)//շת��������ݹ�ʵ�֣� 
	{
		long a = Math.max(Math.abs(_a), Math.abs(_b)), b = Math.min(Math.abs(_a), Math.abs(_b));
		if (b == 0)//���������ʱ�˳��ݹ� 
			return a; 
		if (a < 0)
			return gcd_3(-a, b);
		if (b < 0)
			return gcd_3(a, -b);
		return gcd_3(b, a % b); 
	}
	public static long gcd_3(int a, int b) { return gcd_3((long)a, (long)b); }
	
	public static long gcd(long a, long b) { return gcd_2((long)a, (long)b); }
	public static long gcd(int a, int b) { return gcd_2((long)a, (long)b); }
}

class Calculation
{
	/* ת������ */
	public static void transformation(ArrayList<String> list, String str)
	{
		ArrayList<String> list1 = new ArrayList<String>();
		int start1 = 0;
		for (int j = 0; j < str.length(); ++j)//�ָ���������� 
			if (str.charAt(j) == '_' || str.charAt(j) == '|')
			{
				list1.add(str.substring(start1, j));
				list1.add(str.substring(j, j+1));
				start1 = j + 1;
			}
		list1.add(str.substring(start1, str.length()));
		
		if (list1.size() == 1)//����ת����
		{
			String str1 = list1.get(0);
			if (str1.contains("."))
			{
				int index = str1.indexOf(".");
				String str2 = str1.substring(0,index);
				String str3 = str1.substring(index+1);
				long a = Long.parseLong(str2), b = Long.parseLong(str3), c = b, n = 1;
				while(c != 0)
				{
					n *= 10;
					c = (long)(c / n);
				}
				long m = a * n + b;
				long g = GCD.gcd(m, n);
				
				list.add(String.valueOf((a * n + b) / g));
				list.add("|");
				list.add(String.valueOf(n / g));
			}
			else
			{
				list.add(str1);
				list.add("|");
				list.add("1");
			}
		}
		else if(list1.size() == 3)
		{
			list.add(list1.get(0));
			list.add(list1.get(1));
			list.add(list1.get(2));
		}
		
		//������ת����
		else if(list1.size() == 5)
		{
			long a = Long.parseLong(list1.get(0));
			long b = Long.parseLong(list1.get(2));
			long c = Long.parseLong(list1.get(4));
			list.add(String.valueOf(a));
			list.add("|");
			list.add("1");
			list.add("+");
			list.add(String.valueOf(b));
			list.add("|");
			list.add(String.valueOf(c));
		}
		//ת�����
	}
	
	public static String calc(String expr)
	{
		StringBuilder sb = new StringBuilder(expr);
		while(sb.indexOf(" ") != -1)// Remove ()
			sb = sb.delete(sb.indexOf(" "), sb.indexOf(" ") + 1);
		String s = sb.toString(), res = null;
		
		if (s.contains("inf"))
			return "inf";
		
		if (s.indexOf("(") != -1)//�ж��Ƿ�������
		{
			int start = s.indexOf("(");//��¼���ŵ��±�
			int k = 1, end = start;//Ѱ�Ҷ�Ӧ���ŵ��±�ֵ������ֵ��end
			while(k != 0)
			{
				++end;
				k = s.charAt(end) == '(' ? k + 1 : k;
				k = s.charAt(end) == ')' ? k - 1 : k;
			}
			
			String r = calc(s.substring(start+1,end));//�������е�������ȡ���������������е�ֵ

			if (start > 0)//ת����a|(b|c) = a|b*c
			{
				if(s.charAt(start - 1) == '|') {
					int index = r.indexOf("|");
					String str1 = r.substring(0,index);
					String str2 = r.substring(index+1);
					r = str1 + "*" + str2;
				}
			}
			//ת����(a|b)|c=a|b/c
			if (end < s.length() - 1)
			{
				if (s.charAt(end + 1) == '|')
				{
					int index = r.indexOf("|");
					String str1 = r.substring(0,index);
					String str2 = r.substring(index+1);
					r = str1 + "/" + str2;
				}
			}
			res = calc(s.substring(0, start) + r + s.substring(end+1));
		}
		else//�������������
		{
			ArrayList<String> list = new ArrayList<String>();
			int start = 0;
			for(int i = 0; i <= s.length(); ++i)//�����ֺ���������룬����˳�����б�
			{
				if (s.length() == i)
				{
					//ת������
					String str = s.substring(start,i);
					transformation(list,str);
				}
				else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
					//ת������
					String str = s.substring(start,i);
					transformation(list,str);
					list.add(s.substring(i,i+1));
					start = i + 1;
				}
			}
			
			while (list.contains("*") || list.contains("/"))//�Ȱ�˳�����˷��ͳ���
			{
				//System.out.println(list);
				/* ��ȡ��һ��"*"��"/"���±� */
				int index1 = list.indexOf("*");
				int index2 = list.indexOf("/");
				int index = Math.min(index1, index2) != -1 ? Math.min(index1, index2) : Math.max(index1, index2);
				
				/* �������ǰ�ĵ�һ���� */
				long a = Long.parseLong(list.get(index-3));//��һ�����ķ���
				long b = Long.parseLong(list.get(index-1));//��һ�����ķ�ĸ
				
				/* ������ź�ĵ�һ���� */
				long c = Long.parseLong(list.get(index+1));//�ڶ������ķ���
				long d = Long.parseLong(list.get(index+3));//�ڶ������ķ�ĸ
				if (list.get(index).equals("*"))
				{
					long m = a * c, n = b * d;//������Ӻͷ�ĸ
					/* ͨ�� */
					if (0 == m)
					{
						list.set(index - 3, String.valueOf(0));
						list.set(index - 1, String.valueOf(1));
					}
					else if (0 == n)
						return "inf";
					else
					{
						long g = GCD.gcd(m, n);
						list.set(index - 3, String.valueOf(m / g));
						list.set(index - 1, String.valueOf(n / g));
					}
					list.remove(index);
					list.remove(index);
					list.remove(index);
					list.remove(index);
				}
				else
				{
					long m = a * d, n = b * c;
					if (0 == m)
					{
						list.set(index - 3, String.valueOf(0));
						list.set(index - 1, String.valueOf(1));
					}
					else if (0 == n)
						return "inf";
					else
					{
						long g = GCD.gcd(m, n);
						list.set(index - 3, String.valueOf(m/g));
						list.set(index - 1, String.valueOf(n/g));
						list.remove(index);
						list.remove(index);
						list.remove(index);
						list.remove(index);
					}
				}
			}
			
			/* ������˳������Ӽ� */
			while (list.contains("+") || list.contains("-"))
			{
				//System.out.println(list);
				int index1 = list.indexOf("+"), index2 = list.indexOf("-");
				int index = Math.min(index1, index2) != -1 ? Math.min(index1, index2) : Math.max(index1, index2);
				long a = Long.parseLong(list.get(index - 3));
				long b = Long.parseLong(list.get(index - 1));
				long c = Long.parseLong(list.get(index + 1));
				long d = Long.parseLong(list.get(index + 3));
				if (list.get(index).equals("+"))
				{
					long m = a * d + c * b;
					long n = b * d;
					long g = GCD.gcd(m, n);
					list.set(index - 3, String.valueOf(m/g));
					list.set(index - 1, String.valueOf(n/g));
					list.remove(index);
					list.remove(index);
					list.remove(index);
					list.remove(index);	
				}
				else
				{
					long m = a * d - c * b;
					long n = b * d;
					long g = GCD.gcd(m, n);
					list.set(index - 3, String.valueOf(m/g));
					list.set(index - 1, String.valueOf(n/g));
					list.remove(index);
					list.remove(index);
					list.remove(index);
					list.remove(index);
				}
			}
			/* ����б���ֻ������Ԫ�أ����ӣ�|����ĸ */
			res = list.get(0) + list.get(1) + list.get(2);
		}
		//System.out.println(res);
		return res;
	}
}

class Frac
{
	/* value = m + p / q */
	public long m;
	public long p;
	public long q;
	public boolean symbol = true;
	
	public Frac(long m, long p, long q)
	{
		this.m = m;
		this.p = p;
		this.q = q;
		this.reduce();
	}
	public Frac(int m, int p, int q)
	{
		this((long)m, (long)p, (long)q);
	}
	public Frac(long p, long q)
	{
		this(0L, p, q);
	}
	public Frac(int p, int q)
	{
		this(0L, p, q);
	}
	public Frac(double value)
	{
		this.m = (long)value;
		int n = (value + "").length() - (value + "").indexOf(".") - 1;
		this.q = (long)Math.pow(10, n);
		this.p = this.q * (long)(value - this.m);
		this.reduce();
	}
	public Frac(float value)
	{
		this((double)value);
	}
	public Frac(long value)
	{
		this.m = value;
		this.p = 0;
		this.q = 1;
	}
	public Frac(int value)
	{
		this((long)value);
	}
	public Frac(String value)
	{
		/* inf -> 0_0|0		0 -> 0_0|1		int -> m_0|1 */
		if (value.toLowerCase().equals("inf"))
		{
			this.m = 0;
			this.p = 0;
			this.q = 0;
		}
		else
		{
			Frac frac = null;
			if (2 == value.split("\\.").length)
				frac = new Frac(Double.parseDouble(value));
			else if (3 == value.replace("_", "|").split("\\|").length)
			{
				String[] mpq = value.replace("_", "|").split("\\|");
				frac = new Frac(Long.parseLong(mpq[0]), Long.parseLong(mpq[1]), Long.parseLong(mpq[2]));
			}
			else if (2 == value.split("\\|").length)
			{
				String[] pq = value.split("\\|");
				frac = new Frac(Long.parseLong(pq[0]), Long.parseLong(pq[1]));
			}
			else// should be int or long situation
			{
				try
				{
					frac = new Frac(Long.parseLong(value));
				}
				catch (Throwable e) {}
			}
			this.m = frac.m;
			this.p = frac.p;
			this.q = frac.q;
		}
	}
	public boolean isInf()
	{
		return 0L == this.q;
	}
	public boolean isZero()
	{
		return !this.isInf() && 0L == this.m && 0L == this.p;
	}
	public boolean isInt()
	{
		return !this.isInf() && (0L == this.p || 1L == this.q);
	}
	public boolean isValid()
	{
		if (this.isInf())
			return false;
		else
			return 0L == this.m || this.p < this.q;
	}
	public long reduce()
	{
		/* inf -> 0_0|0		0 -> 0_0|1		int -> m_0|1 */ 
		if (this.isInf())// inf
		{
			this.m = 0L;
			this.p = 0L;
			return 0L;
		}
		else if (this.isZero())
		{
			this.q = 1L;
			return 0L;
		}
		else if (this.isInt())
		{
			if (1 == this.q)// q is 1
			{
				this.m += this.p;
				this.p = 0L;
				return 0L;
			}
			else// p is 0
			{
				this.q = 1;
				return 0L;
			}
		}
		else
		{
			long gcd = GCD.gcd(this.q, this.p);
			this.p /= gcd;
			this.q /= gcd;
			//System.out.println(this.m + ", " + this.p + ", " + this.q);
			this.toWholeFrac();
			//System.out.println(this.m + ", " + this.p + ", " + this.q);
			return gcd;
		}
	}
	public int compareTo(Frac frac)
	{
		/**
		 * this > frac -> 1
		 * this == frac -> 0
		 * this < frac -> -1
		 */
		if (this.symbol && !frac.symbol)
			return 1;
		else if (!this.symbol && frac.symbol)
			return -1;
		else
		{
			if (this.m > frac.m)
				return this.symbol ? 1 : -1;
			else if (this.m < frac.m)
				return this.symbol ? -1 : 1;
			else
				return 0;
		}
	}
	public boolean equals(Frac frac)
	{
		if (0 == frac.p && 0 == this.p)
			return frac.m == this.m;
		else
			return frac.m == this.m && frac.p == this.p && frac.q == this.q;
	}
	public boolean equals(long m, long p, long q)
	{
		return this.equals(new Frac(m, p, q));
	}
	public boolean equals(int m, int p, int q)
	{
		return this.equals(new Frac(m, p, q));
	}
	public boolean equals(long p, long q)
	{
		return this.equals(new Frac(0, p, q));
	}
	public boolean equals(int p, int q)
	{
		return this.equals(new Frac(0, p, q));
	}
	public boolean equals(double value)
	{
		return this.equals(new Frac(value));
	}
	public boolean equals(float value)
	{
		return this.equals(new Frac(value));
	}
	public boolean equals(long value)
	{
		return this.equals(new Frac(value));
	}
	public boolean equals(int value)
	{
		return this.equals(new Frac(value));
	}
	public boolean equals(String value)
	{
		return this.equals(new Frac(value));
	}
	public void add(Frac frac)
	{
		this.m += frac.m;
		this.p += frac.p;
		this.q += frac.q;
		this.toWholeFrac();
		this.reduce();
		return;
	}
	public void sub(Frac frac)
	{
		this.m -= frac.m;
		this.p -= frac.p;
		this.q -= frac.q;
		this.toWholeFrac();
		this.reduce();
		return;
	}
	public void mul(Frac frac)
	{
		this.toFakeFrac();
		this.p *= frac.p;
		this.q *= frac.q;
		this.toWholeFrac();
		this.reduce();
		return;
	}
	public void div(Frac frac)
	{
		this.toFakeFrac();
		this.p *= frac.q;
		this.q *= frac.p;
		this.toWholeFrac();
		this.reduce();
		return;
	}
	public void toWholeFrac()
	{
		if (this.isInf() || this.isZero() || this.isInt())
			return;
		long m = (long)(this.p / this.q);
		this.m += m;
		this.p -= m * this.q;
		return;
	}
	public Frac getWholeFrac()
	{
		Frac frac = new Frac(this.m, this.p, this.q);
		frac.toWholeFrac();
		return frac;
	}
	public void toFakeFrac()
	{
		if (this.isInf() || this.isZero() || this.isInt())
			return;
		this.p += this.m + this.q;
		this.m = 0;
		return;
	}
	public Frac getFakeFrac()
	{
		Frac frac = new Frac(this.m, this.p, this.q);
		frac.toFakeFrac();
		return frac;
	}
	public void toReverseFrac()
	{
		this.toFakeFrac();
		this.m = this.p;
		this.p = this.q;
		this.q = this.m;
		this.m = 0;
		this.toWholeFrac();
	}
	public Frac getReverseFrac()
	{
		Frac frac = new Frac(this.m, this.p, this.q);
		frac.toReverseFrac();
		return frac;
	}
	public Double toDouble()
	{
		if (this.isInf())
			return null;
		else if (this.isZero())
			return new Double(0);
		else if (this.isInt())
			return new Double(this.m);
		else
			return new Double(this.m + (double)this.p / this.q);
	}
	public Float toFloat()
	{
		if (this.isInf())
			return null;
		else if (this.isZero())
			return new Float(0);
		else if (this.isInt())
			return new Float(this.m);
		else
			return new Float(this.m + (double)this.p / this.q);
	}
	public Long toLong()
	{
		if (this.isInf())
			return null;
		else if (this.isZero())
			return new Long(0L);
		else if (this.isInt())
			return new Long(this.m);
		else
			return new Long(this.m + (long)this.p / this.q);
	}
	public Integer toInteger()
	{
		if (this.isInf())
			return null;
		else if (this.isZero())
			return new Integer(0);
		else if (this.isInt())
			return new Integer((int)this.m);
		else
			return new Integer((int)(this.m + (this.p / this.q)));
	}
	public String toString()
	{
		if (this.isInf())
			return "inf";
		else if (this.isZero())
			return "0";
		else if (this.isInt())
			return "" + this.m;
		else if (0 == this.m)
			return this.p + "|" + this.q;
		else
			return this.m + "_" + this.p + "|" + this.q;
	}
}

class Node
{
	private int id;
	private Frac answer;
	private String expr = "";
	private int hard = 0;// {0123456789 +- */ . _|}
	private Boolean isCorrect = null;
	
	public Node(int id)
	{
		this.id = id;
	}
	public int getRandom(int min, int max)
	{
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
	public String generate(int op_len, int num_len)
	{
		if (op_len <= 0 || num_len <= 0)
			return this.generate();
		String symbols = "0123456789.";
		char tmp = ' ';
		int op_cnt = 0, num_cnt = 0;
		for (;;)
		{
			char symbol = symbols.charAt(getRandom(0, symbols.length() - 1));
			switch(symbol)
			{
			case '*':
			case '/':
				++this.hard;
			case '+':
			case '-':
				this.hard += 2;
				this.expr += " " + symbol + " ";
				symbols = '/' == symbol ? "0123456789." : "123456789.";// Disable operators
				tmp = ' ';// Free tmp
				op_cnt += 1;// ++op_cnt
				num_cnt = 0;// reset num_cnt
				break;
			case '_':
				this.hard += 5;
				if (1 == num_cnt && this.expr.endsWith("0"))
					this.expr = this.expr.substring(0, this.expr.length() - 1);
				else
					this.expr += symbol;
				symbols = "0123456789";
				tmp = '_';// | only after 0123456789
				num_cnt = 0;
				break;
			case '|':
				++this.hard;
			case '.':
				this.hard += 4;
				if ('.' == symbol && 0 == num_cnt)
					this.expr += "0.";
				else
					this.expr += symbol;
				symbols = "0123456789";
				tmp = symbol;// +-*/ only after 0123456789
				num_cnt = 0;
				break;
			case '=':
				/* m_p|q */
				String pattern = " (\\d+)\\_(\\d+)\\|(\\d+) ";
				Pattern r = Pattern.compile(pattern);
				Matcher matcher = r.matcher(" " + this.expr + " ");
				ArrayList<String> list = new ArrayList<>();
		        while (matcher.find())
		        {
		        	String group = matcher.group();
		        	//System.out.println("Found: " + group.substring(1, group.length() - 1));
		            list.add(group.substring(1, group.length() - 1));
		        }
		        for (String group : list)
		        	this.expr = this.expr.replace(group, new Frac(group).toString());
		        //System.out.println(this.expr);
		        
		        /* p|q */
		        pattern = " (\\d+)\\|(\\d+) ";
				r = Pattern.compile(pattern);
				matcher = r.matcher(" " + this.expr + " ");
				list = new ArrayList<>();
		        while (matcher.find())
		        {
		        	String group = matcher.group();
		        	//System.out.println("Found: " + group.substring(1, group.length() - 1));
		            list.add(group.substring(1, group.length() - 1));
		        }
		        for (String group : list)
		        	this.expr = this.expr.replace(group, new Frac(group).toString());
		        //System.out.println(this.expr);
		        
		        /* a.b */
		        pattern = " (\\d+)\\.(\\d+) ";
				r = Pattern.compile(pattern);
				matcher = r.matcher(" " + this.expr + " ");
				list = new ArrayList<>();
		        while (matcher.find())
		        {
		        	String group = matcher.group();
		            list.add(group.substring(1, group.length() - 1));
		        }
		        for (String group : list)
		        {
		        	double value = Double.parseDouble(group);
		        	this.expr = this.expr.replace(group, "" + ((long)value == value ? (long)value : value));
		        }
		        
		        if (
		        	(this.expr + " ").contains("/ 0 ")// to avoid divided by zero
		        	|| this.expr.contains("inf")// to avoid inf
		        )
				{
					this.expr = "";
					return this.generate();
				}
		        //System.out.println(this.expr);
		        
		        return this.expr;
			default:
				++this.hard;
				this.expr += symbol;
				if (0 == num_cnt && '0' == symbol)
					num_cnt = num_len;
				else
					num_cnt += 1;
				//System.out.println(this.expr + ", " + symbols + ", " + tmp + ", " + num_cnt + ", " + num_len);
				switch(tmp)
				{
				case '_':
					symbols = num_cnt < num_len ? "0123456789|" : "|";// limit the length of parts of number
					break;
				case '|':
				case '.':
					if (op_len <= op_cnt)// could exit
						symbols = num_cnt < num_len ? "0123456789=" : "=";
					else
						symbols = num_cnt < num_len ? "0123456789+-*/" : "+-*/";
					if ('|' == symbol && 0 == num_cnt && symbols.startsWith("0"))// could not be 0
						symbols = symbols.substring(0);
					break;
				default:
					if (op_len <= op_cnt)// could exit
						symbols = num_cnt < num_len ? "0123456789=_|." : "=_|.";
					else
						symbols = num_cnt < num_len ? "0123456789+-*/_|." : "+-*/_|.";
					break;
				}
				break;
			}
		}
	}
	public String generate()
	{
		return this.generate(getRandom(1, 3), 4);
	}
	public Frac solve()
	{
		return this.answer;
	}
	public boolean examination(Scanner sc)
	{
		System.out.print(this + " = ");// Let user see the question at first
		this.answer = new Frac(Calculation.calc(this.expr));
		String answer = sc.nextLine();
		if (2 == answer.split(".").length)
			return this.answer.equals(Double.parseDouble(answer));
		else if (3 == answer.replace("_", "|").split("\\|").length)
		{
			String[] mpq = answer.replace("_", "|").split("\\|");
			return this.answer.equals(Long.parseLong(mpq[0]), Long.parseLong(mpq[1]), Long.parseLong(mpq[2]));
		}
		else if (2 == answer.split("\\|").length)
		{
			String[] pq = answer.split("\\|");
			return this.answer.equals(Long.parseLong(pq[0]), Long.parseLong(pq[1]));
		}
		else// should be int or long situation
		{
			try
			{
				return this.answer.equals(Long.parseLong(answer));
			}
			catch (Throwable e)
			{
				return false;
			}
		}
	}
	public boolean dumpExam(Scanner sc, boolean force_update)
	{
		if (force_update || (null == this.isCorrect))
			this.isCorrect = this.examination(sc);
		return this.isCorrect;
	}
	public boolean dumpExam(Scanner sc) { return this.dumpExam(sc, false); }
	public void printExam()
	{
		System.out.println(this + " = " + this.answer + "\t\t" + this.isCorrect + "\t\thard: " + this.hard);
		return;
	}
	public String toString()
	{
		return "[" + this.id + "] " + this.expr;
	}
}

public class Expression
{
	public static int getN(Scanner sc)
	{
		System.out.print("Enter the number of expressions: ");
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
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		/* Initial */
		int n = getN(sc);
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; ++i)
		{
			Node node = new Node(i + 1);
			node.generate();
			nodes[i] = node;
		}
		System.out.println("");
		
		/* Examination */
		int correct = 0, total = 0;
		for (Node node:nodes)
		{
			total += 1;
			if (node.dumpExam(sc))
				correct += 1;
		}
		System.out.println("\n");
		
		/* Score */
		for (Node node:nodes)
			node.printExam();
		System.out.println("correct / total = " + correct + " / " + total + " = " + ((double)correct * 100 / total) + "%");
		
		sc.close();
        return;
	}
}