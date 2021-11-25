package week07;

import java.util.*;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        
        // 우선순위 큐 생성(최소값 & 최대값 기준 정렬)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq
            = new PriorityQueue<>(Collections.reverseOrder());
        
        // 밀린 값 처리용
        int dubMaxCnt = 0;
        int dubMinCnt = 0;
        
        for(String arg : operations){
            
             // insert 문자열
            if(arg.charAt(0) == 'I'){   
                
                minPq.add(Integer.parseInt(arg.substring(1).trim()));    
                maxPq.add(Integer.parseInt(arg.substring(1).trim()));     
  
                if(dubMaxCnt > 0){
                    System.out.println("dubMaxCnt >> " + dubMaxCnt);
                    while(maxPq.size() <= 0){
                        maxPq.remove();
                    }
                }
                
                if(dubMinCnt > 0){
                    System.out.println("dubMinCnt >> " + dubMinCnt);
                    while(minPq.size() <= 0){
                        minPq.remove();
                    }
                }
                
            } else if(arg.equals("D 1")) {  // 최대값 삭제
                
                if(maxPq.size() <= 0){
                }
                else{
                    maxPq.remove();   
                }
                
            } else if(arg.equals("D -1")) {  // 최소값 삭제
                
                if(minPq.size() <= 0){
                }
                else{
                    minPq.remove();     
                }
        
            }             
        }
        
        int maxInt = maxPq.poll();
        int minInt = minPq.poll();
        
        int[] answer = new int[]{maxInt, minInt};
        
        return answer;
    }
}

