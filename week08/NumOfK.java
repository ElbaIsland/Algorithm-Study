package week08;

import java.util.*;

public class NumOfK {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            
            int startPoint = commands[i][0];
            int endPoint = commands[i][1];
            int kPoint = commands[i][2];
            int[] newArray = Arrays.copyOfRange(array, startPoint-1, endPoint);
            Arrays.sort(newArray);
            
         //   System.out.println(Arrays.toString(newArray));
            
            answer[i] = newArray[kPoint-1];
            
        }

        return answer;
    }
}
