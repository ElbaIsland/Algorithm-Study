package week19_queue_review;

import java.util.PriorityQueue;

//```<�ٽ� ���� ���� �ڵ�>
//while(�۾�����ť�� ���ť�� ������� ���� ��){
//	if(�۾����� ť�� �۾��� �ִ°�?){
//		job = �۾�����ť.poll()
//		time += job.�ҿ�ð�
//		total += time - job.���۽ð� //��¥���ð� //���� ���� ��ü��
//	}else{
//		time = ���ť.peek().���۽ð�;
//	}
//	while(���ť.peek().���۽ð� <= time){
//			�۾�����ť.offer( ���ť.pop() );
//	}
//}
//```

public class DiskController {

	public int solution(int[][] jobs) {

		PriorityQueue<int[]>  waitQueue =  new PriorityQueue<>((o1, o2) ->  o1[0] - o2[0]);
		PriorityQueue<int[]>  workQueue =  new PriorityQueue<>((o1, o2) ->  o1[1] - o2[1]);

		int totalWorkTime = 0;
		int currentTime = 0;

		for(int[] job:jobs){
				waitQueue.add(job);
		}

		while( !waitQueue.isEmpty() || !workQueue.isEmpty()) {

			if ( workQueue.isEmpty()) {
                currentTime = waitQueue.peek()[0];
			}else {
				int[] job = workQueue.poll();
                currentTime += job[1];
				totalWorkTime += currentTime - job[0];

			}

			while ( !waitQueue.isEmpty() && waitQueue.peek()[0] <= currentTime) {
                int[] job = waitQueue.poll();
				workQueue.offer(job);
			}
		}

		return (int) Math.floor(totalWorkTime / jobs.length);
	}
}
