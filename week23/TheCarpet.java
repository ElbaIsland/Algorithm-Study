package week23;

import java.util.*;

/* 220512 review (프로그래머스 - 모의고사)
 * 4. 가장 큰 수
 * 
		**문제 설명**
		
		Leo는 카펫을 사러 갔다가, 중앙에는 노란색으로 칠해져 있고 (바깥) 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
		Leo가 본 카펫에서 갈색 격자의 수 brown, 
		노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 
		세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		1. 중앙에는 노란색, 테두리 1줄은 갈색 => 테두리 한줄씩만 빼고 전부 노란색
		2. 카펫의 가로축을 x, 세로축을 y라고 할 시 카펫 둘레 : x+y+x+y-4(각 모서리) = brown
		3. 이를 반대로 하면, 카펫의 둘레 = 2(x+y)-4 = brown, (brown+4)/2 = x+y

 */

public class TheCarpet {
    public int[] solution(int brown, int yellow) {

        
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
        
        int[] answer = new int[2];
        int plusXY = (brown+4)/2; // 가로세로의 합
        int mulitXY  = brown + yellow; // 전체 카펫 개수
        
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