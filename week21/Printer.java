package week21;

import java.util.*;

/* 220418 review (���α׷��ӽ� - ť)
 * 6. ������
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

        // priorities : ���� �߿䵵
        // location : ������ ����ȣ ��ġ(index)
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();

        // 1) ���� ť�� �� ������ index�� �߿䵵�� �����Ѵ�.
        for(int i = 0; i < priorities.length; i++){
            queue.add(new Task(i, priorities[i]));
        }        

        // 2) ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ ã�´�.
        while (!queue.isEmpty()){
            Task nowTask = queue.poll();

            for(Task t : queue){
                if(t.priority > nowTask.priority){  // 2-1) J���� �߿䵵�� ���� ���� �߰�
                    // ��� ���, �ٽ� �־��ֱ�
                //  System.out.println("�� ���� �켱���� �߰�, " + nowTask.location + "�� �ε��� ���� �ǵڷ�..");
                    queue.offer(nowTask);
                    nowTask = null;
                    break;
                }               
            }

            // 2-2) nowTask�� null�� �ƴϴ� => �߿䵵�� �� ���� ������ ����(nowTask�� �߿䵵 ���� ����)
            if(nowTask != null){
                answer++; // �ٽ� ť�� ���� �ʰ�, �״�� �μ��Ѵ�.(�μ���� ++)
                if(nowTask.location == location){ // ����, nowtask�� J��� �״�� ��� ����!
                    return answer;
                }
            }
        }          
        return answer;
    }
}

// nowTask�� ���� nulló�����θ� ���� �߿䵵 üũ�� �� �κ��� �������� ���ߴ�...