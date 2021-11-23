package week06;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrices {

    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length]; // 1,2,3,2,3

        for(int i = 0; i < prices.length; i++ ){
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;    //  값을 하나씩 ++
                
                //  prices[0]~prices[4], prices[1]~prices[4]...비교
                // (마지막 index는 2중for문안으로 x => 무조건 0인채로 output)
                if(prices[i] > prices[j]){  
                    break;
                }
            }
        }

//         스택을 활용한 풀이 : 날짜(가격유지기간) = 각 배열의 index값임을 활용 
//         Stack<Integer> stack = new Stack();
        
//         for (int i = 0; i < prices.length; i++) {
//             while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
//                 answer[stack.peek()] = i - stack.peek();
//                 stack.pop();  // 답을 구했기 때문에 stack에서 제거
//             }
//             stack.push(i);
//         }

//         while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
//             answer[stack.peek()] = prices.length - stack.peek() - 1;
//             stack.pop();
//         }       
        
        return answer;
    }
	
}
