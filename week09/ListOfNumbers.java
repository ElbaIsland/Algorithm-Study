package week09;

import java.util.*;

public class ListOfNumbers {
    public boolean solution(String[] phone_book) {
        
        // ���ξ��� ��찡 '������ false', '������ true'
        boolean answer = true;
        
        Arrays.sort(phone_book);
//         int phoneNumbers[] = new int[phone_book.length];
        
//         // �� phone_book[i] ���ڿ��� ������ ��ȯ
//    for(int i=0; i<phone_book.length; i++) {
// 			phoneNumbers[i] = Integer.parseInt(phone_book[i]);
// 		}
        
        // �ݺ��� ���� index ����, ���� �ε����� Ȯ���Ͽ� ��ġ�� �� Ȯ��
        // + �ε����� '����' Ȯ���Ͽ�, for�� ���ο����� ���ư����� Ȯ��
        for(int i = 0; i < phone_book.length; i++){       
         //   int numLength = (int).(Math.log10(phoneNumbers[i])+1);  //  ���ڱ��� ���ϱ�
            for(int j = i+1; j < phone_book.length; j++){
                
                // ���ξ� üũ
               if(phone_book[j].startsWith(phone_book[i])){ 
                   answer = false;
                   break;   //  �ݺ��� ����������
               }
                
            } // for end
                    
        } // for end
        
        return answer;
    }
}
