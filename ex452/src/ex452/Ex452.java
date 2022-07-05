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
		System.out.println("�߳�Ϊ 2 �������ε����Ϊ " + square.area(2));
		System.out.println("�뾶Ϊ 3 ��Բ�����ԼΪ " + circle.area(3));
		return;
	}
}