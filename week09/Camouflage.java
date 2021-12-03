package week09;

import java.util.*;

public class Camouflage {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        int headgear = 0;
        
        Map<String, Integer> spyCloths = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){        
            if(spyCloths.containsKey(clothes[i][1])){
                spyCloths.put(clothes[i][1], spyCloths.get(clothes[i][1]) + 1);
            }
            else {
                spyCloths.put(clothes[i][1], 1);
            }  
        }
        
// 상의의 수를 A 하의의 수를 B라고 하면 상의와 하의의 조합하는 경우의 수는 A * B입니다.
// 이 때 상의만 선택하고 하의는 선택하지 않을 수도, 하의만 선택하고 상의를 선택하지 않을 수도 있습니다.   // 때문에 (A+1)*(B+1)의 경우의 수가 나옵니다.
// 여기서 아무것도 입지 않는 수가 있을 수 있기 때문에 최종적으로 -1   
// =====> value값들을 count해서 계산 ㄱㄱ
       
        for (String mapkey : spyCloths.keySet()){
            int count = spyCloths.get(mapkey);
            answer *= (count+1);
        }
        
        return answer-1;
    }
}