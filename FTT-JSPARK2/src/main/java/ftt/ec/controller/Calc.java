package ftt.ec.controller;

public class Calc {
	
	public String add (String a, String b) {
		
		int ai = Integer.valueOf(a);
		int bi = Integer.valueOf(b);
		
		return String.valueOf(ai + bi); 
	}

}
