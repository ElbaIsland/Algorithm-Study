package week17;

import java.util.*;

public class WorkoutClothes {
	
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        
        // n : 학생수, lost : 체육복 도난학생 번호, reserve : 체육복 여분학생 번호
        // 체육수업을 들을 수 있는 학생의 최댓값을 return
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우 뭐 이딴게있어
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
        
        // 정상적으로 체육복 빌려주는 경우
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