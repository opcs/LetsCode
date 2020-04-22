package com.code.algo.arecursive;

/**
 * @author opcs
 * for all recursive call, must define base condition to avoid infinite call
 */
public class HeadAndTailRecursive {
	
	/**
	 * @param height
	 * for head recursive, call recursive first then do operations
	 */
	public void headRecursive(int height) {
		
		if(height==0) return;
		
		headRecursive(height-1);
		System.out.println(height);
	}
	
/**
 * @param height
 * for tail recursive, do operation first and then call method recursively
 */
public void tailRecursive(int height) {
		
		if(height==0) return;
		
		System.out.println(height);
		tailRecursive(height-1);
		System.out.println("---after tail Recursive call----"+ height);
	}

	public static void main(String[] args) {
		HeadAndTailRecursive algo = new HeadAndTailRecursive();
		System.out.println("-----head recursive----");
		algo.headRecursive(4);
		System.out.println("-----tail recursive----");
		algo.tailRecursive(4);

	}

}
