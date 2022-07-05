package testG1;

class Student
{
	private String xh;
	private String xm;
	private String xb;
	private int nl;
	Student(String xh, String xm, String xb, int nl)
	{
		this.xh = xh;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
	}
	String getNo()//返回学号
	{
		return this.xh;
	}
	String getName()//返回姓名
	{
		return this.xm;
	}
	String getSex()//返回性别
	{
		return this.xb;
	}
	int getAge()//返回年龄
	{
		return this.nl;
	}
	public String toString()//返回组合
	{
		return this.xh + this.xm  + this.xb + this.nl;
	}
}

public class TestG1
{
	public static void main(String[] args)
	{
		Student[] st = new Student[5];
		st[0] = new Student("09zc01", "张三", "男", 19);
		st[1] = new Student("09zc02", "李四", "男", 20);
		st[2] = new Student("09zc03", "王五", "女", 18);
		st[3] = new Student("09zc04", "赵六", "男", 17);
		st[4] = new Student("09zc05", "杨七", "女", 21);
		for(int i = 0; i < st.length - 1; ++i)
            for(int j = 0; j < st.length - 1 - i; ++j)
                if (st[j].getSex().compareTo(st[j + 1].getSex()) > 0)
                {
                    Student temp = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = temp;
                }
		int girls = 0;
		for (Student s : st)
		{
			if (s.getSex().equals("女".compareTo("男") > 0 ? "男" : "女"))
				girls++;
		}
		for (int i = 0; i < girls - 1; ++i)
            for(int j = 0; j < girls - 1 - i; ++j)
                if (st[j].getAge() > st[j + 1].getAge())
                {
                    Student temp = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = temp;
                }
		for (int i = girls; i < st.length - 1; ++i)
            for(int j = girls; j < st.length - 1 - i + girls; ++j)
            	if (st[j].getAge() > st[j + 1].getAge())
                {
                    Student temp = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = temp;
                }
		for (Student s : st)
			System.out.println(s.toString());
	}
}