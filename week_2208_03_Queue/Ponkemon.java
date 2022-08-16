package week_2208_03_Queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* ====================
 * 
 * ====================
   프로그래머스 해시 문제 폰켓몬
 
   최대한 많은 종류의 푸키먼을 선택하는 방법 찾기
   풀이
   1) for문을 돌리면서 스택에 푸키먼 저장 + count +
   2) for문의 푸키먼과 스택에 푸키먼이 겹칠 경우 count X
   3) 푸키먼 count가 전체 푸키먼의 절반에 도달하면 break
   
   참고
   1. final (상수) : 가변적이지 않은, 고정값 변수에 대해서는 final을 붙여 구분짓는게 좋다.
   2. var (타입추론) : java 9버전 이상부터 가능, 뒷부분변수를 확인한 뒤 자동으로 타입을 지정해준다.
  
 */
public class Ponkemon {
    public int solution(int[] nums) {
         
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack();
        int answer = 0;     //  푸키먼 count
        
        for(int i = 0; i < nums.length; i++){
            
            // answer 값이 nums 길이의 절반에 도달하면 for문 종료
            if(answer == nums.length/2){
                break;
            }
            else if(!stack.isEmpty() && nums[i] == stack.peek()){
               continue;   //  다음 for문으로 pass
            }
            
            stack.push(nums[i]);
            answer++;
        }
        return answer;
    }
}