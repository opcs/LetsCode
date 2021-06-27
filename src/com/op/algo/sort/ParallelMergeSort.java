package com.op.algo.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction{
	
	private static final long serialVersionUID = 1L;
	private static int[] array;
	private final int[] helperArray;
	private final int low;
	private final int high;

	


	public ParallelMergeSort(final int[] array, final int low, final int high) {
		this.array = array;
		helperArray = new int[array.length];
		this.low = low;
		this.high = high;
	} 


	@Override
	protected void compute() {
		if (low < high) {
			final int middle = (low + high) / 2;
			final ParallelMergeSort left = 
				new ParallelMergeSort(array, low, middle);
			final ParallelMergeSort right = 
				new ParallelMergeSort(array, middle + 1, high);
			invokeAll(left, right);
			merge(array, helperArray, low, middle, high);
		}
	}
	
	
	private void merge(int[] array, int[] helperArray, int low, int middle, int high) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		final ForkJoinPool forkJoinPool = 
				  new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
				forkJoinPool.invoke(new ParallelMergeSort(array, 0, array.length - 1));
				Arrays.parallelSort(array);

	}

}
