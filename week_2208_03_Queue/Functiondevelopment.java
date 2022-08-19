package week_2208_03_Queue;

import java.util.*;

/* ====================
 * 
 * ====================
   ��Ʈ�ڵ�(LeetCode) 136�� ���� �̱۳ѹ�
 
 - ���� : �־��� �迭���� �ߺ��� �ƴ� �� �ϳ��� ���ڸ� ã�� ����
 - Ǯ�� : 
   1) �־��� int[] �迭�� �����Ѵ�. / ������ �����.
   2) for���� ����, ���ÿ��� ����(peek) ���� ���� ������ �ش��ϴ� ���� ��ġ ���θ� �ľ��Ѵ�.
      - ��ġ�� ���ÿ��� ���� ������.(pop)
      - ����ġ�� ���� ������ �ش��ϴ� ���� ���ÿ� �ִ´�.(push)
   3) for���� ������ ����������, �ߺ����� ���� �� �ϳ��� ���� stack�� ���´�. �� ���� return�Ѵ�.
  
 */

public class Functiondevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // progresses : �� �۾��� ���� (�迭 ������� ���� ��)
        // speeds : �� �۾��� ���� �ӵ�
        
        // Ǯ��
        // 1) for������ progresses ���̸�ŭ �ݺ�
        // 2) while������ �� progress�� speeds�� ���ϱ� & day count, 100 �̻��� �� ��� out 
        // 3) 2)���� ���� count�� ť�� �ֱ�, ���� for�� ����
        // 4) ���� 1~3�� ������ ����, ť���� ������� �۾� ������ �������ڰ� ��
        // 5) queue�� �ϳ��� ������, progress ������� ���� ��¥�� �������ڸ� ��� return�� �迭�� �߰�
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<Integer>();
        
        for(int i = 0; i < progresses.length; i++){
            
            int cnt = 0;
            var progress = progresses[i];
            var speed = speeds[i];
            
            while(progress<100){
                progress = progress + speed;
                cnt++;
            }
            queue.add(cnt);
        }
        
        // �� ��������, ť�� 7,3,9...�̷� ������ �۾��Ϸ��� ������ ����ִ�. �� ť�� ������ ���� ť�� ���Ѵ�.
        // - �� ���ڰ� �� ũ�ų� ���� ���, return count�� ���ϰ� ť���� ���� ����
        // - �� ���ڰ� �� Ŭ ���, ���ݱ��� ���� cnt�� answer �迭�� �ִ´�.
  //      System.out.println(queue);
        
        int frontDay = queue.poll(); 
        int cnt2 = 1;
        
        while(!queue.isEmpty()){
        
            if(frontDay >= queue.peek())
            {
                cnt2++;
                queue.poll();
            }
            else
            {
                answerList.add(cnt2);
                cnt2 = 1;
                frontDay = queue.poll();
            }
        }
        answerList.add(cnt2);
        
  //    System.out.println(answerList.toString());
        
        return answerList.stream().mapToInt(i->i).toArray();
    }
}