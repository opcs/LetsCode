package com.op.algo.sort;

public class ParallelSmartMergeSort {

	protected void compute() {
		  if (low < high) {
		    if (high - low <= MAX) { // Sequential implementation
		      mergesort(array, helper, low, high);
		    } else { // Parallel implementation
		      final int middle = (low + high) / 2;
		      final ParallelSmartMergeSort left = 
		        new ParallelSmartMergeSort(array, low, middle);
		      final ParallelSmartMergeSort right = 
		        new ParallelSmartMergeSort(array, middle + 1, high);
		      invokeAll(left, right);
		      merge(array, helper, low, middle, high);
		    }
		  }
		}
}
