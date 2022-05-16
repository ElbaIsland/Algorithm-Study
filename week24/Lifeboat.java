package week24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 220516 review (프로그래머스 - 탐욕법)
 * 4. 구명보트
 * 
		**문제 설명**
		무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
		구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
		사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
		모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
		구명보트가 2인승이라는 것은, 한명만 태워도 된다는 뜻이다
		
		**문제 풀이**
		
		
 * 
 */

public class Lifeboat {
    
    // people : 사람들의 몸무게 배열
    // limit : 구명보트의 무게 제한
    // 모든 사람을 구하기 위한 최소의 구명보트 수(구명보트는 2인승, 1인도 태울 수 있다.) 
    
    public int solution(int[] people, int limit) {
        
        // 1) 무게순으로 정렬
        Arrays.sort(people);
        int answer = 0;
        int index = 0;
        
        // 2) 투 포인터 풀이! 정렬 기준 맨 왼쪽 = 몸무게적은 사람, 맨 오른쪽 = 몸무게큰 사람
        // 가장 큰 몸무게부터 하나씩 감하여 for문을 돌리면 된다.
        for(int i = people.length-1; i >= index; i--){
            
            int minimum = people[index];
            int maximum = people[i];
            
            if(minimum + maximum > limit){
                answer++;
            }
            else{
                index++; 
                answer++;
            }
        }
        
        return answer;
    }
}