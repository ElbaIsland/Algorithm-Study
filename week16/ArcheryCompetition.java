package week16;

import java.util.*;

public class ArcheryCompetition {
	
    int[] lionShotsEachScore = new int[11]; // 0~10점 총 11개 점수
    int[] answer = {-1}; // 3) (무조건 지거나 비기는 경우)는 [-1]을 return 
    int max = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        
        // n : 쏘는 화살의 갯수
        // info : 어피치가 점수별 맞춘 화살의 갯수(0~10 총 11 index)
        // 라이언이 각 점수에 대한 과녁을 맞추거나 안맞추거나 둘중에 하나를 하는 로직으로 문제를 풀어야함
        // 라이언은 어피치가 쏜 갯수의 +1 만큼 더 맞추거나 안맞추거나 해야한다.
        // 이때, 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를            10점부터 0점까지 순서대로 정수 배열에 담아 return        
        
        // dfs(총 화살발사 개수, 라이언 화살 발사, info 배열);
        dfs(n, 1, info);
        
        // if(answer[0] == undefiend){
        //     answer[0] = -1;
        // }
        
        return answer;
    }

    public void dfs(int n, int ShotCount, int[] info){
        
        // 이전 dfs에서 라이언이 쏜 화살이 마지막 화살이라면
        // dfs를 중지하고 점수를 산정한다.
        if(ShotCount > n){
            int apeachScore = 0;
            int lionScore = 0;
            
            for(int i = 0; i < 11; i++) // 점수과녁 총 11개
            {
                // 1) 와 이 if문 씹 마지막 10-i 무냐구
                // 둘 중 한명이라도 과녁을 맞쳤다면
                if(info[i] != 0 || lionShotsEachScore[i] != 0) { 
                    if(info[i] < lionShotsEachScore[i]) // 라이언이 2김
                        lionScore += (10 - i);
                    else // 어피치가 2김
                        apeachScore += (10 - i);
                }
            }
            
            // 라이언이 이겼다면
            if(lionScore > apeachScore) {
                if(lionScore - apeachScore >= max)
                {
                	System.out.println("라이언 점수 in >> score :" + (lionScore - apeachScore));
                    answer = lionShotsEachScore.clone();  // 2) 클론 명령어라는게 있네..
                    max = lionScore - apeachScore; // 두놈의 점수차를 max에 넣기
                    
                }
            }
            
            return;            
            
        }
        
        // 3) dfs 적용 방식
        // 11개 점수판 + 해당 발의 lion 이 맞춘개수가 info(어피치)보다 적을때까지 반복??
        for(int j = 0; j < 11 && lionShotsEachScore[j] <= info[j]; j++) {
        	lionShotsEachScore[j]++;
       //   System.out.println(10-j + "점 라이언 맞춘개수 up >> 맞춘개수 :" + lionShotsEachScore[j]);
            dfs(n, ShotCount + 1, info);
            lionShotsEachScore[j]--;
        }
        
    }	
    
    public static void main(String[] args) {
		
    	ArcheryCompetition ar = new ArcheryCompetition();
    	int[] inputPeach = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};	//	5
    	int[] inputPeach2 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};	//	9
    	int[] inputPeach3 = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};	//	10
    	ar.solution(5, inputPeach);
    	
	}
   
}