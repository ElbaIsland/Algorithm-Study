package week24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/* 220524 review (프로그래머스 - 탐욕법)
 * 3. 큰 수 만들기
 * 
		**문제 설명**
		
		**문제 풀이**
		
		
 * 
 */

public class MakeBigNumb {
    
    // * 문제 힌트 : k개의 수를 제거했을 때 가장 큰 수 + 각 자릿수는 그대로 고정
    //   => 최소한 number.length - k 값에 해당하는 각 자릿수는 남아있어야 한다.
    // ex) 4(1924) - 2 = 2, 따라서 2 中 1의자리인 4는 고정이며 나머지 1,9,2 中 최댓값 확인
    
    public String solution(String number, int k) {
        
        char[] chArr = new char[number.length() - k];
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < number.length(); i++){
            char ch = number.charAt(i); // 해당 index char

            // stack의 맨 위 값이 ch보다 적은 수일때 + k값이 아직 양수일때 반복해서 pop
            // 즉, top보다 큰값이면 pop
            while (!stack.isEmpty() && stack.peek() < ch && k-- > 0) { 
                stack.pop(); 
            }
            stack.push(ch);
        }
        
        for (int i=0; i<chArr.length; i++) {
            chArr[i] = stack.get(i);
        }
        
        String answer = new String(chArr);
        return answer;
    }
    
}