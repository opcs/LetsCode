package com.op.logical;

public class Merge2Arrays {

	public static void main(String[] args) {
		int[] a = {1,67,2,4};
		int[] b = {1,7,2,11};
		int[] c = merge(a,b);
		
		for(int i=0;i<c.length;i++)
			System.out.println(c[i]);
	}

	private static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		/*for(int i=0;i<b.length;i++)
			c[i]=a[i];
		for(int j=0; j<b.length; j++){
			c[a.length+j]=b[j];
		}*/
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}


}
