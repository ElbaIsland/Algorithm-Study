package week24;

import java.util.*;

/* 220516 review (프로그래머스 - 탐욕법)
 * 1. 체육복
 * 
		**문제 설명**
		여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
		학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
		전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
		여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
		체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
		※ 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
		  이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
		
		**문제 풀이**
		
		
 * 
 */

public class WorkoutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 도난당한 학생 번호 input
        HashSet<Integer> lostStudent = new HashSet<Integer>();
        for(int i = 0; i < lost.length; i++){
            lostStudent.add(lost[i]);
        }
        

        for(int i = 0; i < reserve.length; i++){
            // 여벌 인간 = 잃어버린 인간
            if(lostStudent.contains(reserve[i])){
                lostStudent.remove(reserve[i]); // 얻었으니 제거
                reserve[i] = -1;    // 여분 주었으므로 제거(존재하지 않는 번호로 처리)  
                answer++; 
            }
        }
        
        // 
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i] == -1){
                continue;
            }

            // 앞사람 중 도난당한 학생 발견
            if(reserve[i] > 1  && lostStudent.contains(reserve[i]-1)){
                lostStudent.remove(reserve[i]-1); // 얻었으니 제거
                answer++;
            }
            // 뒷사람 중 도난당한 학생 발견
            else if(lostStudent.contains(reserve[i]+1)){ 
                lostStudent.remove(reserve[i]+1); // 얻었으니 제거
                answer++;
            }
        }
        
        return answer;
    }
}