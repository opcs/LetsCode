/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
import java.util.HashMap;
import java.util.Set;

/**
 * @author oprakash
 * @created 04-Jan-2017
 * @vcsid $Id: $
 */
public class FindCountOfChar {
    public static void main(String[] args) {
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        String inputString = "omprakash";
        char[] strArray = inputString.toCharArray();
        for (char c : strArray) {
            if (charCountMap.put(c, 1) != null) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            // else
            // charCountMap.put(c, 1);
        }
        final Set<Character> charSet = charCountMap.keySet();
        for (Character character : charSet) {
            if (charCountMap.get(character) > 1) {
                System.out.println(character + "--->" + charCountMap.get(character));
            }
        }
    }

}
