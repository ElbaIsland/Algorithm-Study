package week14;

import java.util.*;

public class ExpresstionByN {
	
    static int n;
    static int targetNumber;
    static int answer = Integer.MAX_VALUE;  //  �ִ밪 �⺻ ����

    public int solution(int N, int number) {
        
        // n : �־��� ����, (target)Number : ��Ģ������ ���� ��ǥ ����
        n = N;
        targetNumber = number;
        dfs(0, 0);        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int count, int prev) { //  count : n���Ƚ��, prev : ���� dfs ���갪
        
        // (����)�ּڰ��� 8���� ũ�� -1�� return �մϴ�.
        if (count > 8) {  
            answer = -1;
            return;
        }

        // ���� dfs���� ��ǥ���� �����ϸ�
        if (prev == targetNumber) {
            // ó�� answer : �ִ� ���ڰ��̹Ƿ� count�� answer�� ����, 
            // ���� answer : ó�� �� count���� ���� dfs�� ���� count���� ���� answer ����
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
       
        // 8 > 7 > 6..���� �����ϸ鼭 dfs �� ����(�ִ� 8��)
        // �� �������� ��Ģ���� 4���� + ���� �̾���̱� ����
        for (int i = 0; i < 8 - count; i++) {  
            int plusCount = count + i + 1;
            dfs(plusCount, prev + tempN);
            dfs(plusCount, prev - tempN);
            dfs(plusCount, prev / tempN);
            dfs(plusCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
        
        
    }
   
}