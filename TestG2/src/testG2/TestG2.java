package testG2;

class Point2D
{
	double x, y;
	Point2D()
	{
		this.x = 0;
		this.y = 0;
	}
	Point2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public void setCoordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public void setCoordinate(Point2D P)
	{
		this.x = P.x;
		this.y = P.y;
	}
	public double distance()
	{
		return Math.sqrt(this.x * this.x + this.y * this.y); 
	}
	public double distance(Point2D p)
	{
		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
	}
	static double distance(Point2D p1, Point2D p2)
	{
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));	
	}
	void move(double dX, double dY)
	{
		this.x += dX;
		this.y += dY;
		return;
	}
}

class Circle2D
{
	private double radius;//半径
	private Point2D center;//圆心
	public double pi = 3.1415926535;// pi
	Circle2D()
	{
		this.radius = 1;
		this.center = new Point2D(0, 0);
	}
	Circle2D(double r, Point2D p)
	{
		this.radius = r;
		this.center = p;
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
}

public class TestG2
{
	public static void main(String[] args)
	{
		Point2D p1 = new Point2D(0, 0), p2 = new Point2D(0, 0), p3 = new Point2D(3, 0);
		Circle2D c1 = new Circle2D(1, p1), c2 = new Circle2D(3, p2), c3 = new Circle2D(2, p3);
		System.out.println("c1 与 c2 不重叠部分的面积约为：" + (c2.getArea() - c1.getArea()));//同心圆相减
		if (c1.getCenter().distance(c3.getCenter()) == c1.getRadius() + c3.getRadius())
			System.out.println("c1 与 c3 相切！");
		else
			System.out.println("c1 与 c3 不相切！");
		return;
	}
}