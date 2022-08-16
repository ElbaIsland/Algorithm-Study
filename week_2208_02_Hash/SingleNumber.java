package week_2208_02_Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* ====================
 * 
 * ====================
   ��Ʈ�ڵ�(LeetCode) 136�� ���� �̱۳ѹ�
 
 - ���� : �־��� �迭���� �ߺ��� �ƴ� �� �ϳ��� ���ڸ� ã�� ����
 - Ǯ�� : 
   1) �־��� int[] �迭�� �����Ѵ�. / ������ �����.
   2) for���� ����, ���ÿ��� ����(peek) ���� ���� ������ �ش��ϴ� ���� ��ġ ���θ� �ľ��Ѵ�.
      - ��ġ�� ���ÿ��� ���� ������.(pop)
      - ����ġ�� ���� ������ �ش��ϴ� ���� ���ÿ� �ִ´�.(push)
   3) for���� ������ ����������, �ߺ����� ���� �� �ϳ��� ���� stack�� ���´�. �� ���� return�Ѵ�.
  
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
