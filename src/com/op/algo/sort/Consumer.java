package com.op.algo.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Consumer {

	public static void main(String[] args) {
		final ForkJoinPool forkJoinPool = 
				  new ForkJoinPool(Runtime.getRuntime().availableProcessors() - 1);
				forkJoinPool.invoke(new ParallelMergeSort(array, 0, array.length - 1));
				Arrays.parallelSort(array);

	}

}
