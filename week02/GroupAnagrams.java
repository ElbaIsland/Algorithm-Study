/*
	 1. ù��° for������ arrays.sort�� ���� �ش� ���ڸ� ���ĺ� ������ �����Ѵ�.
			���� map�� �ش� ���� ���ĺ��� �־��ָ�,
		  �ֳʱ׷��� �ܾ���� �ߺ��� ���ŵ� ä�� key���� ���õȴ�.
	 2. ���� �ι�° for��������, �տ��� ���� key���� ã�� �ش� value�� strs ���ڿ��� �־��ش�.
 */

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

    	Map<String, List<String>> chkAnagram = new HashMap<>();
 	   	
    	// ���� chkStr map�� key���� �־��ֱ�
    	for (String str : strs) {
    		List<String> inputStrVal = new ArrayList<String>();
				char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String sortStr = String.valueOf(ch); // ������ char�� �ٽ� string����!
				chkAnagram.put(sortStr, inputStrVal);
			}

    	// �տ��� ���õ� key���� �����Ͽ� value�� �־��ֱ�
      for (String str : strs) {
				char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String sortStr = String.valueOf(ch);
        		
        	if (chkAnagram.containsKey(sortStr)) {
        		 List<String> inputStrVal = chkAnagram.get(sortStr);
        		 inputStrVal.add(str);
					   chkAnagram.put(sortStr, inputStrVal);
					}      
        	
			}

		return new ArrayList<>(chkAnagram.values());

	}	
    
    
    public static void main(String[] args) {
    	
    	String[] testList = {"eat","tea","tan","ate","nat","bat"};
    	
			GroupAnagrams ga = new GroupAnagrams();
		
			ga.groupAnagrams(testList);
	}
	
}