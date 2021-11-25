package week07;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {        
        

 		int answer = 0;
		int endpoint = 0; // 수행되고난 직후의 시간(포인트)
		int index = 0; // jobs 배열의 인덱스
		int count = 0; // 수행된 요청 갯수

		// 원본 배열 오름차순 정렬 (요청시간 기준 오름차순)
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		// 처리시간 기준 오름차순으로 정렬되는 우선순위 큐(Heap)
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        
		// 요청이 모두 수행될 때까지 반복
    // for문이 아닌 while문을 사용하되, index를 가변적으로 설정
		while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(endpoint)까지 들어온 모든 요청을 큐에 넣음
			// 두번째 조건문이 없을시 틀리는 경우의 수??
			while (index < jobs.length && jobs[index][0] <= endpoint) {
				pq.add(jobs[index++]);
			}

			// 큐가 비어있다면 작업 완료(endpoint) 이후에 다시 요청이 들어온다는 의미
			// (endpoint를 이후 작업으로 옮겨줌)
			if (pq.isEmpty()) {
				endpoint = jobs[index][0];

			// 작업이 끝나기 전(endpoint 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			}
      else {

        //  1) 해당 요청을 큐에서 꺼내 temp에 저장
        //  temp[0] = 요청시점, temp[1] = 처리시간
				int[] temp = pq.poll(); 
				answer += temp[1] + endpoint - temp[0]; // 현재 endpoint 기준 총 걸린시간 output
				endpoint += temp[1];    //  endpoint 재세팅
				count++;    //  요청개수 +
			}
		}

		return (int) Math.floor(answer / jobs.length);       
        
    }
}
