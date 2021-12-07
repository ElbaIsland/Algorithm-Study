package week11;

import java.util.*;

public class ChangeTheWord {
    
    // �������� ����
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int cnt) {
        
        // Ÿ�ٴܾ� ���޽� ����Լ� ����
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            
            // �̹� �湮�ߴ� �ܾ��� ��� pass
            if (visited[i]) {
                continue;
            }

            int sameChk = 0;    // ���� ���縵 ����� ����
            for (int j = 0; j < begin.length(); j++) {
                System.out.println("begin[j] : " + begin.charAt(j) + ", words[i] : " + words[i].charAt(j));
                if (begin.charAt(j) == words[i].charAt(j)) {
                    sameChk++;
                }
            }

            if (sameChk == begin.length() - 1) {  // �ѱ��� ���� ��� ���� ���
                System.out.println("====¡�˴ٸ� �ܾ� Ȯ��====");
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}