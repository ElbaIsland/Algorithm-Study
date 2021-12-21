package week13;

import java.util.*;

public class StringToNumber {
	
//	īī�� ä�뿬���� ���Ͻ� Lv.1
//	�׿��� ���ε��� ���ڳ��̸� �ϰ� �ֽ��ϴ�. �׿��� ���ε����� ���ڸ� �ǳ� �� �Ϻ� �ڸ����� ���ܾ�� �ٲ� ī�带 �ǳ��ָ� ���ε��� ���� ���ڸ� ã�� �����Դϴ�.
//
//	������ ������ �Ϻ� �ڸ����� ���ܾ�� �ٲٴ� �����Դϴ�.
//
//	1478 �� "one4seveneight"
//	234567 �� "23four5six7"
//	10203 �� "1zerotwozero3"
//	�̷��� ������ �Ϻ� �ڸ����� ���ܾ�� �ٲ�����ų�, Ȥ�� �ٲ��� �ʰ� �״���� ���ڿ� s�� �Ű������� �־����ϴ�.
//	s�� �ǹ��ϴ� ���� ���ڸ� return �ϵ��� solution �Լ��� �ϼ����ּ���.	

    public int solution(String s) {
        
        String[] numsToStr = {"zero", "one", "two", "three", "four", "five",
                              "six", "seven", "eight", "nine"};  
        String[] strToNums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 
        for(int i = 0; i < numsToStr.length; i++){
            s = s.replace(numsToStr[i], strToNums[i]);
        }    
        
//    List<String> strArr = new ArrayList<>();        
//    for (String str : numsToStr) {
//         	if(s.contains(str)) {
//                 System.out.println("if in, " + str);
//         		int indexOfStr = Arrays.asList(numsToStr).indexOf(str);
//         		str = strToNums[indexOfStr];
//                 System.out.println(str);
//         		strArr.add(str);
//         	}
//          else
//          {
//              System.out.println("else in, " + str);
//          }
// 		}
        
        int answer = Integer.parseInt(s);
        return answer;
    }
   
}