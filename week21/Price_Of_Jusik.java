package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 220413 review (���α׷��ӽ� - �ؽ�)
 * 2. ��ȭ��ȣ ���
 * 
 * 
 */

public class Price_Of_Jusik {
    public int[] solution(int[] prices) {
     
        Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 
        
        for(int i = 0; i < prices.length; i++){
            
            // �����ϴ� ���� �����Ѵٸ� �ֽ��� ������ �����̹Ƿ� stack���� �ش� �ε����� �����ϰ�, 
            // i(���� �ֽ��� ���� ����) - stack.peek(�ֽ��� ó�� �� ����) ���� ans[stack.peek]���� �־��ش�
            while(prices[i] < prices[stack.peek()] && !stack.isEmpty()){
                int selectedPrice = stack.peek();
                System.out.println("selectedPrice : "  +selectedPrice);
                answer[selectedPrice] = i - selectedPrice;
                stack.pop(); // ���� ���߱� ������ stack���� �����Ѵ�
            }
            stack.push(i); // �ð� �迭�� ���ÿ� push(���� ��-1)
        }
        
        System.out.println("stack : "  +stack);
        int[] test = {1,2,3,4,5};
        return test;
    }
    
    public static void main(String[] args) {
		
    	
    	
	}
    
    
}