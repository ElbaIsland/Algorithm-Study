/*
	 1. 첫번째 for문에서 arrays.sort를 통해 해당 문자를 알파벳 순으로 정렬한다.
			이후 map에 해당 정렬 알파벳을 넣어주면,
		  애너그램인 단어들은 중복이 제거된 채로 key값에 세팅된다.
	 2. 이후 두번째 for문에서는, 앞에서 넣은 key값을 찾아 해당 value에 strs 문자열을 넣어준다.
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
 	   	
    	// 먼저 chkStr map에 key값만 넣어주기
    	for (String str : strs) {
    		List<String> inputStrVal = new ArrayList<String>();
				char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String sortStr = String.valueOf(ch); // 정렬한 char을 다시 string으로!
				chkAnagram.put(sortStr, inputStrVal);
			}

    	// 앞에서 세팅된 key값을 구분하여 value값 넣어주기
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