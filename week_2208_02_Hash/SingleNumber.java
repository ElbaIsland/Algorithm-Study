package week_2208_02_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* ====================
 * 
 * ====================
   리트코드(LeetCode) 136번 문제 싱글넘버
 
 - 문제 : 주어진 배열에서 중복이 아닌 단 하나의 숫자를 찾는 문제
 - 풀이 : 
   1) 주어진 int[] 배열을 정렬한다. / 스택을 만든다.
   2) for문을 돌려, 스택에서 꺼낸(peek) 수와 현재 순서에 해당하는 수의 일치 여부를 파악한다.
      - 일치시 스택에서 값을 꺼낸다.(pop)
      - 불일치시 현재 순서에 해당하는 값을 스택에 넣는다.(push)
   3) for문이 끝나는 시점에서는, 중복되지 않은 단 하나의 수만 stack에 남는다. 그 수를 return한다.
  
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {     
        
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < nums.length; i++){        
            
            if(!stack.isEmpty() && nums[i] == stack.peek()){
                stack.pop();
            }    
            else stack.push(nums[i]);
   
        }

        return stack.peek();
    }
}
