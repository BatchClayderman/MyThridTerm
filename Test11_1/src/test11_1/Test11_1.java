package test11_1;

import java.util.Date;


class GeometricObject
{
	private String color = "white";
	private boolean filled = false;
	private Date dateCreated;
	
	public GeometricObject()
	{
		dateCreated = new Date();
	}
	
	public GeometricObject(String color, boolean filled)
	{
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	public Date getDateCreated()
	{
		return dateCreated;
	}
	
	public String toString()
	{
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
}

class Triangle extends GeometricObject
{
	private double side1 = 1, side2 = 1, side3 = 1;
	
	public Triangle()
	{
		
	}
	
	public Triangle(double side1, double side2, double side3)
	{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public Triangle(float side1, float side2, float side3)
	{
		this.side1 = (double)side1;
		this.side2 = (double)side2;
		this.side3 = (double)side3;
	}
	
	public Triangle(int side1, int side2, int side3)
	{
		this.side1 = (double)side1;
		this.side2 = (double)side2;
		this.side3 = (double)side3;
	}
	
	public Triangle(long side1, long side2, long side3)
	{
		this.side1 = (double)side1;
		this.side2 = (double)side2;
		this.side3 = (double)side3;
	}

	public double getSide1()
	{
		return this.side1;
	}

	public void setSide1(double side1)
	{
		this.side1 = side1;
	}
	
	public void setSide1(float side1)
	{
		this.side1 = (double)side1;
	}
	
	public void setSide1(int side1)
	{
		this.side1 = (double)side1;
	}
	
	public void setSide1(long side1)
	{
		this.side1 = (double)side1;
	}

	public double getSide2()
	{
		return this.side2;
	}

	public void setSide2(double side2)
	{
		this.side2 = side2;
	}
	
	public void setSide2(float side2)
	{
		this.side2 = (double)side2;
	}
	
	public void setSide2(int side2)
	{
		this.side2 = (double)side2;
	}
	
	public void setSide2(long side2)
	{
		this.side2 = (double)side2;
	}

	public double getSide3()
	{
		return this.side3;
	}

	public void setSide3(double side3)
	{
		this.side3 = side3;
	}
	
	public void setSide3(float side3)
	{
		this.side3 = (double)side3;
	}
	
	public void setSide3(int side3)
	{
		this.side3 = (double)side3;
	}
	
	public void setSide3(long side3)
	{
		this.side3 = (double)side3;
	}
	
	public double getArea()
	{
		double p = this.getPerimeter() / 2;
		return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
	}
	
	public double getPerimeter()
	{
		return (this.side1 + this.side2 + this.side3);
	}
	
	public String toString()
	{
		return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
	}
}

public class Test11_1
{
	
	public static void main(String[] args)
	{
		Triangle triangle = new Triangle();
		triangle.setColor("Red");
		triangle.setFilled(true);
		System.out.println(triangle);
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println();
        return;
	}
}