package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 220413 review (프로그래머스 - 스택)
 * 8. 주식가격
 * 
 * 
 */

public class Price_Of_Jusik {
    public int[] solution(int[] prices) {
     
        @SuppressWarnings("unchecked")
		Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 
        
        for(int i = 0; i < prices.length; i++){
            
            // 1) 이전값과 비교해서, 감소하는 주식이 등장한다면 stack에서 해당 인덱스를 제거한다.
            // 2) i(현재 주식의 감소 시점) - stack.peek(주식이 처음 들어간 시점) 값을 ans[stack.peek]값에 넣어준다
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){    // isEmpty() 처리 x시 에러
                int timeBeforeFall = stack.peek();
                System.out.println("nowTime: " + i + ", timeBeforeFall : " + timeBeforeFall);
                answer[timeBeforeFall] = i - timeBeforeFall; // (가격이 떨어진)현재시점 - 첫 주식가격 시점 (= 주식가격 유지시간)
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            stack.push(i); // 시간 배열을 스택에 push(실제 초-1)
        
        }
        
        // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
        while (!stack.isEmpty()) { 
            int firstTime = stack.peek();
            answer[firstTime] = prices.length - firstTime - 1; // 1초 = 0번째 인덱스, 2초 = 1번째 인덱스기에 -1 처리
            stack.pop();
        }   
        
        System.out.println("stack : "  +stack);
        return answer;
    }
}