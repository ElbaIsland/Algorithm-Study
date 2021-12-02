package week08;

import java.util.*;

public class TheExam {
    public int solution(int[] citations) {
        
        // 선 정렬을 하면, 인용된 논문이 h편 이상인 경우만 check하면 됨
        // (정렬된 배열 기준, 앞값이 이하 & 뒷값이 이상)
        Arrays.sort(citations);
        int answer = 0;
        
        for(int i = 0; i < citations.length; i++){
            
            // h를 최대값에서 줄여가면서, h-index 최댓값 count
            int h = citations.length-i;
            
            System.out.println("h : " + h + ", citations" + i + " : " + citations[i]);
            
            // 논문 인용횟수(citations)가 h 이상인지 확인
            if(citations[i] >= h){
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}