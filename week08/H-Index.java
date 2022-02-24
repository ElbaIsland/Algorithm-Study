package week08;

import java.util.*;

public class TheExam {
    
    // 프로그래머스 > 정렬 > H-Index(https://programmers.co.kr/learn/courses/30/lessons/42747)
    // 설명 : 발표한 논문들의 각 인용 횟수 배열인 citations를 활용해, H-Index를 구하라.
    // * H-Index : 과학자의 생산성과 영향력을 나타내는 지표
    
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
