package testI1;

class Circle
{
	//private float Radius;//圆的半径
	private double Radius;//圆的半径
	public static final float defaultRadius = 5;//默认圆的半径
	public Circle()
	{
		this.Radius = defaultRadius;
	}
	public Circle(float r)
	{
		this.Radius = r;
	}
	double getPerimeter()//返回圆的周长
	{
		return this.Radius * 2 * Math.PI;
	}
	double getArea()//返回圆的面积
	{
		return this.Radius * this.Radius * Math.PI;
	}
	void show()
	{
		System.out.print(this);
	}
	public String toString()//重载字符串
	{
		String s = "圆的半径：" + this.Radius + "\n";
		s += "圆的周长：" + this.getPerimeter() + "\n";
		s += "圆的面积" + this.getArea() + "\n";
		return s;
	}
}

class Cylinder extends Circle
{
	private double height;//圆柱的高
	private double Radius;//圆柱的半径
	public static final float defaultHeight = 10;//默认圆柱的高
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
	double getVolume()//返回圆柱的体积
	{
		return this.getArea() * this.height;
	}
	double getSurfaceArea()//返回圆柱体的表面积
	{
		return this.getArea() * 2 + 2 * Math.PI * this.Radius * this.height;
	}
	void show()
	{
		System.out.print(this);
	}
	public String toString()//重载字符串
	{
		String s = "圆柱的高：" + this.height + "\n";
		s += "圆柱的体积：" + this.getVolume() + "\n";
		s += "圆柱的表面积" + this.getSurfaceArea() + "\n";
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