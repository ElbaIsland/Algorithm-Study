package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 220412 review (프로그래머스 - 해시)
 * 1. 완주하지 못한 선수
 * 
 * 
 */

public class An_Unfinished_Athlete {
    public String solution(String[] participant, String[] completion) {
        
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주.
        
        String answer = "";
        Map<String, Integer> runner = new HashMap<>();
        
        int i = 0;
        for(String str : participant){    
            if(runner.get(str) != null){
                runner.put(str, runner.get(str)+1);
            }
            else runner.put(str, 1);           
        }
        
        for(String str : completion){
            if(runner.get(str) >= 2){
                runner.replace(str, runner.get(str)-1);
            }
            else runner.remove(str);
        }
        
        for (String key : runner.keySet()) {
            if (runner.get(key) != 0) answer = key;
        }
        return answer;
    }
    
}