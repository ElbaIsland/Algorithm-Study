package week21;

import java.util.*;

/* 220418 review (프로그래머스 - 큐)
 * 6. 프린터
 * 
 * 
 */

public class Printer {

    class Task{
        int location;
        int priority;
        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }    

    public int solution(int[] priorities, int location) {

        // priorities : 문서 중요도
        // location : 문서의 대기번호 위치(index)
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();

        // 1) 먼저 큐에 각 문서별 index와 중요도를 저장한다.
        for(int i = 0; i < priorities.length; i++){
            queue.add(new Task(i, priorities[i]));
        }        

        // 2) 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서를 찾는다.
        while (!queue.isEmpty()){
            Task nowTask = queue.poll();

            for(Task t : queue){
                if(t.priority > nowTask.priority){  // 2-1) J보다 중요도가 높은 문서 발견
                    // 출력 취소, 다시 넣어주기
                //  System.out.println("더 높은 우선순위 발견, " + nowTask.location + "번 인덱스 순위 맨뒤로..");
                    queue.offer(nowTask);
                    nowTask = null;
                    break;
                }               
            }

            // 2-2) nowTask가 null이 아니다 => 중요도가 더 높은 문서가 없다(nowTask가 중요도 가장 높음)
            if(nowTask != null){
                answer++; // 다시 큐에 넣지 않고, 그대로 인쇄한다.(인쇄순서 ++)
                if(nowTask.location == location){ // 만약, nowtask가 J라면 그대로 답안 제출!
                    return answer;
                }
            }
        }          
        return answer;
    }
}

// nowTask에 대한 null처리여부를 통해 중요도 체크를 한 부분을 생각하지 못했다...