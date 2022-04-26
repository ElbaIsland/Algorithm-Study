package week22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 220425 review (���α׷��ӽ� - ��(�켱���� ť))
 * 1. �� �ʰ�
 * 
	**���� ����**
	
	Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, 
	��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	`���� ���� ���ں� = ���� ���� ���� ���� ���ں� + (�� ��°�� ���� ���� ���� ���ں� * 2)`
	
	**���� Ǯ��**
	
	�� PriorityQueue : �켱���� ť
	
	���� ���� ���� �ΰ����� ���ں� ������ �ݺ��ؼ� �����ָ� �ȴ�.
	
	1) scoville �迭�� �켱���� ť�� �־��ش�. 
	    �ڵ����� ���� ���� �������(���ڰ� ���� �������) ť�� ������ �ȴ�.
	
	2) ���� ���� ���� ������ ���ں� ������ ���ϴ� ���ں� ������ ������ �� ���� �ݺ��ؼ� ���´�.
	
	- ������ �迭(�켱���� ť) ���̰� 1 �����̸�, ���μ����� �����ϴ� ����ó��**�� ���ش�.
	- ������ �迭(�켱���� ť) ���̰� 2 �̻��̸�, ������� ���� ť�� ���� ���Ĵ�� �����ش�. 
	  �� �� ��������, ���� Ƚ�� count�� 1 �߰��Ѵ�.
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
            // ���ڰ� �������� �켱������ ����!!
            pq.add(scoville[i]); 
        }
        
        // ���� head���� ������ ���� ���ں� ������ ���� �ٽ� �ִ´�.
        // �ּұ��ؿ� �����Ҷ����� �ݺ��Ѵ�.
        while(pq.peek() < targetScovile){
            
            // 04.23 : �̺κ��� ���� ����...
            if (pq.size() <= 1) {
                return -1;
            }
            
            firstMinScoville = pq.poll(); // pq���� ���� ���� ���� ���ں�
            secondMinScoville = pq.poll(); // pq���� �ι�°�� ���� ���ں�
            
            int mixedScoville = firstMinScoville + secondMinScoville * 2;
            pq.add(mixedScoville); 
            answer++; 
            
        }
        return answer;
    }
}