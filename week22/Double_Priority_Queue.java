package week22;

import java.util.*;

/* 220425 review (���α׷��ӽ� - �ؽ�)
 * 3. ���� �켱���� ť
 * 
		**���� ����**
		���� �켱���� ť�� �� ���� operations�� �Ű������� �־��� ��, 
		��� ������ ó���� �� ť�� ��������� [0,0] ������� ������ [�ִ�, �ּڰ�]�� return �ϵ��� solution �Լ��� �������ּ���.
		
		**���� Ǯ��**
		
		�ִ밪�� ���� �켱���� ť / �ּҰ��� ���� **�� �켱���� ť�� �и��Ͽ� ������ �����Ѵ�.
		�� ��� ������ ó���� �� [�ִ�, �ּڰ�]�� return�� �� �ٷ� ���� return�ϸ� �ȴ�.
		
		*** **remove ��ɾ ���� ��Ư�� ������ ť���� �����ϴ� ���� �����ϴ�!**
		
		1. �ִ밪�� �ּҰ��� ���� �� �켱���� ť�� �����Ѵ�.
		2. [��ɾ� ����] �� �̷�����ִ� operations�� �迭�� �ɰ�, ��ɾ ���� �����Ͽ� ���� ����!
		    - I(insert) : �� ť�� �ش� ���� insert
		    - D(delete) : ���ڰ� ��� / ���������� ���� �׸� ���� ������ �и��Ͽ� �����Ѵ�.
		3. �� �켱���� ť�� ���� ����ִٸ� ���� �������� 0��, �ƴ϶�� �ش� ���� return�Ѵ�.
 */

public class Double_Priority_Queue {
    public int[] solution(String[] operations) {

        int[] answer = {0,0};
        int count = 0;
        
        // �ִ밪 & �ּҰ� �켱���� ť ����
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for( String str: operations ){
            String[] calculate = str.split(" ");    //  calculate[0] = ��ɾ�, calculate[1] = ����
            String order = calculate[0];
            int numbers = Integer.parseInt(calculate[1]);
            
            // �� �߰� ��ɾ�
            if(order.equals("I")){
            //    System.out.println("queue insert, num : " + numbers);
                maxPq.offer(numbers);
                minPq.offer(numbers);
            }
            else{   //  �� ���� ��ɾ�
                
                if(numbers >= 0 && !maxPq.isEmpty()){   //  �ִ밪 ����
                    int num = maxPq.poll();
                    minPq.remove(num);
                //    System.out.println("maxPq delete, num : " + num);
                }
                else if(numbers < 0 && !minPq.isEmpty()){   //  �ּҰ� ����
                    int num = minPq.poll();
                    maxPq.remove(num);
                //    System.out.println("minPq delete, num : " + num);
                    
                }
                else continue;  //  ť�� ������� �� �ǳʶٱ�
                
            }
            
        }
        
        if(!maxPq.isEmpty()){
            answer[0] = maxPq.poll();
        }
        if(!minPq.isEmpty()){
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}