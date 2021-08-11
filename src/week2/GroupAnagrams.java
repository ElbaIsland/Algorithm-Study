package week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

    	Map<String, List<String>> chkStr = new HashMap<>();
    	
        for (String str : strs) {
        	System.out.println(str);
			char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	System.out.println(ch);
		}
    	   	
  //  	System.out.println("strs : " + Arrays.toString(strs));   	  	
		return null;	
    }	
    
    
    public static void main(String[] args) {
    	
    	String[] testList = {"eat","tea","tan","ate","nat","bat"};
    	
		GroupAnagrams ga = new GroupAnagrams();
		
		ga.groupAnagrams(testList);
	}
	
}
