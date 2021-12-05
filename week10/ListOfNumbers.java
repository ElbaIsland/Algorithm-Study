package week10;

import java.util.*;

public class ListOfNumbers {
    
    static int answer; // 1. answer�� ���������� ����.
    
    // 2. dfs(numbers, target:��ǥ��, idx:�� ��° �ε�������, sum: idx���� ������ ��).
    public void dfs(int[] numbers,int target,int idx,int sum){
        
        System.out.println("idx : " + idx);
        
        // 3. ��� ������ Ž������ ��(ù��°~������)
        if(idx == numbers.length){   
            // 4. ������ target ������ �����ϸ� answer++ �� �޼ҵ� ����.
            if(sum == target){
                answer++;
                System.out.println("answer�� case �߰�");
            }
            System.out.println("=========�޼ҵ� ����=========");
            return;
        }
        
        // 5. ���� �ε����� ������ sum�� +�� �����ش�.
        sum += numbers[idx];
        
        // 6. ���� �ε��� dfs ����~~������ �ݺ�
        System.out.println("+" + numbers[idx] + " >> sum : " + sum);
        dfs(numbers,target,idx+1,sum);
    
        
        // 7. 5.�� ���� �ٽ� ���� ��,
        sum -= numbers[idx];
        
        // 8. ���� �ε����� ������ -�� �����ش�. (�� ���� index�� ������ ���ش�)
        sum += (-1 * numbers[idx]);
        
        // 9. �ٽ� ���� �ε��� dfs ����~~������ �ݺ�
         System.out.println("-" + numbers[idx] + " >> sum : " + sum);
        dfs(numbers,target,idx+1,sum);

    }
    
    public int solution(int[] numbers, int target) {
                
        answer = 0;
        
        // 0��° index���� ����
        dfs(numbers,target,0,0);
        
        return answer;
    }
}