package week07;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {        
        

 		int answer = 0;
		int endpoint = 0; // ����ǰ� ������ �ð�(����Ʈ)
		int index = 0; // jobs �迭�� �ε���
		int count = 0; // ����� ��û ����

		// ���� �迭 �������� ���� (��û�ð� ���� ��������)
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// ó���ð� ���� ������������ ���ĵǴ� �켱���� ť(Heap)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        
		// ��û�� ��� ����� ������ �ݺ�
    // for���� �ƴ� while���� ����ϵ�, index�� ���������� ����
		while (count < jobs.length) {

			// �ϳ��� �۾��� �Ϸ�Ǵ� ����(endpoint)���� ���� ��� ��û�� ť�� ����
			// �ι�° ���ǹ��� ������ Ʋ���� ����� ��??
			while (index < jobs.length && jobs[index][0] <= endpoint) {
				pq.add(jobs[index++]);
			}

			// ť�� ����ִٸ� �۾� �Ϸ�(endpoint) ���Ŀ� �ٽ� ��û�� ���´ٴ� �ǹ�
			// (endpoint�� ���� �۾����� �Ű���)
			if (pq.isEmpty()) {
				endpoint = jobs[index][0];

			// �۾��� ������ ��(endpoint ����) ���� ��û �� ���� ����ð��� ª�� ��û���� ����
			}
      else {

        //  1) �ش� ��û�� ť���� ���� temp�� ����
        //  temp[0] = ��û����, temp[1] = ó���ð�
				int[] temp = pq.poll(); 
				answer += temp[1] + endpoint - temp[0]; // ���� endpoint ���� �� �ɸ��ð� output
				endpoint += temp[1];    //  endpoint �缼��
				count++;    //  ��û���� +
			}
		}

		return (int) Math.floor(answer / jobs.length);       
        
    }
}
