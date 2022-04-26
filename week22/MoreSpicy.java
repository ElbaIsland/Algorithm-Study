package week22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 220425 review (프로그래머스 - 힙(우선순위 큐))
 * 1. 더 맵게
 * 
	**문제 설명**
	
	Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
	모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
	
	`섞은 음식 스코빌 = 가장 맵지 않은 음식 스코빌 + (두 번째로 맵지 않은 음식 스코빌 * 2)`
	
	**문제 풀이**
	
	※ PriorityQueue : 우선순위 큐
	
	가장 맵지 않은 두가지의 스코빌 지수를 반복해서 섞어주면 된다.
	
	1) scoville 배열을 우선순위 큐에 넣어준다. 
	    자동으로 맵지 않은 순서대로(숫자가 작은 순서대로) 큐에 정렬이 된다.
	
	2) 가장 맵지 않은 음식의 스코빌 지수가 원하는 스코빌 지수에 도달할 때 까지 반복해서 섞는다.
	
	- 음식의 배열(우선순위 큐) 길이가 1 이하이면, 프로세스를 종료하는 예외처리**를 해준다.
	- 음식의 배열(우선순위 큐) 길이가 2 이상이면, 순서대로 꺼낸 큐의 값을 공식대로 섞어준다. 
	  한 번 섞었으니, 섞은 횟수 count를 1 추가한다.
 * 
 */

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        int targetScovile = K;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int firstMinScoville;
        int secondMinScoville;
        
        for(int i = 0; i < scoville.length; i++){   
            // 숫자가 작을수록 우선순위가 높다!!
            pq.add(scoville[i]); 
        }
        
        // 기존 head에서 값들을 꺼내 스코빌 지수를 합쳐 다시 넣는다.
        // 최소기준에 만족할때까지 반복한다.
        while(pq.peek() < targetScovile){
            
            // 04.23 : 이부분을 생각 못함...
            if (pq.size() <= 1) {
                return -1;
            }
            
            firstMinScoville = pq.poll(); // pq에서 가장 먼저 꺼낸 스코빌
            secondMinScoville = pq.poll(); // pq에서 두번째로 꺼낸 스코빌
            
            int mixedScoville = firstMinScoville + secondMinScoville * 2;
            pq.add(mixedScoville); 
            answer++; 
            
        }
        return answer;
    }
}