package ex451;

class Student
{
	public String name;
	public int age;
	public Student(String name, int age)
	{
		if (age < 0 || age > 150)
			return;
		this.name = name;
		this.age = age;
	}
	public void show()
	{
		System.out.println("������" + name + "\t���䣺" + age);
	}
}

class UnderGraduate extends Student
{
	public String degree;
	public UnderGraduate(String name, int age, String degree)
	{
		super(name, age);//���ø���� Student
		this.degree = degree;
	}
	public void show()
	{
		System.out.println("������" + name + "\t���䣺" + age + "\t\tѧ����" + degree);
	}
}


public class Ex451
{
	public static void main(String[] args)
	{
		Student student = new Student("��U��", 19);
		student.show();
		UnderGraduate underGraduate = new UnderGraduate("��U��", 19, "����");
		underGraduate.show();
		return;
	}
}