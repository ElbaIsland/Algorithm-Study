package week08;

import java.util.*;

public class TheExam {
    public int solution(int[] citations) {
        
        // �� ������ �ϸ�, �ο�� ���� h�� �̻��� ��츸 check�ϸ� ��
        // (���ĵ� �迭 ����, �հ��� ���� & �ް��� �̻�)
        Arrays.sort(citations);
        int answer = 0;
        
        for(int i = 0; i < citations.length; i++){
            
            // h�� �ִ밪���� �ٿ����鼭, h-index �ִ� count
            int h = citations.length-i;
            
            System.out.println("h : " + h + ", citations" + i + " : " + citations[i]);
            
            // �� �ο�Ƚ��(citations)�� h �̻����� Ȯ��
            if(citations[i] >= h){
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}