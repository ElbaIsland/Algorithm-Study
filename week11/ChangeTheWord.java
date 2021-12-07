package week11;

import java.util.*;

public class ChangeTheWord {
    
    // 전역변수 세팅
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        
        // 타겟단어 도달시 재귀함수 종료
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            
            // 이미 방문했던 단어일 경우 pass
            if (visited[i]) {
                continue;
            }

            int sameChk = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                System.out.println("begin[j] : " + begin.charAt(j) + ", words[i] : " + words[i].charAt(j));
                if (begin.charAt(j) == words[i].charAt(j)) {
                    sameChk++;
                }
            }

            if (sameChk == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                System.out.println("====징검다리 단어 확인====");
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}