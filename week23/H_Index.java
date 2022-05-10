package week23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 220510 review (프로그래머스 - 정렬)
 * 3. H-index
 * 
		**문제 설명**
		
		H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
		어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
		나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
		어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
		이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
		 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index이다.
		 => 전체 논문 인용 수 배열에 반복문을 돌려, h번째 index를 찾아내야 한다.
		
		1. 먼저 h번째 값을 찾기 위해 전체 논문 배열을 정렬한다. (~번 이상 인용된 -의 개수 뜨면 정렬 고)
		2. h번째 인용횟수가 h보다 크거나 같은 경우에만 h-index에 부합된다. 이 조건을 만족하는 값을 반복문을 돌려가며 찾으면 된다.
		3. h의 숫자를 먼저 배열 최대값으로 잡고, 반복문이 진행될수록 하나씩 줄여나간다.
		반대로 현재 논문 인용수는 정렬된 최소값으로 잡고, 반복문이 진행될수록 하나씩 늘려나간다
		4. 위 두개의 값이 만나는 중간값을 찾는다. 현재 반복문 값이 h값보다 크거나 같은지를 확인한다.
		5. 해당하는 값일 경우, 현재 h번째 index가 정답이 된다!
		(조건에 처음으로 만족하는 순간이 h의 최대값이다.)
 * 
 */

public class H_Index {
    public int solution(int[] citations) {
        
        // 1) 정렬 후
        Arrays.sort(citations);
        int h= 0;
        
        // 2) h번째 인용횟수, 즉 h번째 index를 찾아가는 과정을 작성한다.
        for(int i = 0; i < citations.length; i++){
            
            // h번째 인용횟수가 h보다 크거나 같은 논문의 숫자
            h = citations.length-i;
  
            // 현재 반복문 값이 h값보다 큰지를 체크
            if(citations[i] >= h){
            //    System.out.println("citations[i] : " + citations[i] + ", h : " + h);
                return h;
            }
            
        } 
    
        return h;
    }
}