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
	String getNo()//����ѧ��
	{
		return this.xh;
	}
	String getName()//��������
	{
		return this.xm;
	}
	String getSex()//�����Ա�
	{
		return this.xb;
	}
	int getAge()//��������
	{
		return this.nl;
	}
	public String toString()//�������
	{
		return this.xh + this.xm  + this.xb + this.nl;
	}
}

public class TestG1
{
	public static void main(String[] args)
	{
		Student[] st = new Student[5];
		st[0] = new Student("09zc01", "����", "��", 19);
		st[1] = new Student("09zc02", "����", "��", 20);
		st[2] = new Student("09zc03", "����", "Ů", 18);
		st[3] = new Student("09zc04", "����", "��", 17);
		st[4] = new Student("09zc05", "����", "Ů", 21);
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
			if (s.getSex().equals("Ů".compareTo("��") > 0 ? "��" : "Ů"))
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