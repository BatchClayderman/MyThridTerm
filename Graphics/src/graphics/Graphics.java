package graphics;
import java.util.Calendar;

/**
  * 这是一个关于信息安全数学基础运算和平面解析集合的程序
 * @author Batch Clayderman
 *
  * 目前已支持：
 * 	一些数学应用
 * 	复平面
 * 	点
 * 	圆
 * 	椭圆
 * 	双曲线
 * 	抛物线
 * 	日期
 */


interface DynamicType//抽象动态数组接口
{
	public static final String name = "抽象动态数组类";
	public int[] getArr();
	public void setArr(int[] arr);
	public int getLength();
	public void setLength(int length);
	public void append(int a);
	public int IntAt(int i);
	public String toString();
}

class Int implements DynamicType//动态 int 数组类
{
	public static final String name = "动态 int 数组类";
	private int[] arr = new int[0];
	private int length = 0;
	Int()
	{
		this.arr = new int[0];
	}
	public int[] getArr()
	{
		return arr;
	}
	public void setArr(int[] arr)
	{
		this.arr = arr;
	}
	public int getLength()
	{
		return length;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public void append(int a)
	{
		this.length++;
		int[] tmp = new int[this.length];
		for (int i = 0; i < this.length - 1; ++i)
			tmp[i] = this.arr[i];
		tmp[this.length - 1] = a;
		this.arr = tmp;
	}
	public int IntAt(int i)
	{
		return this.arr[i];
	}
	public String toString()
	{
		if (this.length <= 0)
			return "<>";
		String res = "<" + this.arr[0];
		for (int i = 1; i < this.length; ++i)
			res += ", " + this.arr[i];
		res += ">";
		return res;
	}
}

class PrintArr//打印数组类
{
	public static final String name = "打印数组类";
	static void printArr(int[] Arr)//打印 int 数组
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(int[] Arr, String startText, String endText, String delineText)//打印 int 数组
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static void printArr(double[] Arr)//打印 double 数组
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(double[] Arr, String startText, String endText, String delineText)//打印 double 数组
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static void printArr(long[] Arr)//打印 long 数组
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(long[] Arr, String startText, String endText, String delineText)//打印 long 数组
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static String stringINVar(String s)//转义双引号
	{
		for (int i = 0; i < s.length(); ++i)
			if (s.charAt(i) == '\"')//将 " 变为 \"
			{
				s = s.substring(0, i) + "\\" + s.substring(i);
				i++;
			}
		return "\"" + s + "\"";
	}
	static void printArr(String[] Arr)//打印字符串数组
	{
		if (Arr.length <= 0)
			return;
		System.out.print("[" + stringINVar(Arr[0]));
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(", " + stringINVar(Arr[i]));
		System.out.println("]");
	}
	static void printArr(Point2D[] Arr)//打印点坐标数组
	{
		printArr(Arr, "", "", "");
	}
	static void printArr(Point2D[] Arr, String startText, String endText, String delineText)//打印 long 数组
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
}


class MyMathFunction extends PrintArr//数学应用类
{
	public static final String name = "数学应用类";
	public static final int EOF = (-1);
	static int mod(int a, int b)//取余数
	{
		if (b <= 0)
			return EOF;
		if (a < 0)
		{
			int k = (int)(a / b);//取负数
			a -= (k - 1) * b;//使得 a 为正数
		}
		return a % b;
	}
	static long mod(long a, long b)//取余数
	{
		if (b <= 0)
			return EOF;
		if (a < 0)
		{
			long k = (long)(a / b);//取负数
			a -= (k - 1) * b;//使得 a 为正数
		}
		return a % b;
	}
	static long power(long a, long b)//求指数
	{
		long result = 1;
		for (int i = 0; i < b; ++i)
			result *= a;
		return result;
	}
	
	static boolean isPrime(int n)//判断是否为素数
	{
		for (int i = 2; i <= (int)Math.sqrt(n); ++i)
			if (n % i == 0)
				return false;
		return true;
	}
	static long sum(long n)//求和
	{
		try
		{
			if (n < 0)
				return EOF;
			else if (n == 0 || n == 1)
				return 1;
			else
				return n + sum(n - 1);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return EOF;
	}
	static long sum(int[] n)//求和
	{
		long sum = 0;
		for (int a : n)
			sum += a;
		return sum;
	}
	static long fact(long n)//求阶乘
	{
		try
		{
			if (n < 0)
				return EOF;
			else if (n == 0 || n == 1)
				return 1;
			else
				return n * fact(n - 1);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return EOF;
	}
	static int[] factor(int n)//分解因式
	{
		int[] factors = new int[n >> 1];
		int i = 0, j = 2;
		while (n > 1)
			if (((double)n / (double)j) == (int)(n / j))
			{
				factors[i] = j;
				i++;
				n /= j;
			}
			else
				do
				{
					j++;
				} while (!isPrime(j));
		int[] factors_new = new int[i];
		for (int k = 0; k < i; ++k)
			factors_new[k] = factors[k];
		return factors_new;
	}
	static int gcd(int a, int b)//求最大公因数
	{
		if (a < 0 || b < 0)
			return EOF;//异常值
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a < b)//让 a 最大
		{
            int temp = a;
            a = b;
            b = temp;
        }
		int k = a % b;
        if (k != 0)
            return gcd(b, k);//再次循环
        return b;
	}
	static int lcm(int a, int b)//求最小公倍数
	{
		if (a < 0 || b < 0)
			return EOF;//异常值
		if (a == 0 || b == 0)// 0 是任何数的倍数
			return 0;
		if (a < b)//让 a 最大
		{
            int temp = a;
            a = b;
            b = temp;
        }
		int cd = gcd(a, b);//取最大公因数
        return (int)(a / cd) * (int)(b / cd);
	}
	static String[] exgcd(int p, int q)//扩展欧几里得除法
	{
		String[] result = new String[2];
		if (p == 0 && q != 0)
		{
			result[0] = "任意整数";
			result[1] = "1";
			return result;
		}
		else if (q == 0 && p != 0)
		{
			result[0] = "1";
			result[1] = "任意整数";
			return result;
		}
		else if (p == 0 && q == 0)
		{
			result[0] = "任意整数";
			result[1] = "任意整数";
			return result;
		}
		int m = Math.max(Math.abs(p), Math.abs(q));
		int n = Math.min(Math.abs(p), Math.abs(q));
		int x = 1, j = 1, y = 0, i = 0, c = m, d = n;
		int o = (int)(c / d), r = c % d;
		while (r != 0)
		{
			c = d;
			d = r;
			int z = x;
			x = i;
			i = z - o * i;
			z = y;
			y = j;
			j = z - o * j;
			o = (int)(c/ d);
			r = c % d;
		}
		if (Math.abs(p) >= Math.abs(q))
		{
			result[0] = String.valueOf((int)(i * p / Math.abs(p)));
			result[1] = String.valueOf((int)(j * q / Math.abs(q)));
		}
		else
		{
			result[0] = String.valueOf((int)(j * p / Math.abs(p)));
			result[1] = String.valueOf((int)(i * q / Math.abs(q)));
		}
		return result;
	}
	static int sumfactor(int n)//因子之和（不含自身）
	{
		int sum = 0;
		for (int i = 1; i < n; ++i)
			if (n % i == 0)
				sum += i;
		return sum;
	}
	static int lrd(int p1, int p2)//勒让德符号
	{
		if (p1 < 0 || p2 < 2)
			return EOF;
		if (p1 == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < p2; ++i)
			if (i * i % p2 == p1 % p2)
				count += 1;
		return count;
	}
	static long modsq(long x, long n, long m)//模平方剩余
	{
		if (n < 0)
			return EOF;
		if (x == 0 && n == 0)
			return EOF;
		if (m < 2)
			return EOF;
		try
		{
			long a = 1, b = x;
			for (;;)//无条件死循环
			{
				long temp = n;
				if (mod(n, 2) == 1)
					a = mod(a * b, m);
				b = mod(b * b, m);
				n = (long)(n / 2);
				if (temp < 1)
					return a;
			}
		}
		catch (Exception e)
		{
			return EOF;
		}
	}
	static long zm(long p1, long p2)
	{
		if (p1 < 2 || p2 < 2)
			return 0;
		int i = 1;
		try
		{
			for (;;)//无条件死循环
			{
				if (power(p1, i) % p2 == 1)
					return i;
				else
					i++;
			}
		}
		catch (Exception e)
		{
			return EOF;
		}
	}
	static int euler(int x)//欧拉函数
	{
		if (x <= 1)
			return EOF;
		int count = 0;
		for (int i = 1; i < x; ++i)
			if (gcd(x, i) == 1)
				count++;
		return count;
	}
	static int order(int a, int n, int b)// order 函数
	{
		int p = 1;
		while (p <= n && (power(b, p) % a != 1))
			p++;
		if (p <= n)
			return p;
		else
			return EOF;
	}
	static int[] SeekRoot(int a)//求原根
	{
		int[] result = new int[a];
		if (a < 1)
			return result;
		int kk = 0, n = euler(a);
		for (int b = 2; b < a; ++b)
			if (order(a, n, b) == n)
			{
				result[kk] = b;
				kk++;
			}
		int[] finalResult = new int[kk];
		for (int i = 0; i < kk; ++i)
			finalResult[i] = result[i];
		return finalResult;
	}
	static int[] tmpArcmod(int a, int b)//求逆元递归部分
	{
		int[] tmp = new int[2];
		tmp[0] = 1;
		tmp[1] = 0;
		if (b == 0)
			return tmp;
		else
		{
			int k = (int)(a / b);
			int remainder = mod(a, b);
			int[] ttmp = tmpArcmod(b, remainder);
			tmp[0] = ttmp[1];
			tmp[1] = ttmp[0] - k * ttmp[1];
			return tmp;
		}
	}
	static int arcmod(int a, int b)//求逆元
	{
		if (gcd(a, b) != 1)
			return EOF;
		int[] ttmp = tmpArcmod(a, b);
		return mod(ttmp[0], b);
	}
	static Int lfs(int p1, int p2)//连分数
	{
		Int result = new Int();
		if (p2 == 0)
			return result;
		Int xp = new Int(), xq = new Int();
		int i = 0;
		try
		{
			for (;;++i)
			{
				result.append((int)(p1 / p2));
				xp.append(mod(p1, p2));
				xq.append(p2);
				if (xp.IntAt(i) == 0)
					return result;
				p1 = xq.IntAt(i);
				p2 = xp.IntAt(i);
			}
		}
		catch(Exception e)
		{
			return result;
		}
	}
}


class Date//日期类
{
	public static final String name = "日期"; 
	private int year, month, day;//年月日
	public static final int defaultYear = 2002;
	public static final int defaultMonth = 7;
	public static final int defaultDay = 6;
	public static final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//大月
	public static final int[] smallMonth = {4, 6, 9, 11};//小月
	public static final String[] Weekdays = {"一", "二", "三", "四", "五", "六", "日"};
	public static final int EOF = (-1);
	public static boolean isInArray(int a, int[] Arr)
	{
		for (int i = 0; i < Arr.length; ++i)
			if (Arr[i] == a)
				return true;
		return false;
	}
	public static boolean isLeapyear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public static boolean isRightDate(int y, int m, int d)
	{
		final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//大月
		final int[] smallMonth = {4, 6, 9, 11};//小月
		if (isInArray(m, bigMonth) && (d >= 1 && d <= 31))
			return true;
		else if (isInArray(m, smallMonth) && (d >= 1 && d <= 30))
			return true;
		else if (m == 2)
		{
			if (isLeapyear(y))
				return (d >= 1 && d <= 29);
			else
				return (d >= 1 && d <= 28);
		}
		else
			return false;
	}
	
	public Date()
	{
		this.year = defaultYear;
		this.month = defaultMonth;
		this.day = defaultDay;
	}
	public Date(int y, int m, int d)
	{
		if (isRightDate(y, m, d))
		{
			this.year = y;
			this.month = m;
			this.day = d;
		}
		else//日期有误
		{
			this.year = defaultYear;
			this.month = defaultMonth;
			this.day = defaultDay;
		}
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public int getMonth()
	{
		return month;
	}
	public void setMonth(int month)
	{
		this.month = month;
	}
	public int getDay()
	{
		return day;
	}
	public void setDay(int day)
	{
		this.day = day;
	}
	
	int dayofYear()//一年中的第几天
	{
		int days = 0;
		if (!isRightDate(this.year, this.month, this.day))//错误的日期
			return EOF;
		for (int i = 1; i <= this.month; ++i)
			if (isInArray(i, bigMonth))
				days += 31;
			else if (isInArray(i, smallMonth))
				days += 30;
			else if (i == 2)
				days += (isLeapyear(this.year) ? 29 : 28);
		return days;
	}
	int getAge()//获取岁数
	{
		Date today = getToday();
		if (this.equals(today))
			return 0;
		if (getEarly(this, today).equals(today))
			return EOF;
		int age = today.year - this.year;
		Date toyearBirth = new Date(today.year, this.month, this.day);//今年的生日到了没
		if (!getLater(today, toyearBirth).equals(today))//没到减一
			age--;
		return age;
	}
	public static Date getToday()//今天
	{
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int yy = c.get(Calendar.YEAR);//今年
		int mm = c.get(Calendar.MONTH) + 1;//今月（记得 +1）
		int dd = c.get(Calendar.DATE);//今日
		Date today = new Date(yy, mm, dd);
		return today;
	}
	public static int getWeekday(int y, int m ,int d)//获取星期数
	{
		if (!isRightDate(y, m, d))
			return EOF;
		if (1 == m || 2 == m)
		{
			m += 12;
			--y;
		}
		//public static final String[] Weekdays = {"一", "二", "三", "四", "五", "六", "日"};
		return (d + (m << 1) + 3 * (m + 1) / 5 + y + (y >> 2) - y / 100 + y / 400) % 7;
	}
	public static int getWeekday(Date date)//获取星期数
	{
		return getWeekday(date.year, date.month, date.day);     
	}
	public int getWeekday()
	{
		return getWeekday(this);
	}
	void addOneMonth()
	{
		if (this.month == 12)
		{
			this.month = 1;
			this.year++;
		}
		else
			this.month++;
	}
	void addOneDay()
	{
		if (isInArray(this.month, bigMonth))
		{
			if (this.day == 31)
			{
				this.day = 1;
				this.addOneMonth();
			}
			else
				this.day++;
		}
		else if (isInArray(this.month, smallMonth))
		{
			if (this.day == 30)
			{
				this.day = 1;
				this.addOneMonth();
			}
			else
				this.day++;
		}
		else if (this.month == 2)
		{
			if (isLeapyear(this.year) && this.day == 29)
			{
				this.day = 1;
				this.month++;
			}
			else if (!isLeapyear(this.year) && this.day == 28)
			{
				this.day = 1;
				this.month++;
			}
			else
				this.day++;
		}		
	}
	void addDays(int days)
	{
		for (int i = 0; i < days; ++i)
			addOneDay();
	}
	void add(int y, int m, int d)
	{
		if (y < 0 || m < 0 || d < 0)
			return;
		else
		{
			y += (int)(m / 12);//一年十二月
			m %= 12;
			this.year += y;
			for (int i = 0; i < m; ++i)
				this.addOneMonth();
			this.addDays(d);
		}
	}
	public static Date getEarly(Date date1, Date date2)
	{
		if (date1.year == date2.year)
		{
			if (date1.month == date2.month)
				return (date1.day <= date2.day ? date1 : date2);
			else
				return (date1.month < date2.month ? date1 : date2);
		}
		else
			return (date1.year < date2.year ? date1 : date2);
	}
	public static Date getLater(Date date1, Date date2)
	{
		if (date1.year == date2.year)
		{
			if (date1.month == date2.month)
				return (date1.day >= date2.day ? date1 : date2);
			else
				return (date1.month > date2.month ? date1 : date2);
		}
		else
			return (date1.year > date2.year ? date1 : date2);
	}
	int distance(Date date)//计算两天差
	{
		int result = 0;
		Date early = getEarly(this, date), later = getLater(this, date);
		while (!early.equals(later))
		{
			early.addOneDay();
			result++;
		}
		return result;
	}
	int distance(int year, int month, int day)//计算两天差
	{
		if (!isRightDate(year, month, day))
			return EOF;
		int result = 0;
		Date tmp = new Date(year, month, day);
		Date early = getEarly(this, tmp), later = getLater(this, tmp);
		while (!early.equals(later))
		{
			early.addOneDay();
			result++;
		}
		return result;
	}
	public boolean equals(Date date)//重载
	{
		return (this.year == date.year && this.month == date.month && this.day == date.day);
	}
	public String toString()//重载
	{
		return this.year + " 年 " + this.month + " 月 " + this.day + " 日星期" + Weekdays[getWeekday(this)];
	}
}


class G_2D//平面图形基类
{
	public static final String name = "平面图形";
	public static String getName()
	{ 
		return name;
	}
	public static String atoS(double a)//相当于 C/C++ 中的 %g
	{
		if (a == (int)(a))
			return "" + (int)(a);
		else
			return "" + a;
	}
	public static String atoX(double a)//系数（排除 1）
	{
		if (a == 1)
			return "";
		else if (a == (int)(a))
			return "" + (int)(a);
		else
			return "" + a;
	}
	public String toString()//多态
	{
		return name;
	}
}

class Complex extends G_2D//复平面类
{
	public static final String name = "复平面类";
	private double realPart, imaginePart;
	public static final double defaultRealPart = 0, defaultImaginePart = 0;
	public Complex()
	{
		this.realPart = defaultRealPart;
		this.imaginePart = defaultImaginePart;
	}
	public Complex(double i, double j)
	{
		this.realPart = i;
		this.imaginePart = j;
	}
	public double getRealPart()
	{
		return realPart;
	}
	public void setRealPart(double realPart)
	{
		this.realPart = realPart;
	}
	public double getimaginePart()
	{
		return imaginePart;
	}
	public void setimaginePart(double imaginePart)
	{
		this.imaginePart = imaginePart;
	}
	public Complex addComplex(Complex c)//相加
	{
		double real = this.realPart + c.realPart;
		double imagine = this.imaginePart + c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex minComplex(Complex c)//相减
	{
		double real = this.realPart - c.realPart;
		double imagine = this.imaginePart - c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex mulComplex(Complex c)//相乘
	{
		double real = this.realPart * c.realPart - this.imaginePart * c.imaginePart;//注意 i * i = -1
		double imagine = this.imaginePart * c.realPart + this.realPart * c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex divComplex(Complex c)//相除
	{
		double real = this.realPart * c.realPart + this.imaginePart * c.imaginePart;//注意 i * i = -1
		double imagine = this.imaginePart * c.realPart - this.realPart * c.imaginePart;//利用平方差公式分母实数化
		double T = c.getSquareT();//是模长的平方
		real /= T;
		imagine /= T;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex conjugate()//共轭复数
	{
		Complex result = new Complex(this.realPart, -this.imaginePart);
		return result;
	}
	public static Complex conjugate(Complex c)
	{
		Complex result = new Complex(c.realPart, -c.imaginePart);
		return result;
	}
	public double getT()//求模长
	{
		return Math.sqrt(this.realPart * this.realPart + this.imaginePart + this.imaginePart);
	}
	public double getSquareT()//求模平方
	{
		return this.realPart * this.realPart + this.imaginePart + this.imaginePart;
	}
	public static double getT(Complex c)//求模长
	{
		return Math.sqrt(c.realPart * c.realPart + c.imaginePart + c.imaginePart);
	}
	public static double getSquareT(Complex c)//求模平方
	{
		return c.realPart * c.realPart + c.imaginePart + c.imaginePart;
	}
	public String toString()
	{
		if (this.realPart == 0 && this.imaginePart == 0)
			return "0";
		else if (this.realPart == 0)
			return atoX(this.imaginePart) + "i";
		else if (this.imaginePart == 0)
			return atoS(this.realPart);
		else
			return atoS(this.realPart) + " + " + atoX(this.imaginePart) + "i";
	}
}

class Point2D extends G_2D//二维平面上的点
{
	public static final String name = "二维平面";
	double x, y;
	public static final double defaultX = 0, defaultY = 0;
	Point2D()
	{
		this.x = defaultX;
		this.y = defaultY;
	}
	Point2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public double getX()
	{
		return x;
	}
	public void setX(double x)
	{
		this.x = x;
	}
	public double getY()
	{
		return y;
	}
	public void setY(double y)
	{
		this.y = y;
	}
	public void setCoordinate(double x, double y)//设置坐标
	{
		this.x = x;
		this.y = y;
	}
	public void setCoordinate(Point2D p)//复制坐标
	{
		this.x = p.x;
		this.y = p.y;
	}
	public double distance()//求与原点的距离
	{
		return Math.sqrt(this.x * this.x + this.y * this.y); 
	}
	public double distance(Point2D p)//求与点 p 的距离
	{
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}
	public boolean equals(Point2D p)//是否相等
	{
		if (this.x == p.x && this.y == p.y)
			return true;
		else
			return false;
	}
	public boolean equals(double x, double y)//是否相等
	{
		if (this.x == x && this.y == y)
			return true;
		else
			return false;
	}
	public static boolean equals(Point2D p1, Point2D p2)//是否相等
	{
		if (p1.x == p2.x && p1.y == p2.y)
			return true;
		else
			return false;
	}
	public static boolean equals(double x1, double y1, double x2, double y2)//是否相等
	{
		if (x1 == x2 && y1 == y2)
			return true;
		else
			return false;
	}
	static double distance(Point2D p1, Point2D p2)//求两点距离
	{
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));	
	}
	void move(double dX, double dY)//移动
	{
		this.x += dX;
		this.y += dY;
		return;
	}
	public String toString()//重载
	{
		return "(" + atoS(this.x) + ", " + atoS(this.y) + ")";
	}
}

class Circle2D extends G_2D//圆
{
	public static final String name = "平面圆";
	private double radius;//半径
	private Point2D center;//圆心
	public static final double pi = 3.1415926535;// pi
	public static final double defaultRadius = 1;
	Circle2D()
	{
		this.radius = defaultRadius;
		this.center = new Point2D(0, 0);
	}
	Circle2D(double r, Point2D p)
	{
		if (r > 0)
			this.radius = r;
		else
			this.radius = defaultRadius;
		this.center = p;
	}
	Circle2D(double r, double x, double y)
	{
		if (r > 0)
			this.radius = r;
		else
			this.radius = defaultRadius;
		this.center = new Point2D(x, y);
	}
	Point2D getCenter()
	{
		return this.center;
	}
	void setCenter(double x, double y)
	{
		this.center.setCoordinate(x, y);
	}
	void setCenter(Point2D p)
	{
		this.center.setCoordinate(p);
	}
	double getRadius()
	{
		return this.radius;
	}
	void setRadius(double r)
	{
		if (r > 0)
			this.radius = r;
	}
	double getArea()
	{
		return this.radius * this.radius * pi;
	}
	double getPerimeter()
	{
		return this.radius * 2 * pi;
	}
	void move(double dX, double dY)
	{
		this.center.move(dX, dY);
	}
	String location(Circle2D c)
	{
		if (this.center.equals(c.center))
		{
			if (this.radius == this.radius)
				return "重合";
			else
				return "互为同心圆";
		}
		else if (this.center.distance(c.center) > this.radius + c.radius)
			return "相离";
		else if (this.center.distance(c.center) == this.radius + c.radius)
			return "外切";
		else if (this.center.distance(c.center) == Math.abs(this.radius - c.radius))
			return "内切";
		else if (this.center.distance(c.center) < Math.abs(this.radius - c.radius))
			return "内含";
		else
			return "相交";
	}
	public String toString()//获取表达式（重载）
	{
		String expr = "";
		if (this.center.x > 0)
			expr += "(x-" + atoS(this.center.x) + ")";
		else if (this.center.x < 0)
			expr += "(x+" + atoS(-this.center.x) + ")";
		else
			expr += "x";
		expr += "^2 + ";
		if (this.center.y > 0)
			expr += "(y-" + atoS(this.center.y) + ")";
		else if (this.center.y < 0)
			expr += "(y+" + atoS(-this.center.y) + ")";
		else
			expr += "y";
		double squareR = this.radius * this.radius;
		expr += "^2 = " + atoS(squareR);
		return expr;
	}
}

class Oval2D extends G_2D//椭圆
{
	public static final String name = "平面椭圆";
	private double squareA;//半长轴的平方
	private double squareB;//半短轴的平方
	private Point2D center;//中心
	private boolean normalType;//是否常规横置的椭圆
	public static final double pi = 3.1415926535;// pi
	public static final double defaultSquareA = 4, defaultSquareB = 3;
	Oval2D()
	{
		this.squareA = defaultSquareA;
		this.squareB = defaultSquareB;
		this.center = new Point2D(0, 0);
		this.normalType = true;
	}
	Oval2D(double squareA, double squareB, Point2D p, boolean normalType)
	{
		if (squareA > 0)
			this.squareA = squareA;
		else
			this.squareA = defaultSquareA;
		if (squareB > 0)
			this.squareB = squareB;
		else
			this.squareB = defaultSquareB;
		this.center = p;
		this.normalType = normalType;
	}
	Oval2D(double squareA, double squareB, double x, double y, boolean normalType)
	{
		if (squareA > 0)
			this.squareA = squareA;
		else
			this.squareA = defaultSquareA;
		if (squareB > 0)
			this.squareB = squareB;
		else
			this.squareB = defaultSquareB;
		this.center = new Point2D(x, y);
		this.normalType = normalType;
	}
	Point2D getCenter()
	{
		return this.center;
	}
	void setCenter(double x, double y)
	{
		this.center.setCoordinate(x, y);
	}
	void setCenter(Point2D p)
	{
		this.center.setCoordinate(p);
	}
	double getA()
	{
		return Math.sqrt(this.squareA);
	}
	double getB()
	{
		return Math.sqrt(this.squareB);
	}
	double getSquareA()
	{
		return this.squareA;
	}
	double getSquareB()
	{
		return this.squareB;
	}
	double getC()//获取椭圆的半焦距
	{
		return Math.sqrt(this.squareA - this.squareB);
	}
	double getSquareC()//获取椭圆半焦距的平方
	{
		return this.squareA - this.squareB;
	}
	void setA(double a)
	{
		if (a > 0)
			this.squareA = a * a;
	}
	void setB(double b)
	{
		if (b > 0)
			this.squareB = b * b;
	}
	void setSquareA(double squareA)
	{
		if (squareA > 0)
			this.squareA = squareA;
	}
	void setSquareB(double squareB)
	{
		if (squareB > 0)
			this.squareB = squareB;
	}
	void setNormalType(boolean normalType)
	{
		this.normalType = normalType;
	}
	double getArea()
	{
		return Math.sqrt(this.squareA) * Math.sqrt(this.squareB) * pi;
	}
	double getPerimeter()//求周长
	{
		return 2 * Math.sqrt(squareB) * pi + 4 * (Math.sqrt(this.squareA) - Math.sqrt(this.squareB));
	}
	Point2D[] getFocus()//求焦点坐标
	{
		Point2D[] points = new Point2D[2];
		points[0] = new Point2D(this.getCenter().x + (this.normalType ? this.getC() : 0), this.getCenter().y + (this.normalType ? 0 : this.getC()));
		points[1] = new Point2D(this.getCenter().x - (this.normalType ? this.getC() : 0), this.getCenter().y - (this.normalType ? 0 : this.getC()));
		return points;
	}
	void move(double dX, double dY)//移动
	{
		this.center.move(dX, dY);
	}
	public String toString()//获取表达式（重载）
	{
		String expr = "";
		if (this.center.x > 0)
			expr += "(x-" + this.center.x + ")";
		else if (this.center.x < 0)
			expr += "(x+" + (-this.center.x) + ")";
		else
			expr += "x";
		expr += "^2/" + atoS(this.normalType ? this.squareA : this.squareB) + " + ";
		if (this.center.y > 0)
			expr += "(y-" + this.center.y + ")";
		else if (this.center.y < 0)
			expr += "(y+" + (-this.center.y) + ")";
		else
			expr += "y";
		expr += "^2/" + atoS(this.normalType ? this.squareB : this.squareA) + " = 1";
		return expr;
	}
}

class Curve2D extends G_2D//双曲线
{
	public static final String name = "平面双曲线";
	private double squareA;//半实轴的平方
	private double squareB;//半虚轴的平方
	private Point2D center;//中心
	private boolean normalType;//是否左右双曲线
	public static double pi = 3.1415926535;// pi
	public static final double defaultSquareA = 5, defaultSquareB = 4;
	Curve2D()
	{
		this.squareA = defaultSquareA;
		this.squareB = defaultSquareB;
		this.center = new Point2D(0, 0);
		this.normalType = true;
	}
	Curve2D(double squareA, double squareB, Point2D p, boolean normalType)
	{
		if (squareA > 0)
			this.squareA = squareA;
		else
			this.squareA = defaultSquareA;
		if (squareB > 0)
			this.squareB = squareB;
		else
			this.squareB = defaultSquareB;
		this.center = p;
		this.normalType = normalType;
	}
	Curve2D(double squareA, double squareB, double x, double y, boolean normalType)
	{
		if (squareA > 0)
			this.squareA = squareA;
		else
			this.squareA = defaultSquareA;
		if (squareB > 0)
			this.squareB = squareB;
		else
			this.squareB = defaultSquareB;
		this.center = new Point2D(x, y);
		this.normalType = normalType;
	}
	Point2D getCenter()
	{
		return this.center;
	}
	void setCenter(double x, double y)
	{
		this.center.setCoordinate(x, y);
	}
	void setCenter(Point2D p)
	{
		this.center.setCoordinate(p);
	}
	double getA()
	{
		return Math.sqrt(this.squareA);
	}
	double getB()
	{
		return Math.sqrt(this.squareB);
	}
	double getSquareA()
	{
		return this.squareA;
	}
	double getSquareB()
	{
		return this.squareB;
	}
	double getC()//获取双曲线的半焦距
	{
		return Math.sqrt(this.squareA + this.squareB);
	}
	double getSquareC()//获取双曲线半焦距的平方
	{
		return this.squareA + this.squareB;
	}
	void setA(double a)
	{
		if (a > 0)
			this.squareA = a * a;
	}
	void setB(double b)
	{
		if (b > 0)
			this.squareB = b * b;
	}
	void setSquareA(double squareA)
	{
		if (squareA > 0)
			this.squareA = squareA;
	}
	void setSquareB(double squareB)
	{
		if (squareB > 0)
			this.squareB = squareB;
	}
	void setNormalType(boolean normalType)
	{
		this.normalType = normalType;
	}
	Point2D[] getFocus()//求焦点坐标
	{
		Point2D[] points = new Point2D[2];
		points[0] = new Point2D(this.getCenter().x + (this.normalType ? this.getC() : 0), this.getCenter().y + (this.normalType ? 0 : this.getC()));
		points[1] = new Point2D(this.getCenter().x - (this.normalType ? this.getC() : 0), this.getCenter().y - (this.normalType ? 0 : this.getC()));
		return points;
	}
	void move(double dX, double dY)//移动
	{
		this.center.move(dX, dY);
	}
	public String toString()//获取表达式（重载）
	{
		String expr = "";
		if (this.normalType)
		{
			if (this.center.x > 0)
				expr += "(x-" + this.center.x + ")";
			else if (this.center.x < 0)
				expr += "(x+" + (-this.center.x) + ")";
			else
				expr += "x";
			expr += "^2/" + atoS(this.squareA) + " - ";
			if (this.center.y > 0)
				expr += "(y-" + this.center.y + ")";
			else if (this.center.y < 0)
				expr += "(y+" + (-this.center.y) + ")";
			else
				expr += "y";
			expr += "^2/" + atoS(this.normalType ? this.squareB : this.squareA) + " = 1";
		}
		else
		{
			if (this.center.y > 0)
				expr += "(y-" + this.center.y + ")";
			else if (this.center.y < 0)
				expr += "(y+" + (-this.center.y) + ")";
			else
				expr += "y";
			expr += "^2/" + atoS(this.squareA) + " - ";
			if (this.center.x > 0)
				expr += "(x-" + this.center.x + ")";
			else if (this.center.x < 0)
				expr += "(x+" + (-this.center.x) + ")";
			else
				expr += "x";
			expr += "^2/" + atoS(this.normalType ? this.squareB : this.squareA) + " = 1";
		}
		return expr;
	}
}

class Parabola2D extends G_2D//抛物线
{
	public static final String name = "平面抛物线";
	public double pp = 2;
	private Point2D center;//中心
	private boolean normalType;//是否常规横置的抛物线
	public static final double defaultP = 2;
	Parabola2D()
	{
		this.pp = defaultP;
		this.center = new Point2D(0, 0);
		this.normalType = true;
	}
	Parabola2D(double pp, Point2D p, boolean normalType)
	{
		if (pp > 0)
			this.pp = pp;
		else
			this.pp = defaultP;
		this.center = p;
		this.normalType = normalType;
	}
	Parabola2D(double pp, double x, double y, boolean normalType)
	{
		if (pp > 0)
			this.pp = pp;
		else
			this.pp = defaultP;
		this.center = new Point2D(x, y);
		this.normalType = normalType;
	}
	Point2D getCenter()
	{
		return this.center;
	}
	void setCenter(double x, double y)
	{
		this.center.setCoordinate(x, y);
	}
	void setCenter(Point2D p)
	{
		this.center.setCoordinate(p);
	}
	void setP(double pp)
	{
		if (this.pp > 0)
			this.pp = pp;
	}
	double getP()//获取抛物线的半焦距
	{
		return this.pp / 2;
	}
	void setNormalType(boolean normalType)
	{
		this.normalType = normalType;
	}
	Point2D getFocus()//求焦点坐标
	{
		Point2D p = new Point2D(this.center.x + this.pp / 2, this.center.y);
		return p;
	}
	void move(double dX, double dY)//移动
	{
		this.center.move(dX, dY);
	}
	public String toString()//获取表达式（重载）
	{
		if (this.normalType)
			return "y^2 = " + atoX(2 * this.pp) + "x";
		else
			return "x^2 = " + atoX(2 * this.pp) + "y";
	}
}



public class Graphics//主类
{
	public static void main(String[] args)
	{
		int num = 520, ber = 3344;
		System.out.println("欢迎来到数学天地！\n\n");
		
		System.out.println("首先来看一些数学运算：");
		System.out.println("(" + (-ber) + ") % " + num + " = " + MyMathFunction.mod(-ber, num));
		System.out.print(num + " 可被分解为：");
		MyMathFunction.printArr(MyMathFunction.factor(num));
		System.out.println((num >> 5) + " 的阶乘为：" + MyMathFunction.fact(num >> 5));
		System.out.print(ber + " 可被分解为：");
		MyMathFunction.printArr(MyMathFunction.factor(ber));
		System.out.println("1 到 " + ber + " 的累加和为：" + MyMathFunction.sum(ber));
		System.out.println("计算最大公因数：(" + num + ", " + ber + ") = " + MyMathFunction.gcd(num, ber));
		System.out.println("计算最小公倍数：[" + num + ", " + ber + "] = " + MyMathFunction.lcm(num, ber));
		System.out.print("拓展欧几里得算法：exgcd(" + num + ", " + ber + ") = ");
		PrintArr.printArr(MyMathFunction.exgcd(num, ber));
		System.out.println(num + ber + " 的真因子和为：" + MyMathFunction.sumfactor(Integer.parseInt(String.valueOf(num + "" + ber))));
		System.out.println("计算勒让德符号：lrd(" + ber + ", " + num + ") = " + MyMathFunction.lrd(ber, num));
		System.out.println("计算模平方剩余：modsq(" + num + ", " + 2 + ", " + ber + ") = " + MyMathFunction.modsq(num, 2, ber));
		System.out.println("求模指数：zm(" + 5 + ", " + 13 + ") = " + MyMathFunction.zm(5, 13));
		System.out.println(num + " 的欧拉数为：" + MyMathFunction.euler(num));
		System.out.print(17 + " 的原根为：");
		PrintArr.printArr(MyMathFunction.SeekRoot(17));
		System.out.println(num + " 对模 " + 17 + " 的模逆元为：" + MyMathFunction.arcmod(num, 17));
		System.out.println("求取 " + ber + "/" + num + " 的连分数为：" + MyMathFunction.lfs(ber, num));
		
		System.out.println("");
		System.out.println("然后看复平面运算：");
		Complex cp1 = new Complex(2, 6), cp2 = new Complex(4, 2);
		System.out.println("cp1 = " + cp1.toString());
		System.out.println("cp2 = " + cp2.toString());
		System.out.println("cp3 = cp1 + cp2 = (" + cp1.toString() + ") + (" + cp2.toString() + ") = " + cp1.addComplex(cp2).toString());
		System.out.println("cp3 = cp1 - cp2 = (" + cp1.toString() + ") - (" + cp2.toString() + ") = " + cp1.minComplex(cp2).toString());
		System.out.println("cp3 = cp1 * cp2 = (" + cp1.toString() + ") * (" + cp2.toString() + ") = " + cp1.mulComplex(cp2).toString());
		System.out.println("cp3 = cp1 / cp2 = (" + cp1.toString() + ") / (" + cp2.toString() + ") = " + cp1.divComplex(cp2).toString());
		
		System.out.println("");
		System.out.println("接着来看几何运算：");
		Point2D p1 = new Point2D(0, 0), p2 = new Point2D(0, 0), p3 = new Point2D(3, 0);
		Circle2D c1 = new Circle2D(1, p1), c2 = new Circle2D(3, p2), c3 = new Circle2D(2, p3);
		System.out.print("圆 c1 的方程为：");
		System.out.println(c1);
		System.out.print("圆 c2 的方程为：");
		System.out.println(c2);
		System.out.print("圆 c3 的方程为：");
		System.out.println(c3);
		System.out.println("c1 与 c2 不重叠部分的面积约为：" + (c2.getArea() - c1.getArea()));//同心圆相减
		if (c1.location(c3).contains("切"))
			System.out.println("c1 与 c3 相切！");
		else
			System.out.println("c1 与 c3 不相切！");
		Oval2D o = new Oval2D();
		System.out.print("椭圆 o 的方程为：");
		System.out.println(o);
		System.out.print("椭圆 o 的焦点为：");
		MyMathFunction.printArr(o.getFocus());
		Curve2D c = new Curve2D();
		System.out.print("双曲线 c 的方程为：");
		System.out.println(c);
		System.out.print("双曲线 c 的焦点为：");
		MyMathFunction.printArr(c.getFocus());
		Parabola2D pp = new Parabola2D();
		System.out.print("抛物线 pp 的方程为：");
		System.out.println(pp);
		System.out.print("抛物线 pp 的焦点为：");
		System.out.println(pp.getFocus());
		
		System.out.println("");
		System.out.println("最后出场的是日历的运算：");
		System.out.println("今天是：" + Date.getToday().toString());
		Date date1 = new Date(2000, 11, 19), date2 = new Date();
		System.out.println("我的生日是：" + date1.toString() + "，今年 " + date1.getAge() + " 岁啦！");
		System.out.print("该天是当年的第 " + date1.dayofYear() + " 天，");
		System.out.println("该日期比 " + date2.toString() + " 早 " + date1.distance(date2) + " 天。");
		System.out.println("\n\n\n演示结束，欢迎再次光临数学天地！");
		return;
	}
}