package week23;

import java.util.*;

/* 220512 review (���α׷��ӽ� - ���ǰ��)
 * 4. ���� ū ��
 * 
		**���� ����**
		
		�����ڴ� ������ ������ ����� �ظ��Դϴ�. 
		������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
		1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5
		2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5
		3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
		1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
		���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
		**���� Ǯ��**
		
		1. 5, 8, 10�� �������� ������ �ݺ��� Ǫ�� ������ 3���� ������� ���� �迭�� ����
		2. �� �����ڿ� �׵��� ���� ���� ������ map�� ����
		3. �ݺ����� ����, ���� �� ���װ� �������� ���� �� & ���� �� ����� map�� ����
		4. �� �����ں� �ݺ����� ���� ������ ���� ���� ������� Ȯ��

 */

public class MockTest {
    public int[] solution(int[] answers) {
        
        // ������ 3����
        // 5,8,10�� ���� �ݺ����� ������ ��´�.
        int[] animalOne = {1,2,3,4,5};
        int[] animalTwo = {2,1,2,3,2,4,2,5};
        int[] animalThree = {3,3,1,1,2,2,4,4,5,5};
        
			  // map�� Ȱ���� �� �����ڸ� key�� ����, ���� ������ value�� ������ ��
        Map<Integer, Integer> answerChk = new HashMap<Integer, Integer>();
        answerChk.put(1,0); 
        answerChk.put(2,0);    
        answerChk.put(3,0);    
        
        for(int i = 0; i < answers.length; i++){
            
            int answer = answers[i];
            int answerOfAnimalOne = animalOne[i%5];
            int answerOfAnimalTwo = animalTwo[i%8];
            int answerOfAnimalThree = animalThree[i%10];
            
        //    System.out.println("answer : " + answer + ", answer1 : " + answerOfAnimalOne + 
        //        ", answer2 : " + answerOfAnimalTwo + ", answer3 : " + answerOfAnimalThree);
            
            if(answer == answerOfAnimalOne){
                answerChk.put(1,answerChk.get(1)+1);
            }
            if(answer == answerOfAnimalTwo){
                answerChk.put(2,answerChk.get(2)+1);
            }
            if(answer == answerOfAnimalThree){
                answerChk.put(3,answerChk.get(3)+1);
            }            
            
        }
        
        // ���� ���̸��� ����� ���� ���ϱ�
        int maxScore = answerChk.get(1);
        for (Integer i : answerChk.values()) {
            if (i > maxScore) {
                maxScore = i;
            }
        }
        // int maxScore = Math.max(answerChk[0], Math.max(answerChk[1], answerChk[2]));

        // ���� ���Ѱ�(value)�� �������� ���� ���� ��� ã��
        ArrayList<Integer> animalList = new ArrayList<>();
        for (Integer key : answerChk.keySet()) {    //  Ű���� ����� �����´�.
            if (answerChk.get(key) == maxScore) {
                animalList.add(key);
            }
        }
        
        int[] answer = new int[animalList.size()];
        for (int i = 0 ; i < animalList.size() ; i++) {
            answer[i] = animalList.get(i).intValue();
        }
        
        
        return answer;
    }
}