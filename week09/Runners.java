package week09;

import java.util.*;

public class Runners {
    public String solution(String[] participant, String[] completion) {
        
        // *** ������ �������� �ִٴ� �� �����ؼ� ����
        Map<String, Integer> runner = new HashMap<>();
        
        // 1) �����ڵ� ����ֱ�
        for(String str : participant){  
            // �������� ó��
            if(runner.get(str) != null) {
                runner.put(str, runner.get(str)+1); // �������� ����� value���� 1�� �����ش�.
            }   
            else {
                runner.put(str, 1);  
            }        
        }
        
        System.out.println(runner.values());     
        
        // 2) �����ڵ� ����
        for(String str : completion){
            // �������� ó��
            if(runner.get(str) > 0) {
                runner.put(str, runner.get(str)-1); // �������� ����� value���� 1�� ���ش�.
            } 
            else {
                 runner.remove(str);   
            } 
        }    
        
        // 3) ���� runner map Ȯ��
        //  System.out.println(runner.values());   
        
        String answer = "";
        
        for (String key : runner.keySet()) {
            if (runner.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}