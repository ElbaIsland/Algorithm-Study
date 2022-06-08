package week24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/* 220607 review (프로그래머스 - 탐욕법)
 * 2. 조이스틱
 * 
		**문제 설명**
		
		**문제 풀이**	
		
 * 
 */

public class JoyStick {
    public int solution(String name) {
        
        int answer = 0;
        int index; // 커서가 위치한 인덱스
        int move = name.length() - 1; // 좌우 움직임 수를 체크(기본적으로 움직일 경우 세팅)
        String input = "";
        // 처음에는 aaa 기본 세팅, 첫번째 문자에 커서 위치
        // 첫번째 문자에서 왼쪽 이동 => 마지막 문자로 이동
        // 마지막 문자에서 오른쪽 이동 => 첫번째 문자로 이동
        // a~z까지 알파벳으로 조이스틱 이름 남기기
        
        
        for(int i = 0; i < name.length(); i++){
            
            char alphabet = name.charAt(i); // 목표 알파벳
            
            // a-z 중 중간을 넘어가는지 or 넘어가지 않는지에 따라 방향 설정
            // +1하는 이유 : 처음 시작이 a로 세팅이 되어있으므로, z로 한번 움직여줘야함
            answer += Math.min(alphabet - 'A', 'Z' - alphabet + 1);
            
            // 좌우 이동 기준 확인
            index = i + 1;
            
            // 연속되는 A 갯수 확인
            // a일 경우는 건너뛰고, 실질적인 index를 찾는다.
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }
            
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            // 오른쪽으로 가다가 다시 왼쪽으로 이동하는 경우를 고려해봅니다.
            // 1.오른쪽으로 이동하다가 왼쪽으로 이동하는 경우 처음 오른쪽으로 idx(2)번 이동합니다. -> 2번 이동
            // 2.연속된 A를 만나고, 온길을 다시 되돌아갑니다.(왼쪽으로 idx번 이동) -> 2번 이동
            // 3.연속된 A가 끝나는 지점은 idx = 6일 때 입니다. 따라서 index에 연속이 끝나 새로운 글자의 등장 위치인 7을 넣어줍니다.
            // 4.맨뒤에서 부터 왼쪽으로 이동하며 index번째 글자까지 와야합니다. (len - index)번 이동 -> 3번 이동
            // 5.총 이동 횟수는 2+2+3 = 7입니다. (idx + idx + len - index)            
            move = Math.min(move, i * 2 + name.length() - index); 
            
        }
   
        return answer + move;
    }
}