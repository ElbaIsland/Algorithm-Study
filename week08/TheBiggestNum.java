package week08;

import java.util.*;

public class TheBiggestNum {
	
// 프로그래머스 > 정렬 > 가장 큰 수(https://programmers.co.kr/learn/courses/30/lessons/42746)
// 설명 : numbers 배열로 주어진 정수를 조합해 만들 수 있는 가장 큰 수를 return한다.
	
    public String solution(int[] numbers) {
        
        String answer = "";
        String strNumbers[] = new String[numbers.length];
      
        // 1) 각 numbers[i] 정수를 문자열로 변환
        for(int i=0; i<strNumbers.length; i++) {
			    strNumbers[i] = String.valueOf(numbers[i]);
		    }
        
	//  2) 변환된 문자열을 정렬    
        //  문자열 정렬 명령어(string인데도 가능!!)
        //  내림차순 : return (s2+s1).compareTo(s1+s2);
        //  오름차순 : return (s1+s2).compareTo(s1+s2);
        //  문자열 s1과 문자열 s2가 입력되었을 때,
        //  s1이 사전적으로 s2보다 뒤에 있다면 음수(뒤바꾸기), 같다면 0, 앞에 있다면 양수(그대로)를 리턴
        Arrays.sort(strNumbers, (s1,s2) -> (s2+s1).compareTo(s1+s2));
	// ** 별선생의 꾸르팁 : 위 compareTo 메소드는 단순히 int, String 뿐만 아니라
	// 배열형태의 자료구조면 어떤 것이든 정렬이 가능하다! 
			
        //  System.out.println(Arrays.toString(strNumbers));
        
	if(strNumbers[0].equals("0")) {
		return "0";
	}

        for(String number : strNumbers){
            answer += number; 
        }

        return answer;
    }
}
