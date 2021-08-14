package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

    	Map<String, List<String>> chkStr = new HashMap<>();
    	Map<String, String> keyVal = new HashMap<>();

    	   	
    	// map의 각각의 key값만 넣어주기
    	for (String str : strs) {
    		List<String> ee = new ArrayList<String>();
			char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	String toStr = String.valueOf(ch);
			chkStr.put(toStr, ee);
		}

    	// 세팅된 key값을 구분하여 value값 넣어주기
        for (String str : strs) {
			char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	String toStr = String.valueOf(ch);
        	System.out.println("toStr : " + toStr);
        		
        	if (chkStr.containsKey(toStr)) {
        	//	 System.out.println("겹치는 key값 존재 > 초기화 ㄴㄴ");
        		 List testee = chkStr.get(toStr);
        		 System.out.println("toStr >> " + toStr + ", testee >> " + testee);
        		 testee.add(str);
				 chkStr.put(toStr, testee);
			}      
        	
		}
 
		return new ArrayList<>(chkStr.values());
    }	
    
    
    public static void main(String[] args) {
    	
    	String[] testList = {"eat","tea","tan","ate","nat","bat"};
    	
		GroupAnagrams ga = new GroupAnagrams();
		
		ga.groupAnagrams(testList);
	}
	
}
