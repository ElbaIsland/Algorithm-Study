package week21;

import java.util.*;

/* 220418 review (���α׷��ӽ� - ť)
 * 5. ��ɰ���
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
            // 1) �۾��� ����� ������ ���ߵǴµ����� �ɸ��� �ð�
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
            
            int day = queue.poll(); // ù��°�� ������
            int countOfProgress = 1;
            
            System.out.println("day : " + day);
            // queue.peek() : ť�� ù��° ��, ù��° �ϼ� �������� ��¥�� �ι�° ��¥���� ũ�ų� ������ �ݺ�
            while(!queue.isEmpty() && day >= queue.peek()){ 
                queue.poll(); // �ι�° ���μ��� ������ �Ʒ� ī��Ʈ�� �߰�
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