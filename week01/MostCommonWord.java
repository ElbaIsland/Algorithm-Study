package week01;

import java.util.HashMap;
import java.util.Map;

/* ====================
 * 문자열 조작 
 * ====================
   리트코드(LeetCode) 819번 문제 가장 흔한 단어
 
 - 주어진 문자열에서 가장 많이 사용된 단어를 찾는 문제
 - 풀이 : 
  
 */

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
    	
    	for (int i = 0; i < banned.length; i++) {
    		paragraph = paragraph.replace(banned[i], "");
		}
    	
    	String[] checkWord = paragraph.replaceAll("[!?;\\.\\,]", "").toLowerCase().split(" ");

    	Map<String, Integer> wordCnt = new HashMap<String, Integer>();
    	int maxCount = 0;
    	int count = 0;
    	String maxWord = "";
    	
    	for (int i = 0; i < checkWord.length; i++) {
    		
    		wordCnt.put(checkWord[i], wordCnt.getOrDefault(checkWord[i], 0)+1);
    		count = wordCnt.get(checkWord[i]);
    		
    		if (maxCount < count && !checkWord[i].isEmpty()) {
				maxCount = count;
				maxWord = checkWord[i];					
			}
    	
		}
    	
    	System.out.println("maxWord : " + maxWord);
        return maxWord;   
    }
    
    
    public static void main(String[] args) {
		
    	String[] bannedWord = {"Bob", "hIt"};
    	
    	MostCommonWord MCW = new MostCommonWord();
    	
    	MCW.mostCommonWord("Bob. hIt, baLl", bannedWord);
    	
	}
}
