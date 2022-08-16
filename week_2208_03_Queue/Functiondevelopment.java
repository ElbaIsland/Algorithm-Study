package week_2208_03_Queue;

import java.util.*;

/* ====================
 * 
 * ====================
   리트코드(LeetCode) 136번 문제 싱글넘버
 
 - 문제 : 주어진 배열에서 중복이 아닌 단 하나의 숫자를 찾는 문제
 - 풀이 : 
   1) 주어진 int[] 배열을 정렬한다. / 스택을 만든다.
   2) for문을 돌려, 스택에서 꺼낸(peek) 수와 현재 순서에 해당하는 수의 일치 여부를 파악한다.
      - 일치시 스택에서 값을 꺼낸다.(pop)
      - 불일치시 현재 순서에 해당하는 값을 스택에 넣는다.(push)
   3) for문이 끝나는 시점에서는, 중복되지 않은 단 하나의 수만 stack에 남는다. 그 수를 return한다.
  
 */

public class Functiondevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // progresses : 각 작업의 진도 (배열 순서대로 배포 必)
        // speeds : 각 작업의 개발 속도
        
        // 풀이
        // 1) for문으로 progresses 길이만큼 반복
        // 2) while문으로 각 progress에 speeds를 더하기 & day count, 100 이상이 될 경우 out 
        // 3) 2)에서 구한 count를 큐에 넣기, 다음 for문 진행
        // 4) 위의 1~3번 과정을 통해, 큐에는 순서대로 작업 진도별 배포일자가 들어감
        // 5) queue를 하나씩 빼내서, progress 순서대로 같은 날짜의 배포일자를 묶어서 return용 배열에 추가
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        int cnt;
        int cnt2 = 0;
        
        for(int i = 0; i < progresses.length; i++){
            
            cnt = 0;
            var progress = progresses[i];
            cnt++;
            var speed = speeds[i];
            
            while(progress >= 100){
                progress = progress + speed;
                cnt++;
            }
            queue.add(cnt);
        }
        
        // 이 시점에서, 큐는 7,3,9...이런 식으로 작업완료일 순으로 들어있다. 앞 큐를 빼내서 다음 큐랑 비교한다.
        // - 앞 숫자가 더 클 경우, 
        // - 서로 같을 경우,
        // - 뒤 숫자가 더 클 경우, 지금까지 더한 cnt를 answer 배열에 넣기
        System.out.println(queue);
        
        int first = queue.poll();
        
        while(!queue.isEmpty()){
        
            int second = queue.peek(); 
            System.out.print("first : " + first + ", second : " + second + " | ");
            
            if(first >= second){
                System.out.println("cnt2 up & queue 값 빼기");
                cnt2++;
                queue.poll();
            }
            else{
                first = second;
                System.out.println("list add >> cnt2 : " + cnt2);
                answerList.add(cnt2);
                cnt2 = 1;
                queue.poll();
            }

        }
     
        System.out.println(answerList.toString()); 
        return answer;
    }    
}