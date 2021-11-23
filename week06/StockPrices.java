package week06;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrices {

    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length]; // 1,2,3,2,3

        for(int i = 0; i < prices.length; i++ ){
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;    //  ���� �ϳ��� ++
                
                //  prices[0]~prices[4], prices[1]~prices[4]...��
                // (������ index�� 2��for�������� x => ������ 0��ä�� output)
                if(prices[i] > prices[j]){  
                    break;
                }
            }
        }

//         ������ Ȱ���� Ǯ�� : ��¥(���������Ⱓ) = �� �迭�� index������ Ȱ�� 
//         Stack<Integer> stack = new Stack();
        
//         for (int i = 0; i < prices.length; i++) {
//             while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
//                 answer[stack.peek()] = i - stack.peek();
//                 stack.pop();  // ���� ���߱� ������ stack���� ����
//             }
//             stack.push(i);
//         }

//         while (!stack.isEmpty()) { // ���� ������ ���� index == ������ ������ �������� ���� �ֽ�
//             answer[stack.peek()] = prices.length - stack.peek() - 1;
//             stack.pop();
//         }       
        
        return answer;
    }
	
}
