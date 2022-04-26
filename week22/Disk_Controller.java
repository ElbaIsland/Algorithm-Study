package week22;

import java.util.*;

/* 220425 review (프로그래머스 - 힙(우선순위 큐))
 * 2. 디스크 컨트롤러
 * 
	**문제 설명**
	하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
	각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
	
	**문제 풀이**
	**아래 <핵심 로직 수도 코드>를 기억하자!!
	
	1.while(작업가능큐랑 대기큐가 비어있지 않을 때){
	 	2-1.if(작업가능 큐에 작업이 있는가?){
	 		job = 작업가능큐.poll()
	 		time += job.소요시간
	 		total += time - job.시작시간 // 총 경과시간
	 	}
		2-2.else{
	 		time = 대기큐.peek().시작시간;**
	 	}
	 	3.while(대기큐.peek().시작시간 <= time){
	 		작업가능큐.offer( 대기큐.pop() );
	 	}
	 }

	1. input으로 들어오는 priorities를 locations과 묶어 Task로 정의했다. 이 Task는 순서대로 Queue에 넣는다.
	2. Queue에서 가장 앞에 위치한 Task를 뽑아낸 뒤, 큐에 남아있는 Task를 확인해 방금 뽑은 Task보다 더 높은 우선순위를 가진 작업이 존재하는지 확인한다.
	    - 더 높은 우선순위의 작업이 큐에 존재하면 다시 큐에 넣는다.
	      (큐를 사용하기 때문에 맨 뒤로 들어간다)
	    - 뽑은 Task가 가장 큰 우선순위라면 다시 큐에 넣지 않고 인쇄하는데, 찾던 요청이면 순서를 출력하고 종료한다!
 */

public class Disk_Controller {

	public int solution(int[][] jobs) {

		// '시점' 기준 & '소요시간' 기준으로 각각 대기큐와 작업큐 생성
		PriorityQueue<int[]>  waitQueue =  new PriorityQueue<>((o1, o2) ->  o1[0] - o2[0]);
		PriorityQueue<int[]>  workQueue =  new PriorityQueue<>((o1, o2) ->  o1[1] - o2[1]);
		int totalWorkTime = 0;
		int currentTime = 0;

		// 대기큐에 작업 input
		for(int[] job:jobs){
			waitQueue.add(job);
		}

		// 1.작업가능큐랑 대기큐가 비어있지 않을 때
		while( !waitQueue.isEmpty() || !workQueue.isEmpty()) {

			if (!workQueue.isEmpty()) {  // 2-1. 작업가능 큐에 작업이 있는가?
		        int[] job = workQueue.poll(); // 작업가능큐에서 작업 빼내기
		        currentTime += job[1];        // 시간 증가
				totalWorkTime += currentTime - job[0]; // 총 경과시간
			}
			else // 2-2. 작업이 없는가?
			{
				currentTime = waitQueue.peek()[0]; // 작업이 없으면 현재값 세팅
			}

			// 3. 대기큐.peek().시작시간 <= time (** 예외처리 확인할 것)
			// 대기큐에서 꺼낸 값이 현재 시간보다 작거나 같으면 작업큐로 이동
			while ( !waitQueue.isEmpty() && waitQueue.peek()[0] <= currentTime) {
				// 작업가능큐.offer( 대기큐.pop() );
				int[] job = waitQueue.poll();
				workQueue.offer(job);
			}
		}
		return (int) Math.floor(totalWorkTime / jobs.length); // 평균시간 return
	}
}