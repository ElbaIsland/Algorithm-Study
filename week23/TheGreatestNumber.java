package week23;

import java.util.*;

/* 220510 review (���α׷��ӽ� - ����)
 * 2. ���� ū ��
 * 
		**���� ����**
		
		0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
		0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��,
		 ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
		**���� Ǯ��**
		
		1. �־��� ���� ������ ���ڿ� �迭�� ��ȯ�Ѵ�.
		2. ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���Ĵ�� ���ڿ� �迭�� �����Ѵ�.
		- comparator �������̽� Ȱ��
		- �ϳ��� ���ڿ��� �Ǻ��ϴ� ���� �ƴ�, �յ� ���ڿ��� �ٿ��� �� ���� ū ����� �����Ѵ�.
		- �׷��� �ؾ� ���ڸ����� ������� ���� ū ���ڰ� ��ġ�ϰ� �ȴ�.
		3. (*** 0���θ� �̷���� ���� �迭�� ���� ����ó���� �Ѵ�.)
		4.  ������ ���ĵ� ���ڿ� �迭�� �ϳ��� ���ڷ� ��ģ��.
		
		**(�� comparator �������̽��� comparable �������̽� ������ ��!)**
 */

public class TheGreatestNumber {
    public String solution(int[] numbers) {
        
        // ������ ���ڿ��� ��ȯ ��, �̾�ٿ��� ���
        
        String answer = "";
        String strNumbers[] = new String[numbers.length];
      
        // �� numbers[i]���� ���ڿ��� ��ȯ
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                // �յ� ���ڿ��� '���� ��' ũ����Ѵ�.
                // �̸� ����, �������� ������ ū ���� return�ȴ�!
                // �������� : (o2+o1).compareTo(o1+o2);
                // �������� : (o1+o2).compareTo(o1+o2);
                return (o2+o1).compareTo(o1+o2); 
            } 
        });
        
        // System.out.println("af strNumbers : " + Arrays.toString(strNumbers));
        
        // ==> ���� ���� case
        //  ���ڿ� ���� ��ɾ�(string�ε��� ����!!)
        // Arrays.sort(strNumbers, (s1,s2) -> (s2+s1).compareTo(s1+s2));
        
        //0���� �ߺ��ϰ�� ex){0,0,0}
        //���� 000�� ������ �ȵǹǷ� ù��°���� 0�̸� 0�� ����
        if (strNumbers[0].equals("0")) return "0";

        for(String str : strNumbers){
            answer += str;
        }

        return answer;
    }
}