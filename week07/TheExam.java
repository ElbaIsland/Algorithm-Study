package week07;

import java.util.*;

public class TheExam {
    public int[] solution(int[] answers) {
        
        // 수포자 3마리
        // 5,8,10개 기준 반복임을 기억
        int[] animalOne = {1,2,3,4,5};
        int[] animalTwo = {2,1,2,3,2,4,2,5};
        int[] animalThree = {3,3,1,1,2,2,4,4,5,5};
        
        // index를 count하여 계산할 것 => map 활용!
        Map<Integer, Integer> answerChk = new HashMap<>();
        
        // 3마리만큼 만들고
        answerChk.put(1,0);
        answerChk.put(2,0);
        answerChk.put(3,0);
        
        // 정답 개수를 카운트
        for(int i = 0; i < answers.length; i++){
            
            int num = answers[i];
            
            // 내가 막혔던 index 체크 영역
            // => arr1[i%5]로하면 반복되는 index 해당값 구할 수 있음!
            // index별로 정답일 경우 COUNT를 하나씩 +
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
        
        // 가장 많이맞춘 사람의 개수 구하기
        int maxScore = answerChk.get(1);
        for (Integer i : answerChk.values()) {
            if (i > maxScore) {
                maxScore = i;
            }
        }
        // int maxScore = Math.max(answerChk[0], Math.max(answerChk[1], answerChk[2]));
        
        // 개수 구한것(value)을 바탕으로 많이 맞춘 사람 찾기
        ArrayList<Integer> animalList = new ArrayList<>();
        for (Integer key : answerChk.keySet()) {    //  키값인 사람을 가져온다.
            if (answerChk.get(key) == maxScore) {
                animalList.add(key);
            }
        }
        
        System.out.println(animalList);
        
        // animalList 저장값을 int[] 배열로 변환
        int[] answer = new int[animalList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = animalList.get(i);
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}