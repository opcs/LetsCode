package com.op.logical;

public class Pangram {

	public static void main(String[] args) {
		checkPangram("jhfshj-abcdefghiJKlmnkjfhkfshkhskhshhhkl98679868OPQRstuvwxy16");
	}
	static void checkPangram(String str){
		int chA = 'A';
		int cha = 'a';
		if(str.length() < 26){
			System.out.println("0"); return;
		}
			
			for(int i = 0; i < 26; i++){
				
				if(!(str.indexOf(chA) >= 0 || str.indexOf(cha) >= 0)){
					System.out.println("Missing char "+(char)chA+" Or "+(char)cha);
					System.out.println("0"); return;
				}
				chA = chA+1;
				cha = cha+1;	
			}
			System.out.println(1);
		
	}
}
