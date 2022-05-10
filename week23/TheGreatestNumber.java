package week23;

import java.util.*;

/* 220510 review (프로그래머스 - 정렬)
 * 2. 가장 큰 수
 * 
		**문제 설명**
		
		0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
		0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
		 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		1. 주어진 정수 베열을 문자열 배열로 변환한다.
		2. 순서를 재배치하여 만들 수 있는 가장 큰 수의 정렬대로 문자열 배열을 정렬한다.
		- comparator 인터페이스 활용
		- 하나의 문자열만 판별하는 것이 아닌, 앞뒤 문자열을 붙였을 때 가장 큰 수대로 정렬한다.
		- 그렇게 해야 앞자리부터 순서대로 가장 큰 숫자가 위치하게 된다.
		3. (*** 0으로만 이루어진 정수 배열에 대한 예외처리를 한다.)
		4.  위에서 정렬된 문자열 배열을 하나의 문자로 합친다.
		
		**(※ comparator 인터페이스와 comparable 인터페이스 공부할 것!)**
 */

public class TheGreatestNumber {
    public String solution(int[] numbers) {
        
        // 정수를 문자열로 변환 후, 이어붙여서 계산
        
        String answer = "";
        String strNumbers[] = new String[numbers.length];
      
        // 각 numbers[i]마다 문자열로 변환
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                // 앞뒤 문자열을 '붙인 뒤' 크기비교한다.
                // 이를 통해, 합쳤을때 온전히 큰 수가 return된다!
                // 내림차순 : (o2+o1).compareTo(o1+o2);
                // 오름차순 : (o1+o2).compareTo(o1+o2);
                return (o2+o1).compareTo(o1+o2); 
            } 
        });
        
        // System.out.println("af strNumbers : " + Arrays.toString(strNumbers));
        
        // ==> 이전 정렬 case
        //  문자열 정렬 명령어(string인데도 가능!!)
        // Arrays.sort(strNumbers, (s1,s2) -> (s2+s1).compareTo(s1+s2));
        
        //0값이 중복일경우 ex){0,0,0}
        //답이 000이 나오면 안되므로 첫번째값이 0이면 0을 리턴
        if (strNumbers[0].equals("0")) return "0";

        for(String str : strNumbers){
            answer += str;
        }

        return answer;
    }
}