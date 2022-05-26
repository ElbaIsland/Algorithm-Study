package week24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/* 220518 review (프로그래머스 - DFS)
 * 7. 타겟넘버
 * 
		**문제 설명**
		n개의 음이 아닌 정수들이 있습니다.
		이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
		사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
		숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		
 * 
 */

public class TargetNumber {
    
    static int answer; // 1. answer은 전역변수로 선언. 
    
    public void dfs(int[] numbers, int target, int index, int calculatedNumber){
        
        // nowNumber를 기준으로, 현재의 값을 더하거나 뺀다. 그 다음 dfs를 다시 진행한다.
        
        // 마지막 index 도착시 값 비교
        if(index == numbers.length){
            
            if(calculatedNumber == target){ //  타겟 넘버 매칭
                answer++;
                return;
            }
            else{ //  타겟 넘버 매칭 x
                return;
            }
            
        }
        
        int nownumber = numbers[index]; //  현재 사칙연산을 진행할 number
        int postCalNumber = calculatedNumber + nownumber;
        dfs(numbers,target,index + 1,postCalNumber);    //  현재 number를 더한 값
        
        postCalNumber = calculatedNumber - nownumber;
        dfs(numbers,target,index + 1,postCalNumber);    //  현재 number를 뺀 값
    }
    
    public int solution(int[] numbers, int target) {
                
        answer = 0;
        
        // 0번째 index부터 시작
        dfs(numbers,target,0,0);
        
        return answer;
    }
}