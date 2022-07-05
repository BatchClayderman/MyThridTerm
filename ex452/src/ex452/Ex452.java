package ex452;
import java.lang.Math;

interface Shape
{
	double area(double givenValue);
}

class Square implements Shape
{
	public double area(double sideLength)
	{
    	return sideLength * sideLength;
    	//return Math.pow(sideLength, 2);
	}
}

class Circle implements Shape
{
	public double area(double r)
	{
    	return Math.PI * r * r;
	}
}


public class Ex452
{
	public static void main(String[] args)
	{
		Shape square = new Square();
		Shape circle = new Circle();
		System.out.println("边长为 2 的正方形的面积为 " + square.area(2));
		System.out.println("半径为 3 的圆的面积约为 " + circle.area(3));
		return;
	}
}