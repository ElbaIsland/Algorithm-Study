package week_2209_01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/* 
 * 220901
 */

public class PriceOfStock {
    public int[] solution(int[] prices) {
     
        // price 배열의 각 주식가격을 기준으로, 가격이 떨어지지 않는 시점을 파악하여 count
        // 날짜(가격유지기간) = 배열의 index값임을 활용 
        // 1) for문으로 price 배열의 index를 스택에 저장
        // 2) 각 주식가격 기준 등락여부 값 계산
        //   - 현재 price와 이전 index의 price를 비교, 
        //     가격이 떨어지지 않았다면(이전 가격이 더 큼) price 
        
        Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 

        // 1) 내 풀이
        for(int i = 0; i < prices.length; i++ ){
            for(int j = i+1; j < prices.length; j++){
                System.out.println("[i] : " + i + ", answer[i] : " + answer[i]);
                answer[i]++;    //  값을 하나씩 ++
                //  prices[0]~prices[4], prices[1]~prices[4]...각 price별 떨어지는 시점 비교
                // (마지막 index는 2중for문안으로 x => 무조건 0인채로 output)
                if(prices[i] > prices[j]){  
                    break;
                }
            }
        }
        
       // 2) stack 활용 모범풀이
/*		 for(int i = 0; i < prices.length; i++){
		    
		     while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
		         answer[stack.peek()] = i - stack.peek(); // 주식이 떨어진 시점을 저장
		         stack.pop();
		     }
		     stack.push(i);  //  각 index를 stack 저장
		 }        
		
		 while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
		     answer[stack.peek()] = prices.length - stack.peek() - 1;
		     stack.pop();
		 }
*/        
   
        return answer;
    }
}