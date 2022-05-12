package week23;

import java.util.*;

/* 220512 review (���α׷��ӽ� - ���ǰ��)
 * 4. ���� ū ��
 * 
		**���� ����**
		
		Leo�� ī���� �緯 ���ٰ�, �߾ӿ��� ��������� ĥ���� �ְ� (�ٱ�) �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
		Leo�� �� ī�꿡�� ���� ������ �� brown, 
		����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, 
		���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
		**���� Ǯ��**
		
		1. �߾ӿ��� �����, �׵θ� 1���� ���� => �׵θ� ���پ��� ���� ���� �����
		2. ī���� �������� x, �������� y��� �� �� ī�� �ѷ� : x+y+x+y-4(�� �𼭸�) = brown
		3. �̸� �ݴ�� �ϸ�, ī���� �ѷ� = 2(x+y)-4 = brown, (brown+4)/2 = x+y

 */

public class TheCarpet {
    public int[] solution(int brown, int yellow) {

        
        // ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
        
        int[] answer = new int[2];
        int plusXY = (brown+4)/2; // ���μ����� ��
        int mulitXY  = brown + yellow; // ��ü ī�� ����
        
        for(int i = 1; i < plusXY; i++){
            
            int j = plusXY-i;
            
            if(i * j == mulitXY){
                answer[0] = i;
                answer[1] = j;
            }
            
        }
        
        return answer;
    }
}