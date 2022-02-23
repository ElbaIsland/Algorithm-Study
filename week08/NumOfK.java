package week08;

import java.util.*;

public class NumOfK {
    public int[] solution(int[] array, int[][] commands) {
        
        // 프로그래머스 > 정렬 > K번째 수(https://programmers.co.kr/learn/courses/30/lessons/42748)
        // 설명 : 1) array의 i번째 수 부터 j번째 수 까지 자르고자 할 때, k번째의 숫자가 무엇인지 구한다.
        //        2) commands 배열의 길이만큼 반복하여 각 k번째 수를 구하고, 그 값을 return한다.
        
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            
            int startPoint = commands[i][0];
            int endPoint = commands[i][1];
            int kPoint = commands[i][2];
            int[] newArray = Arrays.copyOfRange(array, startPoint-1, endPoint);
            Arrays.sort(newArray);
            
         // System.out.println(Arrays.toString(newArray));
            
            answer[i] = newArray[kPoint-1];
            
        }

        return answer;
    }
}
