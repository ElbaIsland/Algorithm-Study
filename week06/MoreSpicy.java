package week06;

import java.util.PriorityQueue;

public class MoreSpicy {
	
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        int targetScovile = K;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
//        int firstMinScoville;
//        int secondMinScoville;
        
        for(int i = 0; i < scoville.length; i++){   
            // 숫자가 작을수록 우선순위가 높다!!
            heap.add(scoville[i]); 
        }
        
        // 기존 head에서 값들을 꺼내 스코빌 지수를 합쳐 다시 넣는다.
        // 최소기준에 만족할때까지 반복한다.
        while(heap.peek() < targetScovile){ // targetScovile이 되는순간 멈춰야하기에
           
						// 계속 런타임 에러 발생... 예외처리 조심할것!! 
            if (heap.size() <= 1) {
                return -1;
            }
            
            // 객체를 꺼내 반환
            int firstScoville = heap.poll();
        	int secondScoville = heap.poll();
            
            int mixedScoville = firstScoville + (secondScoville * 2);
            heap.add(mixedScoville); 
            answer++;       
        }
         
        return answer;
    }
}

