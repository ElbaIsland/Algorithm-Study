package week01_StringHandling;

import java.util.HashMap;
import java.util.Map;

/* ====================
 * 문자열 조작 
 * ====================
   리트코드(LeetCode) 819번 문제 가장 흔한 단어
 
 - 문제 : 주어진 문자열에서 '가장 많이 사용된 단어'를 찾는 문제
 - 풀이 : 
   1) 주어진 문자열에서 각각의 단어를 쪼갠 뒤, String 배열에 넣는다.  
   2) String 배열을 하나씩 비교하여, 각 단어와 그 개수를 map 형태의 배열에 넣어준다.
   3) 가장 높은 count의 단어를 확인하여 return한다. 
  
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
