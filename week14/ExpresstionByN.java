package week14;

import java.util.*;

public class ExpresstionByN {
	
    static int n;
    static int targetNumber;
    static int answer = Integer.MAX_VALUE;  //  최대값 기본 세팅

    public int solution(int N, int number) {
        
        // n : 주어진 숫자, (target)Number : 사칙연산을 통한 목표 숫자
        n = N;
        targetNumber = number;
        dfs(0, 0);        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int count, int prev) { //  count : n사용횟수, prev : 이전 dfs 연산값
        
        // (연산)최솟값이 8보다 크면 -1을 return 합니다.
        if (count > 8) {  
            answer = -1;
            return;
        }

        // 이전 dfs값이 목표값과 동일하면
        if (prev == targetNumber) {
            // 처음 answer : 최대 숫자값이므로 count가 answer로 들어가고, 
            // 이후 answer : 처음 들어간 count값과 이후 dfs를 통한 count값을 비교해 answer 세팅
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
       
        // 8 > 7 > 6..으로 감소하면서 dfs 쭉 진행(최대 8번)
        // 각 가지별로 사칙연산 4가지 + 숫자 이어붙이기 진행
        for (int i = 0; i < 8 - count; i++) {  
            int plusCount = count + i + 1;
            dfs(plusCount, prev + tempN);
            dfs(plusCount, prev - tempN);
            dfs(plusCount, prev / tempN);
            dfs(plusCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
        
        
    }
   
}