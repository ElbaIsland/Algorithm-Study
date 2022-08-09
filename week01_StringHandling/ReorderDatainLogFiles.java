package week01_StringHandling;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* ====================
 * 문자열 조작 
 * ====================
   리트코드(LeetCode) 937번 문제 로그 파일 재정렬
 
 - 
 - 풀이 : 
  
 */

public class ReorderDatainLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        
    	List<String> reOrderLetter = new ArrayList<>();
    	List<String> reOrderDigit = new ArrayList<>();
    	  	
    	String[] logs2 = new String[logs.length];
    	String[] tempLog;
    	String[] firstVal = new String[logs.length];
    	
    	boolean isLetterOrDigit = true;
    	
    	// 문자로그, 숫자로그 비교
        for(int i = 0; i < logs.length; i++) {
        	
        	logs2[i] = "";

            tempLog = logs[i].split(" ");
            
            for(int j = 1; j < tempLog.length; j++) {
            	
            	
            	if (j != tempLog.length-1) {
            		logs2[i] += tempLog[j] + " ";
				} else {
					logs2[i] += tempLog[j];
				}
            	
            	
	       		if (tempLog[j].charAt(0) < '0' || tempLog[j].charAt(0) > '9') {   
	    			isLetterOrDigit = false;
	       		}
	       		else {
	       			isLetterOrDigit = true;
	       		}
        	            	
            }
            
            firstVal[i] = tempLog[0]; 
           
            if (isLetterOrDigit == true) {
            	reOrderDigit.add(logs2[i]);
			}
            else{
            	reOrderLetter.add(logs2[i]);
            }				
		}
        
 		Collections.sort(reOrderLetter);
		 
 		
		List<String> reOrderList = new ArrayList<>();
		reOrderList.addAll(reOrderLetter);
		reOrderList.addAll(reOrderDigit);
		System.out.println(reOrderList);
		
		return reOrderList.toArray(new String[reOrderList.size()]);
    
    }
    
    public static void main(String[] args) {
		
    	String[] test1 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    	
    	ReorderDatainLogFiles reOrder = new ReorderDatainLogFiles();
    	
    	reOrder.reorderLogFiles(test1);
    	
	}
	
	
}
