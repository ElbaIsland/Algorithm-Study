package week24;

import java.util.*;

/* 220516 review (���α׷��ӽ� - Ž���)
 * 1. ü����
 * 
		**���� ����**
		���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�.
		�л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�.
		��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, 
		������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, 
		ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		�� ���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. 
		  �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
		
		**���� Ǯ��**
		
		
 * 
 */

public class WorkoutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // �������� �л� ��ȣ input
        HashSet<Integer> lostStudent = new HashSet<Integer>();
        for(int i = 0; i < lost.length; i++){
            lostStudent.add(lost[i]);
        }
        

        for(int i = 0; i < reserve.length; i++){
            // ���� �ΰ� = �Ҿ���� �ΰ�
            if(lostStudent.contains(reserve[i])){
                lostStudent.remove(reserve[i]); // ������� ����
                reserve[i] = -1;    // ���� �־����Ƿ� ����(�������� �ʴ� ��ȣ�� ó��)  
                answer++; 
            }
        }
        
        // 
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i] == -1){
                continue;
            }

            // �ջ�� �� �������� �л� �߰�
            if(reserve[i] > 1  && lostStudent.contains(reserve[i]-1)){
                lostStudent.remove(reserve[i]-1); // ������� ����
                answer++;
            }
            // �޻�� �� �������� �л� �߰�
            else if(lostStudent.contains(reserve[i]+1)){ 
                lostStudent.remove(reserve[i]+1); // ������� ����
                answer++;
            }
        }
        
        return answer;
    }
}