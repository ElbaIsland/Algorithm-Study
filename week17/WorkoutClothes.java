package week17;

import java.util.*;

public class WorkoutClothes {
	
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        
        // n : �л���, lost : ü���� �����л� ��ȣ, reserve : ü���� �����л� ��ȣ
        // ü�������� ���� �� �ִ� �л��� �ִ��� return
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // ���� ü������ ������ �л��� �������� ��� �� �̵����־�
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        
        // ���������� ü���� �����ִ� ���
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1){
                    answer++;
//                    lost[i] = 0;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }        
        
        return answer;
    }
}