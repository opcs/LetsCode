package com.code.logical;

public class MiddleIndex {

	public static void main(String[] args) {
		int[] numbers={1,2,5,5,4,4,5};   // index 3
		
		int index = 0;
		try {
			index = getMiddleIndex(numbers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("index: " + index);
	}

	private static int getMiddleIndex(int[] numbers) throws Exception {
		int endIndex=numbers.length-1;
		int startIndex=0;
		int sumleft=0;
		int sumright=0;
		while(true){
			if(sumleft>sumright){
				sumright+=numbers[endIndex--];
			}else{
				sumleft+=numbers[startIndex++];
			}
			
			if(startIndex>endIndex){
				if(sumleft==sumright){
					break;
				}else{
					throw new Exception("please provide valid input...");
				}
			}
		}
		return endIndex;
	}

}
