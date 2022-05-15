package week23;

import java.util.*;

/* 220515 review (프로그래머스 - 완전탐색)
 * 5. 소수찾기
 * 
		**문제 설명**
		
		한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
		각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
		종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
		
		**문제 풀이**
		1. 주어진 숫자로 조합 가능한 모든 수를 조합한다.
		2. 모든 조합 숫자중 소수를 판별한다.
		
		정답해설 : https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-%EC%99%84%EC%A0%84%ED%83%90%EC%83%89-Lv-1-%EC%9E%90%EB%B0%94-Java-1
		
 * 
 */

public class FindDecimalPlaces {
    
    HashSet<Integer> numbersSet = new HashSet<>();
    
    public boolean isPrimeChk(int num) {
        // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    
    public void recursive(String combOfNum, String numbers) {
        
        // 1. 현재 조합을 set에 추가한다.(없을시 패스)
        if (!combOfNum.equals(""))
            numbersSet.add(Integer.valueOf(combOfNum)); // 앞에서 똑 뗀 숫자 조합을 hashset에 추가

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < numbers.length(); i++){
        	recursive(combOfNum + numbers.charAt(i), // i번째 글자하나 똑 떼서 추가
                numbers.substring(0, i) + numbers.substring(i + 1)); // i번째 기준 앞뒤숫자 
        }

    }    
    
    public int solution(String numbers) {
        
        // 1. 재귀함수 이동 >> 모든 조합의 숫자를 만든다.
    	recursive("", numbers);

        // 2. 소수의 개수만 센다.
        int count = 0;
        
        Iterator<Integer> it = numbersSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrimeChk(number))
                count++;
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }
}