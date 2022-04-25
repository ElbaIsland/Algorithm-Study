package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 220413 review (프로그래머스 - 해시)
 * 2. 전화번호 목록
 * 
 * 
 */

public class Price_Of_Jusik {
    public int[] solution(int[] prices) {
     
        Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 
        
        for(int i = 0; i < prices.length; i++){
            
            // 감소하는 값이 등장한다면 주식이 감소한 시점이므로 stack에서 해당 인덱스를 제거하고, 
            // i(현재 주식의 감소 시점) - stack.peek(주식이 처음 들어간 시점) 값을 ans[stack.peek]값에 넣어준다
            while(prices[i] < prices[stack.peek()] && !stack.isEmpty()){
                int selectedPrice = stack.peek();
                System.out.println("selectedPrice : "  +selectedPrice);
                answer[selectedPrice] = i - selectedPrice;
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            stack.push(i); // 시간 배열을 스택에 push(실제 초-1)
        }
        
        System.out.println("stack : "  +stack);
        int[] test = {1,2,3,4,5};
        return test;
    }
    
    public static void main(String[] args) {
		
    	
    	
	}
    
    
}