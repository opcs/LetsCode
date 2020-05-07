package com.op._misc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	static String find_phone_number(String text) {
       // String regex="^[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}\\-";
        String simpregex="\\d{3}-\\d{3}-\\d{4}";
        Pattern p=Pattern.compile(simpregex);
        Matcher m=p.matcher(text);
        if(m.matches()){
           return findNumber(); 
        }
        else{
            return "NONE";
        } 
    }

	private static String findNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
