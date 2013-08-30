package org.mbk;

public class Proba {
	public int a;
	public int b;
	private int counter;
	
	/**
	 * Constructor
	 */
	Proba(){
		a = 5;
		b = 10;
		counter = 1;
	}
	
	public void inc(){
		counter++;
	}
	
	public void showCounter() throws IndexOutOfBoundsException{
		System.out.println("Counte is:" + counter);
	}
}
