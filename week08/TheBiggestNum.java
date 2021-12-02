package week08;

import java.util.*;

public class TheBiggestNum {
    public String solution(int[] numbers) {
        
        String answer = "";
        String strNumbers[] = new String[numbers.length];
      
        // �� numbers[i] ������ ���ڿ��� ��ȯ
        for(int i=0; i<strNumbers.length; i++) {
			    strNumbers[i] = String.valueOf(numbers[i]);
		    }
        
        //  ���ڿ� ���� ��ɾ�(string�ε��� ����!!)
        //  �������� : return (s2+s1).compareTo(s1+s2);
        //  �������� : return (s1+s2).compareTo(s1+s2);
        //  ���ڿ� s1�� ���ڿ� s2�� �ԷµǾ��� ��,
        //  s1�� ���������� s2���� �ڿ� �ִٸ� ����(�ڹٲٱ�),
			  //  ���ٸ� 0, �տ� �ִٸ� ���(�״��)�� ����
        Arrays.sort(strNumbers, (s1,s2) -> (s2+s1).compareTo(s1+s2));
				// ** �������� �ٸ��� : �� compareTo �޼ҵ�� �ܼ��� int, String �Ӹ� �ƴ϶�
				// �迭������ �ڷᱸ���� � ���̵� ������ �����ϴ�! 
			
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
