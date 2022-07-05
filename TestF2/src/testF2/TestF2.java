package testF2;

class Complex
{
	private int realPart;
	private int imaginePart;
	public Complex(int i, int j)
	{
		this.realPart = i;
		this.imaginePart = j;
	}
	public int getRealPart()
	{
		return realPart;
	}
	public void setRealPart(int realPart)
	{
		this.realPart = realPart;
	}
	public int getimaginePart()
	{
		return imaginePart;
	}
	public void setimaginePart(int imaginePart)
	{
		this.imaginePart = imaginePart;
	}
	public Complex addComplex(Complex c)//ПајУ
	{
		int real = this.realPart + c.realPart;
		int imagine = this.imaginePart + c.imaginePart;
		Complex result = new Complex(real, imagine);
		result.setRealPart(real);
		result.setimaginePart(imagine);
		return result;
	}
	public Complex minusComplex(Complex c)//Пајх
	{
		int real = this.realPart - c.realPart;
		int imagine = this.imaginePart - c.imaginePart;
		Complex result = new Complex(real, imagine);
		result.setRealPart(real);
		result.setimaginePart(imagine);
		return result;
	}
	public String toString()
	{
		return this.realPart + " + " + this.imaginePart + "i";
	}
}

public class TestF2
{
	public static void main(String[] args)
	{
		Complex c1 = new Complex(2, 6);
		Complex c2 = new Complex(4, 2);
		System.out.println("c1 = " + c1.toString());
		System.out.println("c2 = " + c2.toString());
		System.out.println("c1 = c1 + c2 = (" + c1.toString() + ") + (" + c2.toString() + ") = " + c1.addComplex(c2).toString());
		c1 = c1.addComplex(c2);
		Complex c3 = c1.addComplex(c2);
		System.out.println("c3 = c1 + c2 = (" + c1.toString() + ") + (" + c2.toString() + ") = " + c3.toString());
		return;
	}
}