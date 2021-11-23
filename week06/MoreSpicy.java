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
            // ���ڰ� �������� �켱������ ����!!
            heap.add(scoville[i]); 
        }
        
        // ���� head���� ������ ���� ���ں� ������ ���� �ٽ� �ִ´�.
        // �ּұ��ؿ� �����Ҷ����� �ݺ��Ѵ�.
        while(heap.peek() < targetScovile){ // targetScovile�� �Ǵ¼��� ������ϱ⿡
           
						// ��� ��Ÿ�� ���� �߻�... ����ó�� �����Ұ�!! 
            if (heap.size() <= 1) {
                return -1;
            }
            
            // ��ü�� ���� ��ȯ
            int firstScoville = heap.poll();
        	int secondScoville = heap.poll();
            
            int mixedScoville = firstScoville + (secondScoville * 2);
            heap.add(mixedScoville); 
            answer++;       
        }
         
        return answer;
    }
}

