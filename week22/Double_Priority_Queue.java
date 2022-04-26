package week22;

import java.util.*;

/* 220425 review (프로그래머스 - 해시)
 * 3. 이중 우선순위 큐
 * 
		**문제 설명**
		이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 
		모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
		
		**문제 풀이**
		
		최대값에 대한 우선순위 큐 / 최소값에 대한 **각 우선순위 큐를 분리하여 로직을 구성한다.
		⇒ 모든 연산을 처리한 후 [최댓값, 최솟값]을 return할 때 바로 꺼내 return하면 된다.
		
		*** **remove 명령어를 통해 ‘특정 값’을 큐에서 삭제하는 것이 가능하다!**
		
		1. 최대값과 최소값에 대한 각 우선순위 큐를 생성한다.
		2. [명령어 숫자] 로 이루어져있는 operations을 배열을 쪼개, 명령어에 따라 구분하여 연산 진행!
		    - I(insert) : 각 큐에 해당 숫자 insert
		    - D(delete) : 숫자가 양수 / 음수인지에 따라 항목 삭제 로직을 분리하여 진행한다.
		3. 각 우선순위 큐에 값이 비어있다면 기존 생성값인 0을, 아니라면 해당 값을 return한다.
 */

public class Double_Priority_Queue {
    public int[] solution(String[] operations) {

        int[] answer = {0,0};
        int count = 0;
        
        // 최대값 & 최소값 우선순위 큐 생성
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        
        for( String str: operations ){
            String[] calculate = str.split(" ");    //  calculate[0] = 명령어, calculate[1] = 숫자
            String order = calculate[0];
            int numbers = Integer.parseInt(calculate[1]);
            
            // 값 추가 명령어
            if(order.equals("I")){
            //    System.out.println("queue insert, num : " + numbers);
                maxPq.offer(numbers);
                minPq.offer(numbers);
            }
            else{   //  값 삭제 명령어
                
                if(numbers >= 0 && !maxPq.isEmpty()){   //  최대값 삭제
                    int num = maxPq.poll();
                    minPq.remove(num);
                //    System.out.println("maxPq delete, num : " + num);
                }
                else if(numbers < 0 && !minPq.isEmpty()){   //  최소값 삭제
                    int num = minPq.poll();
                    maxPq.remove(num);
                //    System.out.println("minPq delete, num : " + num);
                    
                }
                else continue;  //  큐가 비어있을 시 건너뛰기
                
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