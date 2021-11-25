package week07;

import java.util.*;

public class TheExam {
    public int[] solution(int[] answers) {
        
        // ������ 3����
        // 5,8,10�� ���� �ݺ����� ���
        int[] animalOne = {1,2,3,4,5};
        int[] animalTwo = {2,1,2,3,2,4,2,5};
        int[] animalThree = {3,3,1,1,2,2,4,4,5,5};
        
        // index�� count�Ͽ� ����� �� => map Ȱ��!
        Map<Integer, Integer> answerChk = new HashMap<>();
        
        // 3������ŭ �����
        answerChk.put(1,0);
        answerChk.put(2,0);
        answerChk.put(3,0);
        
        // ���� ������ ī��Ʈ
        for(int i = 0; i < answers.length; i++){
            
            int num = answers[i];
            
            // ���� ������ index üũ ����
            // => arr1[i%5]���ϸ� �ݺ��Ǵ� index �ش簪 ���� �� ����!
            // index���� ������ ��� COUNT�� �ϳ��� +
            if (animalOne[i%5] == num){
                answerChk.replace(1, answerChk.get(1)+1);
            } 
            if (animalTwo[i%8] == num){
                answerChk.replace(2, answerChk.get(2)+1);
            } 
            if (animalThree[i%10] == num){
                answerChk.replace(3, answerChk.get(3)+1);   
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
        
        System.out.println(animalList);
        
        // animalList ���尪�� int[] �迭�� ��ȯ
        int[] answer = new int[animalList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = animalList.get(i);
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}