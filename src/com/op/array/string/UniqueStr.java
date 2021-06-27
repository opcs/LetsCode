package com.op.array.string;

public class UniqueStr {
	
	
	public boolean isUniqueChar(String str) {
		
		boolean[] char_set = new boolean[128];
		if(str.length()>128) return false;
		
		for(int i=0;i<str.length();i++) {
			int val = str.charAt(i);
			
			if(char_set[val])
				return false;
			else
				char_set[i]=true;
		}
		return true;
	}

	public static void main(String[] args) {
		

	}

}
