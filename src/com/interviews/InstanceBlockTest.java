package com.interviews;

class AA {
	{
		System.out.println("A");
	}

}

class BB extends AA{
	{
		System.out.println("B");
	}

}

class CC extends BB{
	{
		System.out.println("C");
	}
}

public class InstanceBlockTest{
	
	
	public static void main(String[] args) {
		
		CC c = new CC();
		
	}
}

