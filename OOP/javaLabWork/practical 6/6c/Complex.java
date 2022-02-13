//import java.awt.*;

public class Complex {
	private float real,imaginary;
	Complex(){		//default constructor
		real = 1;
		imaginary = 1;
	}
	Complex(float real, float imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	void setReal(float real){
		this.real = real;
	}
	void setImaginary(float imaginary){
		this.imaginary = imaginary;
	}
	float getReal(){
		return real;
	}
	float getImaginary(){
		return imaginary;
	}
	public static Complex Addition(Complex I1,Complex I2){
		Complex result = new Complex();
		result.real = I1.real + I2.real;
		result.imaginary = I1.imaginary + I2.imaginary;
		return result;
	}
	public static Complex Subtraction(Complex I1,Complex I2){
		Complex result = new Complex();
		result.real = I1.real - I2.real;
		result.imaginary = I1.imaginary - I2.imaginary;
		return result;
	}
	public static void Display(Complex I1){
		System.out.println(I1.real + " + " + I1.imaginary + "i");
	}
}