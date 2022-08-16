package week_2208_03_Queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* ====================
 * 
 * ====================
   ���α׷��ӽ� �ؽ� ���� ���ϸ�
 
   �ִ��� ���� ������ ǪŰ���� �����ϴ� ��� ã��
   Ǯ��
   1) for���� �����鼭 ���ÿ� ǪŰ�� ���� + count +
   2) for���� ǪŰ�հ� ���ÿ� ǪŰ���� ��ĥ ��� count X
   3) ǪŰ�� count�� ��ü ǪŰ���� ���ݿ� �����ϸ� break
   
   ����
   1. final (���) : ���������� ����, ������ ������ ���ؼ��� final�� �ٿ� �������°� ����.
   2. var (Ÿ���߷�) : java 9���� �̻���� ����, �޺κк����� Ȯ���� �� �ڵ����� Ÿ���� �������ش�.
  
 */
public class Ponkemon {
    public int solution(int[] nums) {
         
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack();
        int answer = 0;     //  ǪŰ�� count
        
        for(int i = 0; i < nums.length; i++){
            
            // answer ���� nums ������ ���ݿ� �����ϸ� for�� ����
            if(answer == nums.length/2){
                break;
            }
            else if(!stack.isEmpty() && nums[i] == stack.peek()){
               continue;   //  ���� for������ pass
            }
            
            stack.push(nums[i]);
            answer++;
        }
        return answer;
    }
}