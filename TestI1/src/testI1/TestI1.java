package testI1;

class Circle
{
	//private float Radius;//Բ�İ뾶
	private double Radius;//Բ�İ뾶
	public static final float defaultRadius = 5;//Ĭ��Բ�İ뾶
	public Circle()
	{
		this.Radius = defaultRadius;
	}
	public Circle(float r)
	{
		this.Radius = r;
	}
	double getPerimeter()//����Բ���ܳ�
	{
		return this.Radius * 2 * Math.PI;
	}
	double getArea()//����Բ�����
	{
		return this.Radius * this.Radius * Math.PI;
	}
	void show()
	{
		System.out.print(this);
	}
	public String toString()//�����ַ���
	{
		String s = "Բ�İ뾶��" + this.Radius + "\n";
		s += "Բ���ܳ���" + this.getPerimeter() + "\n";
		s += "Բ�����" + this.getArea() + "\n";
		return s;
	}
}

class Cylinder extends Circle
{
	private double height;//Բ���ĸ�
	private double Radius;//Բ���İ뾶
	public static final float defaultHeight = 10;//Ĭ��Բ���ĸ�
	public Cylinder()
	{
		this.height = defaultHeight;
		this.Radius = defaultRadius;
	}
	public Cylinder(double r, double h)
	{
		this.height = h;
		this.Radius = r;
	}
	double getVolume()//����Բ�������
	{
		return this.getArea() * this.height;
	}
	double getSurfaceArea()//����Բ����ı����
	{
		return this.getArea() * 2 + 2 * Math.PI * this.Radius * this.height;
	}
	void show()
	{
		System.out.print(this);
	}
	public String toString()//�����ַ���
	{
		String s = "Բ���ĸߣ�" + this.height + "\n";
		s += "Բ���������" + this.getVolume() + "\n";
		s += "Բ���ı����" + this.getSurfaceArea() + "\n";
		return s;
	}
}


public class TestI1
{
	public static void main(String[] args)
	{
		Circle c = new Circle(5);
		c.show();
		System.out.println("");
		Cylinder cc = new Cylinder(5, 10);
		cc.show();
		return;
	}
}