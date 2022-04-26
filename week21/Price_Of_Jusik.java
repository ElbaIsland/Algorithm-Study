package week21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 220413 review (���α׷��ӽ� - ����)
 * 8. �ֽİ���
 * 
 * 
 */

public class Price_Of_Jusik {
    public int[] solution(int[] prices) {
     
        @SuppressWarnings("unchecked")
		Stack<Integer> stack = new Stack();
        int[] answer = new int[prices.length]; 
        
        for(int i = 0; i < prices.length; i++){
            
            // 1) �������� ���ؼ�, �����ϴ� �ֽ��� �����Ѵٸ� stack���� �ش� �ε����� �����Ѵ�.
            // 2) i(���� �ֽ��� ���� ����) - stack.peek(�ֽ��� ó�� �� ����) ���� ans[stack.peek]���� �־��ش�
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){    // isEmpty() ó�� x�� ����
                int timeBeforeFall = stack.peek();
                System.out.println("nowTime: " + i + ", timeBeforeFall : " + timeBeforeFall);
                answer[timeBeforeFall] = i - timeBeforeFall; // (������ ������)������� - ù �ֽİ��� ���� (= �ֽİ��� �����ð�)
                stack.pop(); // ���� ���߱� ������ stack���� �����Ѵ�
            }
            stack.push(i); // �ð� �迭�� ���ÿ� push(���� ��-1)
        
        }
        
        // ���� ������ ���� index == ������ ������ �������� ���� �ֽ�
        while (!stack.isEmpty()) { 
            int firstTime = stack.peek();
            answer[firstTime] = prices.length - firstTime - 1; // 1�� = 0��° �ε���, 2�� = 1��° �ε����⿡ -1 ó��
            stack.pop();
        }   
        
        System.out.println("stack : "  +stack);
        return answer;
    }
}