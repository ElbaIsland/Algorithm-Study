package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 220418 review (프로그래머스 - 해시)
 * 3. 위장
 * 
 * 
 */

public class Camouflage {
    public int solution(String[][] clothes) {
        
        int answer = 1; //  지금입고있는 의상 최소 1개는 정답
        int headgear = 0;
        
        Map<String, Integer> spyCloths = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){     
            // 의상종류만 저장   
            String kindOfCloths = clothes[i][1];
            if(spyCloths.get(kindOfCloths) != null){
                spyCloths.put(kindOfCloths, spyCloths.get(kindOfCloths)+1);
            }
            else spyCloths.put(kindOfCloths, 1);        
        }
        
    //  System.out.println(spyCloths);'

        for(String key : spyCloths.keySet()){
            int numOfCloths = spyCloths.get(key) + 1;
            answer *= numOfCloths;
        }

        return answer-1;
    }
}