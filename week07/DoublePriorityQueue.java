package week07;

import java.util.*;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        
        // �켱���� ť ����(�ּҰ� & �ִ밪 ���� ����)
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq
            = new PriorityQueue<>(Collections.reverseOrder());
        
        // �и� �� ó����
        int dubMaxCnt = 0;
        int dubMinCnt = 0;
        
        for(String arg : operations){
            
             // insert ���ڿ�
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
                
            } else if(arg.equals("D 1")) {  // �ִ밪 ����
                
                if(maxPq.size() <= 0){
                }
                else{
                    maxPq.remove();   
                }
                
            } else if(arg.equals("D -1")) {  // �ּҰ� ����
                
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

