package week23;

import java.util.*;

/* 220512 review (프로그래머스 - 모의고사)
 * 4. 가장 큰 수
 * 
		**문제 설명**
		
		수포자는 수학을 포기한 사람의 준말입니다. 
		수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
		1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
		가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		**문제 풀이**
		
		1. 5, 8, 10개 기준으로 문제를 반복해 푸는 수포자 3명의 답안지를 각각 배열로 선언
		2. 각 수포자와 그들이 맞춘 답을 저장할 map을 선언
		3. 반복문을 돌려, 정답 각 문항과 수포자의 답을 비교 & 맞춘 답 존재시 map에 저장
		4. 각 수포자별 반복문을 돌려 문제를 가장 많이 맞춘놈을 확인

 */

public class MockTest {
    public int[] solution(int[] answers) {
        
        // 수포자 3마리
        // 5,8,10개 기준 반복으로 문제를 찍는다.
        int[] animalOne = {1,2,3,4,5};
        int[] animalTwo = {2,1,2,3,2,4,2,5};
        int[] animalThree = {3,3,1,1,2,2,4,4,5,5};
        
			  // map을 활용해 각 수포자를 key로 설정, 맞춘 개수를 value로 설정할 것
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
        
        int[] answer = new int[animalList.size()];
        for (int i = 0 ; i < animalList.size() ; i++) {
            answer[i] = animalList.get(i).intValue();
        }
        
        
        return answer;
    }
}