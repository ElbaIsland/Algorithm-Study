package week23;

import java.util.*;

/* 220510 review (프로그래머스 - 정렬)
 * 1. k번째 수
 * 
		**문제 설명**
		
		배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
		 commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		1. 반복문을 돌려 배열 commands의 각 i, j, k를 변수로 설정한다.
		2. 해당 반복문의 연산결과를 **Arrays.copyOfRange** 명령어를 통해 잘라 새로운 변수 배열에 저장한다.
		3. 위에서 연산결과를 정렬한 뒤 정답 결과 배열에 추가한다.
		4. 위 과정을 반복한다.
 */

public class NumberOfK {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++){
            
            int startPoint = commands[i][0];
            int endPoint = commands[i][1];
            int answerPoint = commands[i][2];
            int[] answerArray = Arrays.copyOfRange(array, startPoint-1, endPoint);
            Arrays.sort(answerArray);
       //     System.out.println(Arrays.toString(answerArray));
            
            answer[i] = answerArray[answerPoint-1];
    
        }
       
        return answer;
    }
}