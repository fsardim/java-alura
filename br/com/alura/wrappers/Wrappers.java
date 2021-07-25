package br.com.alura.wrappers;

public class Wrappers {
	
	public static void main(String[] args) {
		
		Integer int1 = Integer.valueOf(10);
		Integer int2 = Integer.valueOf("10");
		Integer int3 = Integer.parseInt("10");
		int1 = Integer.decode("0xFFF");
		
		System.out.println(int1);
		
		Boolean b = Boolean.TRUE;
		Double  d = Double.valueOf("29.0");
		System.out.println(int1.doubleValue());
		
		Number n = Integer.valueOf(10);
		System.out.println(n.doubleValue());
		System.out.println(n.toString());
		System.out.println(n.shortValue());
		
		Long l = Long.valueOf(1);
		System.out.println(l.BYTES);
	}

}
