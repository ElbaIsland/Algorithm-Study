package week09;

import java.util.*;

public class ListOfNumbers {
    public boolean solution(String[] phone_book) {
        
        // 접두어인 경우가 '있으면 false', '없으면 true'
        boolean answer = true;
        
        Arrays.sort(phone_book);
//         int phoneNumbers[] = new int[phone_book.length];
        
//         // 각 phone_book[i] 문자열을 정수로 변환
//    for(int i=0; i<phone_book.length; i++) {
// 			phoneNumbers[i] = Integer.parseInt(phone_book[i]);
// 		}
        
        // 반복문 내부 index 기준, 이후 인덱스를 확인하여 겹치는 값 확인
        // + 인덱스를 '서로' 확인하여, for문 내부에서도 돌아가도록 확인
        for(int i = 0; i < phone_book.length; i++){       
         //   int numLength = (int).(Math.log10(phoneNumbers[i])+1);  //  숫자길이 구하기
            for(int j = i+1; j < phone_book.length; j++){
                
                // 접두어 체크
               if(phone_book[j].startsWith(phone_book[i])){ 
                   answer = false;
                   break;   //  반복문 빠져나오기
               }
                
            } // for end
                    
        } // for end
        
        return answer;
    }
}
