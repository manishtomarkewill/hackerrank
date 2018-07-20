package edu.njit.cs602.assignments;

public class RationalClass {
	private final int numerator;
	private final int denominator;
	
	public RationalClass(int numerator,int denominator) throws InvalidRationalException{
		if(denominator==0){
			throw new InvalidRationalException("Denominator zero");
		}
		if(denominator<0){
			numerator=-1*numerator;
			denominator=Math.abs(denominator);
		}
		int gcdValue=gcd(numerator,denominator);
		this.numerator=numerator/gcdValue;
		this.denominator=denominator/gcdValue;
		
	}
	
	public static int gcd(int a, int b){
		a=Math.abs(a);
		b=Math.abs(b);
		int c = a<b?a:b;
		int d = a>=b?a:b;
		while(c!=0){
			int temp=d%c;
		    if(c<temp)
		    	d=temp;
		    else{
		    	d=c;
		    	c=temp;
		    }
		}
		return d;
	}
	
	@Override
	public String toString(){
		if(denominator==1)
			return ""+numerator;
		else
			return numerator+"/"+denominator;
	}
	
	public RationalClass add(RationalClass b){
		RationalClass d=null;
		try {
			d= new RationalClass((b.numerator*this.denominator+this.numerator*b.denominator),b.denominator*this.denominator);
		} catch (InvalidRationalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public RationalClass substract(RationalClass b){
		RationalClass d=null;
		try {
			d= new RationalClass((b.numerator*this.denominator-this.numerator*b.denominator),b.denominator*this.denominator);
		} catch (InvalidRationalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public RationalClass multiply(RationalClass b){
		RationalClass d=null;
		try {
			d= new RationalClass((b.numerator*this.numerator),b.denominator*this.denominator);
		} catch (InvalidRationalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public RationalClass negate(){
		RationalClass d=null;
		try {
			d= new RationalClass(-this.numerator,this.denominator);
		} catch (InvalidRationalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	public static void main(String[] args) {
		System.out.println(gcd(0,0));
		System.out.println(gcd(30,-36));
		try {
			System.out.println(new RationalClass(15,12).negate());
			System.out.println(new RationalClass(15,12).add(new RationalClass(2,3)));
			System.out.println(new RationalClass(15,12).substract(new RationalClass(2,3)));
			System.out.println(new RationalClass(15,12).multiply(new RationalClass(2,3)));
			System.out.println(new RationalClass(-12,-15));
			System.out.println(new RationalClass(12,-15));
		} catch (InvalidRationalException e) {
			e.printStackTrace();
		}

	}

}
