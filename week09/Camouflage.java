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
        
// ������ ���� A ������ ���� B��� �ϸ� ���ǿ� ������ �����ϴ� ����� ���� A * B�Դϴ�.
// �� �� ���Ǹ� �����ϰ� ���Ǵ� �������� ���� ����, ���Ǹ� �����ϰ� ���Ǹ� �������� ���� ���� �ֽ��ϴ�.   // ������ (A+1)*(B+1)�� ����� ���� ���ɴϴ�.
// ���⼭ �ƹ��͵� ���� �ʴ� ���� ���� �� �ֱ� ������ ���������� -1   
// =====> value������ count�ؼ� ��� ����
       
        for (String mapkey : spyCloths.keySet()){
            int count = spyCloths.get(mapkey);
            answer *= (count+1);
        }
        
        return answer-1;
    }
}