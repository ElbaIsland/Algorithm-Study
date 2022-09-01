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
     
        // price �迭�� �� �ֽİ����� ��������, ������ �������� �ʴ� ������ �ľ��Ͽ� count
        // ��¥(���������Ⱓ) = �迭�� index������ Ȱ�� 
        // 1) for������ price �迭�� index�� ���ÿ� ����
        // 2) �� �ֽİ��� ���� ������� �� ���
        //   - ���� price�� ���� index�� price�� ��, 
        //     ������ �������� �ʾҴٸ�(���� ������ �� ŭ) price 
        
        Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 

        // 1) �� Ǯ��
        for(int i = 0; i < prices.length; i++ ){
            for(int j = i+1; j < prices.length; j++){
                System.out.println("[i] : " + i + ", answer[i] : " + answer[i]);
                answer[i]++;    //  ���� �ϳ��� ++
                //  prices[0]~prices[4], prices[1]~prices[4]...�� price�� �������� ���� ��
                // (������ index�� 2��for�������� x => ������ 0��ä�� output)
                if(prices[i] > prices[j]){  
                    break;
                }
            }
        }
        
       // 2) stack Ȱ�� ���Ǯ��
/*		 for(int i = 0; i < prices.length; i++){
		    
		     while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
		         answer[stack.peek()] = i - stack.peek(); // �ֽ��� ������ ������ ����
		         stack.pop();
		     }
		     stack.push(i);  //  �� index�� stack ����
		 }        
		
		 while (!stack.isEmpty()) { // ���� ������ ���� index == ������ ������ �������� ���� �ֽ�
		     answer[stack.peek()] = prices.length - stack.peek() - 1;
		     stack.pop();
		 }
*/        
   
        return answer;
    }
}