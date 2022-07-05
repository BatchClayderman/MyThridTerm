package testF3;

class Date
{
	private int year;
	private int month;
	private int day;
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
			this.year = 2002;
			this.month = 7;
			this.day = 6;
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
	
	int dayofYear()
	{
		final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//大月
		final int[] smallMonth = {4, 6, 9, 11};//小月
		int days = 0;
		if (!isRightDate(this.year, this.month, this.day))//错误的日期
			return -1;
		for (int i = 1; i <= this.month; ++i)
			if (isInArray(i, bigMonth))
				days += 31;
			else if (isInArray(i, smallMonth))
				days += 30;
			else if (i == 2)
				days += (isLeapyear(this.year) ? 29 : 28);
		return days;
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
		final int[] bigMonth = {1, 3, 5, 7, 8, 10, 12};//大月
		final int[] smallMonth = {4, 6, 9, 11};//小月
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
	public String toString()
	{
		return this.year + "-" + this.month + "-" + this.day;
	}
}

public class TestF3
{
	public static void main(String[] args)
	{
		Date date = new Date(2019, 10, 31);
		System.out.println(date.toString());
		System.out.println(date.dayofYear());
		date.addDays(1000);
		System.out.println(date.toString());
		return;
	}
}