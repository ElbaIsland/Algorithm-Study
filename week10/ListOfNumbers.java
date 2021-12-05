package week10;

import java.util.*;

public class ListOfNumbers {
    
    static int answer; // 1. answer은 전역변수로 선언.
    
    // 2. dfs(numbers, target:목표값, idx:몇 번째 인덱스인지, sum: idx까지 누적된 값).
    public void dfs(int[] numbers,int target,int idx,int sum){
        
        System.out.println("idx : " + idx);
        
        // 3. 모든 정수를 탐색했을 때(첫번째~마지막)
        if(idx == numbers.length){   
            // 4. 총합이 target 정수와 동일하면 answer++ 후 메소드 종료.
            if(sum == target){
                answer++;
                System.out.println("answer에 case 추가");
            }
            System.out.println("=========메소드 종료=========");
            return;
        }
        
        // 5. 현재 인덱스의 정수를 sum에 +로 합해준다.
        sum += numbers[idx];
        
        // 6. 다음 인덱스 dfs 수행~~끝까지 반복
        System.out.println("+" + numbers[idx] + " >> sum : " + sum);
        dfs(numbers,target,idx+1,sum);
    
        
        // 7. 5.의 값을 다시 빼준 뒤,
        sum -= numbers[idx];
        
        // 8. 현재 인덱스의 정수를 -로 합해준다. (즉 현재 index의 정수를 빼준다)
        sum += (-1 * numbers[idx]);
        
        // 9. 다시 다음 인덱스 dfs 수행~~끝까지 반복
         System.out.println("-" + numbers[idx] + " >> sum : " + sum);
        dfs(numbers,target,idx+1,sum);

    }
    
    public int solution(int[] numbers, int target) {
                
        answer = 0;
        
        // 0번째 index부터 시작
        dfs(numbers,target,0,0);
        
        return answer;
    }
}