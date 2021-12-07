package week11;

import java.util.*;

public class Network {
    public int solution(int n, int[][] computers) {
        
        // ������ ���� ���θ� Ȯ���ϸ� ����Լ��� Ǯ��
        // �ϳ��� ��忡�� �ٸ� ���� �Ѿ ���� ������ �ٸ� ��� �湮 ���� chk
        // n : ��ǻ���� ����, ��������(��Ʈ��ũ) : computers[���(index)][��������(n����ŭ?)]
        
        int answer = 0;
        
        // ���(index)�� �湮���θ� üũ�ϴ� �迭
        boolean[] visited = new boolean[computers.length];    
        
        // 1) �ʱ⿡�� �湮 ��� x => false set
        for(int i = 0; i < computers.length; i++){
            visited[i] = false; //  default setting(false)
        }
        
        for(int i = 0; i < computers.length; i++){
            
            // ���� �湮���� '�ű�' ��Ʈ���̶��(����� �ϳ��� ��Ʈ��ũ�� dfs�� ó��)
            if(visited[i] == false){
                System.out.println("��Ʈ��ũ Ȯ��, Ž�� >> , i : " + i
                                   + ", computers[i] : " + 
                                   computers[i][0] + computers[i][1] + computers[i][2]);
                answer++; // �ϴ� ���� chk
                dfs(i, visited, computers); // index, T/F, index�� ��������
            }            
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
        
        System.out.println("======come to dfs, node : " + node + "========");
        visited[node] = true;   //  �湮�߱⶧���� ���� Ȯ��, true set
        
        // �ٽ� for���� ������, ���� �湮���� node + ����Ǿ��ִ� ����Ͻ� �Ѿ�� true üũ
        // ��尡 ���� �޿�� ����Ǿ��ִ� ���¶�� ��Ʈ��ũ ������ �������� �ȵǴϱ�!!!!!!!
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                System.out.println("dfs chk node gogo, i : " + i);
                dfs(i, visited, computers);
        }    
        
    }  
   }
}    