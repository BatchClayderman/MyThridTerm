package ex351;

class Student
{
	private String name;
	private double grade;
	public Student() {}
	public Student(String name, double grade)//����
	{
		this.name = name;
		this.grade = grade;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getGrade()
	{
		return grade;
	}
	public void setGrade(double grade)
	{
		if (grade < 0 || grade > 100)
			return;
		this.grade = grade;
	}
}

public class Ex351
{
	public static void main(String[] args)
	{
		Student stu1 = new Student();//�޲ι���
		stu1.setName("myName");
		stu1.setGrade(98.0);
		System.out.println("������" + stu1.getName());
		System.out.println("�ɼ���" + stu1.getGrade());
		System.out.println("");
		Student stu2 = new Student("myName", 98.0);//���ι���
		System.out.println("������" + stu2.getName());
		System.out.println("�ɼ���" + stu2.getGrade());
		return;
	}
}