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
		System.out.println("姓名：" + name + "\t年龄：" + age);
	}
}

class UnderGraduate extends Student
{
	public String degree;
	public UnderGraduate(String name, int age, String degree)
	{
		super(name, age);//调用父类的 Student
		this.degree = degree;
	}
	public void show()
	{
		System.out.println("姓名：" + name + "\t年龄：" + age + "\t\t学历：" + degree);
	}
}


public class Ex451
{
	public static void main(String[] args)
	{
		Student student = new Student("杨淯而", 19);
		student.show();
		UnderGraduate underGraduate = new UnderGraduate("杨淯而", 19, "本科");
		underGraduate.show();
		return;
	}
}