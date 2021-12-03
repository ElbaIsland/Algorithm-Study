package week09;

import java.util.*;

public class Runners {
    public String solution(String[] participant, String[] completion) {
        
        // *** 참가자 동명이인 있다는 것 생각해서 개발
        Map<String, Integer> runner = new HashMap<>();
        
        // 1) 참가자들 집어넣기
        for(String str : participant){  
            // 동명이인 처리
            if(runner.get(str) != null) {
                runner.put(str, runner.get(str)+1); // 동명이인 존재시 value값을 1씩 더해준다.
            }   
            else {
                runner.put(str, 1);  
            }        
        }
        
        System.out.println(runner.values());     
        
        // 2) 완주자들 빼기
        for(String str : completion){
            // 동명이인 처리
            if(runner.get(str) > 0) {
                runner.put(str, runner.get(str)-1); // 동명이인 존재시 value값을 1씩 빼준다.
            } 
            else {
                 runner.remove(str);   
            } 
        }    
        
        // 3) 남은 runner map 확인
        //  System.out.println(runner.values());   
        
        String answer = "";
        
        for (String key : runner.keySet()) {
            if (runner.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}