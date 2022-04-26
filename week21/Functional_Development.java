package week21;

import java.util.*;

/* 220418 review (프로그래머스 - 큐)
 * 5. 기능개발
 * 
 * 
 */

public class Functional_Development {
    
    public int[] solution(int[] progresses, int[] speeds) {

        int timeToProgress = progresses.length;
        List<Integer> answerList = new ArrayList<>();
        int[] timeToEnd = new int[timeToProgress];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < timeToProgress; i++){
            // 1) 작업별 기능이 완전히 개발되는데까지 걸리는 시간
            int dayCnt = 0;
            int workAmount = 0;
            int restAmountWork = 100 - progresses[i];
            while(restAmountWork > workAmount){
                workAmount += speeds[i];
                dayCnt++;
            }
            queue.add(dayCnt);
        }
        // System.out.println("queue : " + queue);
        
        while(!queue.isEmpty()){
            
            int day = queue.poll(); // 첫번째값 가져옴
            int countOfProgress = 1;
            
            System.out.println("day : " + day);
            // queue.peek() : 큐의 첫번째 값, 첫번째 일수 기준으로 날짜가 두번째 날짜보다 크거나 같으면 반복
            while(!queue.isEmpty() && day >= queue.peek()){ 
                queue.poll(); // 두번째 프로세스 빼내고 아래 카운트에 추가
                countOfProgress++;
            }
            answerList.add(countOfProgress);
        }

        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}