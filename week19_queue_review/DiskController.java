package week19_queue_review;

import java.util.PriorityQueue;

//```<핵심 로직 수도 코드>
//while(작업가능큐랑 대기큐가 비어있지 않을 때){
//	if(작업가능 큐에 작업이 있는가?){
//		job = 작업가능큐.poll()
//		time += job.소요시간
//		total += time - job.시작시간 //진짜대기시간 //위랑 같은 객체임
//	}else{
//		time = 대기큐.peek().시작시간;
//	}
//	while(대기큐.peek().시작시간 <= time){
//			작업가능큐.offer( 대기큐.pop() );
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
