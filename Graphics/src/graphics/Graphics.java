package graphics;
import java.util.Calendar;

/**
  * ����һ��������Ϣ��ȫ��ѧ���������ƽ��������ϵĳ���
 * @author Batch Clayderman
 *
  * Ŀǰ��֧�֣�
 * 	һЩ��ѧӦ��
 * 	��ƽ��
 * 	��
 * 	Բ
 * 	��Բ
 * 	˫����
 * 	������
 * 	����
 */


interface DynamicType//����̬����ӿ�
{
	public static final String name = "����̬������";
	public int[] getArr();
	public void setArr(int[] arr);
	public int getLength();
	public void setLength(int length);
	public void append(int a);
	public int IntAt(int i);
	public String toString();
}

class Int implements DynamicType//��̬ int ������
{
	public static final String name = "��̬ int ������";
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

class PrintArr//��ӡ������
{
	public static final String name = "��ӡ������";
	static void printArr(int[] Arr)//��ӡ int ����
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(int[] Arr, String startText, String endText, String delineText)//��ӡ int ����
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static void printArr(double[] Arr)//��ӡ double ����
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(double[] Arr, String startText, String endText, String delineText)//��ӡ double ����
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static void printArr(long[] Arr)//��ӡ long ����
	{
		printArr(Arr, "[", "]", ", ");
	}
	static void printArr(long[] Arr, String startText, String endText, String delineText)//��ӡ long ����
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
	static String stringINVar(String s)//ת��˫����
	{
		for (int i = 0; i < s.length(); ++i)
			if (s.charAt(i) == '\"')//�� " ��Ϊ \"
			{
				s = s.substring(0, i) + "\\" + s.substring(i);
				i++;
			}
		return "\"" + s + "\"";
	}
	static void printArr(String[] Arr)//��ӡ�ַ�������
	{
		if (Arr.length <= 0)
			return;
		System.out.print("[" + stringINVar(Arr[0]));
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(", " + stringINVar(Arr[i]));
		System.out.println("]");
	}
	static void printArr(Point2D[] Arr)//��ӡ����������
	{
		printArr(Arr, "", "", "");
	}
	static void printArr(Point2D[] Arr, String startText, String endText, String delineText)//��ӡ long ����
	{
		if (Arr.length <= 0)
			return;
		System.out.print(startText + Arr[0]);
		for (int i = 1; i < Arr.length; ++i)
			System.out.print(delineText + Arr[i]);
		System.out.println(endText);
	}
}


class MyMathFunction extends PrintArr//��ѧӦ����
{
	public static final String name = "��ѧӦ����";
	public static final int EOF = (-1);
	static int mod(int a, int b)//ȡ����
	{
		if (b <= 0)
			return EOF;
		if (a < 0)
		{
			int k = (int)(a / b);//ȡ����
			a -= (k - 1) * b;//ʹ�� a Ϊ����
		}
		return a % b;
	}
	static long mod(long a, long b)//ȡ����
	{
		if (b <= 0)
			return EOF;
		if (a < 0)
		{
			long k = (long)(a / b);//ȡ����
			a -= (k - 1) * b;//ʹ�� a Ϊ����
		}
		return a % b;
	}
	static long power(long a, long b)//��ָ��
	{
		long result = 1;
		for (int i = 0; i < b; ++i)
			result *= a;
		return result;
	}
	
	static boolean isPrime(int n)//�ж��Ƿ�Ϊ����
	{
		for (int i = 2; i <= (int)Math.sqrt(n); ++i)
			if (n % i == 0)
				return false;
		return true;
	}
	static long sum(long n)//���
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
	static long sum(int[] n)//���
	{
		long sum = 0;
		for (int a : n)
			sum += a;
		return sum;
	}
	static long fact(long n)//��׳�
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
	static int[] factor(int n)//�ֽ���ʽ
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
	static int gcd(int a, int b)//���������
	{
		if (a < 0 || b < 0)
			return EOF;//�쳣ֵ
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a < b)//�� a ���
		{
            int temp = a;
            a = b;
            b = temp;
        }
		int k = a % b;
        if (k != 0)
            return gcd(b, k);//�ٴ�ѭ��
        return b;
	}
	static int lcm(int a, int b)//����С������
	{
		if (a < 0 || b < 0)
			return EOF;//�쳣ֵ
		if (a == 0 || b == 0)// 0 ���κ����ı���
			return 0;
		if (a < b)//�� a ���
		{
            int temp = a;
            a = b;
            b = temp;
        }
		int cd = gcd(a, b);//ȡ�������
        return (int)(a / cd) * (int)(b / cd);
	}
	static String[] exgcd(int p, int q)//��չŷ����ó���
	{
		String[] result = new String[2];
		if (p == 0 && q != 0)
		{
			result[0] = "��������";
			result[1] = "1";
			return result;
		}
		else if (q == 0 && p != 0)
		{
			result[0] = "1";
			result[1] = "��������";
			return result;
		}
		else if (p == 0 && q == 0)
		{
			result[0] = "��������";
			result[1] = "��������";
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
	static int sumfactor(int n)//����֮�ͣ���������
	{
		int sum = 0;
		for (int i = 1; i < n; ++i)
			if (n % i == 0)
				sum += i;
		return sum;
	}
	static int lrd(int p1, int p2)//���õ·���
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
	static long modsq(long x, long n, long m)//ģƽ��ʣ��
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
			for (;;)//��������ѭ��
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
			for (;;)//��������ѭ��
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
	static int euler(int x)//ŷ������
	{
		if (x <= 1)
			return EOF;
		int count = 0;
		for (int i = 1; i < x; ++i)
			if (gcd(x, i) == 1)
				count++;
		return count;
	}
	static int order(int a, int n, int b)// order ����
	{
		int p = 1;
		while (p <= n && (power(b, p) % a != 1))
			p++;
		if (p <= n)
			return p;
		else
			return EOF;
	}
	static int[] SeekRoot(int a)//��ԭ��
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
	static int[] tmpArcmod(int a, int b)//����Ԫ�ݹ鲿��
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
	static int arcmod(int a, int b)//����Ԫ
	{
		if (gcd(a, b) != 1)
			return EOF;
		int[] ttmp = tmpArcmod(a, b);
		return mod(ttmp[0], b);
	}
	static Int lfs(int p1, int p2)//������
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


class Date//������
{
	public static final String name = "����"; 
	private int year, month, day;//������
	public static final int defaultYear = 2002;
	public static final int defaultMonth = 7;
	public static final int defaultDay = 6;
	public static final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//����
	public static final int[] smallMonth = {4, 6, 9, 11};//С��
	public static final String[] Weekdays = {"һ", "��", "��", "��", "��", "��", "��"};
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
		final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//����
		final int[] smallMonth = {4, 6, 9, 11};//С��
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
		else//��������
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
	
	int dayofYear()//һ���еĵڼ���
	{
		int days = 0;
		if (!isRightDate(this.year, this.month, this.day))//���������
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
	int getAge()//��ȡ����
	{
		Date today = getToday();
		if (this.equals(today))
			return 0;
		if (getEarly(this, today).equals(today))
			return EOF;
		int age = today.year - this.year;
		Date toyearBirth = new Date(today.year, this.month, this.day);//��������յ���û
		if (!getLater(today, toyearBirth).equals(today))//û����һ
			age--;
		return age;
	}
	public static Date getToday()//����
	{
		Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
		int yy = c.get(Calendar.YEAR);//����
		int mm = c.get(Calendar.MONTH) + 1;//���£��ǵ� +1��
		int dd = c.get(Calendar.DATE);//����
		Date today = new Date(yy, mm, dd);
		return today;
	}
	public static int getWeekday(int y, int m ,int d)//��ȡ������
	{
		if (!isRightDate(y, m, d))
			return EOF;
		if (1 == m || 2 == m)
		{
			m += 12;
			--y;
		}
		//public static final String[] Weekdays = {"һ", "��", "��", "��", "��", "��", "��"};
		return (d + (m << 1) + 3 * (m + 1) / 5 + y + (y >> 2) - y / 100 + y / 400) % 7;
	}
	public static int getWeekday(Date date)//��ȡ������
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
			y += (int)(m / 12);//һ��ʮ����
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
	int distance(Date date)//���������
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
	int distance(int year, int month, int day)//���������
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
	public boolean equals(Date date)//����
	{
		return (this.year == date.year && this.month == date.month && this.day == date.day);
	}
	public String toString()//����
	{
		return this.year + " �� " + this.month + " �� " + this.day + " ������" + Weekdays[getWeekday(this)];
	}
}


class G_2D//ƽ��ͼ�λ���
{
	public static final String name = "ƽ��ͼ��";
	public static String getName()
	{ 
		return name;
	}
	public static String atoS(double a)//�൱�� C/C++ �е� %g
	{
		if (a == (int)(a))
			return "" + (int)(a);
		else
			return "" + a;
	}
	public static String atoX(double a)//ϵ�����ų� 1��
	{
		if (a == 1)
			return "";
		else if (a == (int)(a))
			return "" + (int)(a);
		else
			return "" + a;
	}
	public String toString()//��̬
	{
		return name;
	}
}

class Complex extends G_2D//��ƽ����
{
	public static final String name = "��ƽ����";
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
	public Complex addComplex(Complex c)//���
	{
		double real = this.realPart + c.realPart;
		double imagine = this.imaginePart + c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex minComplex(Complex c)//���
	{
		double real = this.realPart - c.realPart;
		double imagine = this.imaginePart - c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex mulComplex(Complex c)//���
	{
		double real = this.realPart * c.realPart - this.imaginePart * c.imaginePart;//ע�� i * i = -1
		double imagine = this.imaginePart * c.realPart + this.realPart * c.imaginePart;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex divComplex(Complex c)//���
	{
		double real = this.realPart * c.realPart + this.imaginePart * c.imaginePart;//ע�� i * i = -1
		double imagine = this.imaginePart * c.realPart - this.realPart * c.imaginePart;//����ƽ���ʽ��ĸʵ����
		double T = c.getSquareT();//��ģ����ƽ��
		real /= T;
		imagine /= T;
		Complex result = new Complex(real, imagine);
		return result;
	}
	public Complex conjugate()//�����
	{
		Complex result = new Complex(this.realPart, -this.imaginePart);
		return result;
	}
	public static Complex conjugate(Complex c)
	{
		Complex result = new Complex(c.realPart, -c.imaginePart);
		return result;
	}
	public double getT()//��ģ��
	{
		return Math.sqrt(this.realPart * this.realPart + this.imaginePart + this.imaginePart);
	}
	public double getSquareT()//��ģƽ��
	{
		return this.realPart * this.realPart + this.imaginePart + this.imaginePart;
	}
	public static double getT(Complex c)//��ģ��
	{
		return Math.sqrt(c.realPart * c.realPart + c.imaginePart + c.imaginePart);
	}
	public static double getSquareT(Complex c)//��ģƽ��
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

class Point2D extends G_2D//��άƽ���ϵĵ�
{
	public static final String name = "��άƽ��";
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
	public void setCoordinate(double x, double y)//��������
	{
		this.x = x;
		this.y = y;
	}
	public void setCoordinate(Point2D p)//��������
	{
		this.x = p.x;
		this.y = p.y;
	}
	public double distance()//����ԭ��ľ���
	{
		return Math.sqrt(this.x * this.x + this.y * this.y); 
	}
	public double distance(Point2D p)//����� p �ľ���
	{
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}
	public boolean equals(Point2D p)//�Ƿ����
	{
		if (this.x == p.x && this.y == p.y)
			return true;
		else
			return false;
	}
	public boolean equals(double x, double y)//�Ƿ����
	{
		if (this.x == x && this.y == y)
			return true;
		else
			return false;
	}
	public static boolean equals(Point2D p1, Point2D p2)//�Ƿ����
	{
		if (p1.x == p2.x && p1.y == p2.y)
			return true;
		else
			return false;
	}
	public static boolean equals(double x1, double y1, double x2, double y2)//�Ƿ����
	{
		if (x1 == x2 && y1 == y2)
			return true;
		else
			return false;
	}
	static double distance(Point2D p1, Point2D p2)//���������
	{
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));	
	}
	void move(double dX, double dY)//�ƶ�
	{
		this.x += dX;
		this.y += dY;
		return;
	}
	public String toString()//����
	{
		return "(" + atoS(this.x) + ", " + atoS(this.y) + ")";
	}
}

class Circle2D extends G_2D//Բ
{
	public static final String name = "ƽ��Բ";
	private double radius;//�뾶
	private Point2D center;//Բ��
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
				return "�غ�";
			else
				return "��Ϊͬ��Բ";
		}
		else if (this.center.distance(c.center) > this.radius + c.radius)
			return "����";
		else if (this.center.distance(c.center) == this.radius + c.radius)
			return "����";
		else if (this.center.distance(c.center) == Math.abs(this.radius - c.radius))
			return "����";
		else if (this.center.distance(c.center) < Math.abs(this.radius - c.radius))
			return "�ں�";
		else
			return "�ཻ";
	}
	public String toString()//��ȡ���ʽ�����أ�
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

class Oval2D extends G_2D//��Բ
{
	public static final String name = "ƽ����Բ";
	private double squareA;//�볤���ƽ��
	private double squareB;//������ƽ��
	private Point2D center;//����
	private boolean normalType;//�Ƿ񳣹���õ���Բ
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
	double getC()//��ȡ��Բ�İ뽹��
	{
		return Math.sqrt(this.squareA - this.squareB);
	}
	double getSquareC()//��ȡ��Բ�뽹���ƽ��
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
	double getPerimeter()//���ܳ�
	{
		return 2 * Math.sqrt(squareB) * pi + 4 * (Math.sqrt(this.squareA) - Math.sqrt(this.squareB));
	}
	Point2D[] getFocus()//�󽹵�����
	{
		Point2D[] points = new Point2D[2];
		points[0] = new Point2D(this.getCenter().x + (this.normalType ? this.getC() : 0), this.getCenter().y + (this.normalType ? 0 : this.getC()));
		points[1] = new Point2D(this.getCenter().x - (this.normalType ? this.getC() : 0), this.getCenter().y - (this.normalType ? 0 : this.getC()));
		return points;
	}
	void move(double dX, double dY)//�ƶ�
	{
		this.center.move(dX, dY);
	}
	public String toString()//��ȡ���ʽ�����أ�
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

class Curve2D extends G_2D//˫����
{
	public static final String name = "ƽ��˫����";
	private double squareA;//��ʵ���ƽ��
	private double squareB;//�������ƽ��
	private Point2D center;//����
	private boolean normalType;//�Ƿ�����˫����
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
	double getC()//��ȡ˫���ߵİ뽹��
	{
		return Math.sqrt(this.squareA + this.squareB);
	}
	double getSquareC()//��ȡ˫���߰뽹���ƽ��
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
	Point2D[] getFocus()//�󽹵�����
	{
		Point2D[] points = new Point2D[2];
		points[0] = new Point2D(this.getCenter().x + (this.normalType ? this.getC() : 0), this.getCenter().y + (this.normalType ? 0 : this.getC()));
		points[1] = new Point2D(this.getCenter().x - (this.normalType ? this.getC() : 0), this.getCenter().y - (this.normalType ? 0 : this.getC()));
		return points;
	}
	void move(double dX, double dY)//�ƶ�
	{
		this.center.move(dX, dY);
	}
	public String toString()//��ȡ���ʽ�����أ�
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

class Parabola2D extends G_2D//������
{
	public static final String name = "ƽ��������";
	public double pp = 2;
	private Point2D center;//����
	private boolean normalType;//�Ƿ񳣹���õ�������
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
	double getP()//��ȡ�����ߵİ뽹��
	{
		return this.pp / 2;
	}
	void setNormalType(boolean normalType)
	{
		this.normalType = normalType;
	}
	Point2D getFocus()//�󽹵�����
	{
		Point2D p = new Point2D(this.center.x + this.pp / 2, this.center.y);
		return p;
	}
	void move(double dX, double dY)//�ƶ�
	{
		this.center.move(dX, dY);
	}
	public String toString()//��ȡ���ʽ�����أ�
	{
		if (this.normalType)
			return "y^2 = " + atoX(2 * this.pp) + "x";
		else
			return "x^2 = " + atoX(2 * this.pp) + "y";
	}
}



public class Graphics//����
{
	public static void main(String[] args)
	{
		int num = 520, ber = 3344;
		System.out.println("��ӭ������ѧ��أ�\n\n");
		
		System.out.println("��������һЩ��ѧ���㣺");
		System.out.println("(" + (-ber) + ") % " + num + " = " + MyMathFunction.mod(-ber, num));
		System.out.print(num + " �ɱ��ֽ�Ϊ��");
		MyMathFunction.printArr(MyMathFunction.factor(num));
		System.out.println((num >> 5) + " �Ľ׳�Ϊ��" + MyMathFunction.fact(num >> 5));
		System.out.print(ber + " �ɱ��ֽ�Ϊ��");
		MyMathFunction.printArr(MyMathFunction.factor(ber));
		System.out.println("1 �� " + ber + " ���ۼӺ�Ϊ��" + MyMathFunction.sum(ber));
		System.out.println("�������������(" + num + ", " + ber + ") = " + MyMathFunction.gcd(num, ber));
		System.out.println("������С��������[" + num + ", " + ber + "] = " + MyMathFunction.lcm(num, ber));
		System.out.print("��չŷ������㷨��exgcd(" + num + ", " + ber + ") = ");
		PrintArr.printArr(MyMathFunction.exgcd(num, ber));
		System.out.println(num + ber + " �������Ӻ�Ϊ��" + MyMathFunction.sumfactor(Integer.parseInt(String.valueOf(num + "" + ber))));
		System.out.println("�������õ·��ţ�lrd(" + ber + ", " + num + ") = " + MyMathFunction.lrd(ber, num));
		System.out.println("����ģƽ��ʣ�ࣺmodsq(" + num + ", " + 2 + ", " + ber + ") = " + MyMathFunction.modsq(num, 2, ber));
		System.out.println("��ģָ����zm(" + 5 + ", " + 13 + ") = " + MyMathFunction.zm(5, 13));
		System.out.println(num + " ��ŷ����Ϊ��" + MyMathFunction.euler(num));
		System.out.print(17 + " ��ԭ��Ϊ��");
		PrintArr.printArr(MyMathFunction.SeekRoot(17));
		System.out.println(num + " ��ģ " + 17 + " ��ģ��ԪΪ��" + MyMathFunction.arcmod(num, 17));
		System.out.println("��ȡ " + ber + "/" + num + " ��������Ϊ��" + MyMathFunction.lfs(ber, num));
		
		System.out.println("");
		System.out.println("Ȼ�󿴸�ƽ�����㣺");
		Complex cp1 = new Complex(2, 6), cp2 = new Complex(4, 2);
		System.out.println("cp1 = " + cp1.toString());
		System.out.println("cp2 = " + cp2.toString());
		System.out.println("cp3 = cp1 + cp2 = (" + cp1.toString() + ") + (" + cp2.toString() + ") = " + cp1.addComplex(cp2).toString());
		System.out.println("cp3 = cp1 - cp2 = (" + cp1.toString() + ") - (" + cp2.toString() + ") = " + cp1.minComplex(cp2).toString());
		System.out.println("cp3 = cp1 * cp2 = (" + cp1.toString() + ") * (" + cp2.toString() + ") = " + cp1.mulComplex(cp2).toString());
		System.out.println("cp3 = cp1 / cp2 = (" + cp1.toString() + ") / (" + cp2.toString() + ") = " + cp1.divComplex(cp2).toString());
		
		System.out.println("");
		System.out.println("���������������㣺");
		Point2D p1 = new Point2D(0, 0), p2 = new Point2D(0, 0), p3 = new Point2D(3, 0);
		Circle2D c1 = new Circle2D(1, p1), c2 = new Circle2D(3, p2), c3 = new Circle2D(2, p3);
		System.out.print("Բ c1 �ķ���Ϊ��");
		System.out.println(c1);
		System.out.print("Բ c2 �ķ���Ϊ��");
		System.out.println(c2);
		System.out.print("Բ c3 �ķ���Ϊ��");
		System.out.println(c3);
		System.out.println("c1 �� c2 ���ص����ֵ����ԼΪ��" + (c2.getArea() - c1.getArea()));//ͬ��Բ���
		if (c1.location(c3).contains("��"))
			System.out.println("c1 �� c3 ���У�");
		else
			System.out.println("c1 �� c3 �����У�");
		Oval2D o = new Oval2D();
		System.out.print("��Բ o �ķ���Ϊ��");
		System.out.println(o);
		System.out.print("��Բ o �Ľ���Ϊ��");
		MyMathFunction.printArr(o.getFocus());
		Curve2D c = new Curve2D();
		System.out.print("˫���� c �ķ���Ϊ��");
		System.out.println(c);
		System.out.print("˫���� c �Ľ���Ϊ��");
		MyMathFunction.printArr(c.getFocus());
		Parabola2D pp = new Parabola2D();
		System.out.print("������ pp �ķ���Ϊ��");
		System.out.println(pp);
		System.out.print("������ pp �Ľ���Ϊ��");
		System.out.println(pp.getFocus());
		
		System.out.println("");
		System.out.println("�������������������㣺");
		System.out.println("�����ǣ�" + Date.getToday().toString());
		Date date1 = new Date(2000, 11, 19), date2 = new Date();
		System.out.println("�ҵ������ǣ�" + date1.toString() + "������ " + date1.getAge() + " ������");
		System.out.print("�����ǵ���ĵ� " + date1.dayofYear() + " �죬");
		System.out.println("�����ڱ� " + date2.toString() + " �� " + date1.distance(date2) + " �졣");
		System.out.println("\n\n\n��ʾ��������ӭ�ٴι�����ѧ��أ�");
		return;
	}
}