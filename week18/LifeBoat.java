package week18;

import java.util.*;

public class LifeBoat {
    
    // people : 사람들의 몸무게 배열
    // limit : 구명보트의 무게 제한
    // 모든 사람을 구하기 위한 최소의 구명보트 수(구명보트는 2인승, 1인도 태울 수 있다!) 
    
    public int solution(int[] people, int limit) {
        
        // 1) 무게순으로 정렬
        Arrays.sort(people);
        int answer = 0;
        int index = 0;
        
        // 2) 투 포인터 풀이! 정렬 기준 맨 왼쪽 = 몸무게적은 사람, 맨 오른쪽 = 몸무게큰 사람
        // 가장 큰 몸무게부터 하나씩 감하여 for문을 돌리면 된다.
        for(int i = people.length-1; i >= index; i--){
            
            int maxWeightPerson = people[i];
            int minWeightPerson = people[index];
            System.out.println("maxWeight : " + maxWeightPerson
                               + ", minWeight : " + minWeightPerson);
            // 가장 뚱뚱 + 마른 두명을 같이 태울 수 있는지 판별
            // 불가능할 시 1명만 태운다.
            if(maxWeightPerson + minWeightPerson > limit){
                answer++;
            }
            else{
                index++;
                answer++;
            }
            System.out.println("for end, answer : " + answer + ", index : " + index);
        }
        
        
        return answer;
    }
}