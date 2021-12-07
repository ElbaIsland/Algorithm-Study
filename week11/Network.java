package week11;

import java.util.*;

public class Network {
    public int solution(int n, int[][] computers) {
        
        // 노드들의 연결 여부를 확인하며 재귀함수로 풀이
        // 하나의 노드에서 다른 노드로 넘어갈 때의 기준은 다른 노드 방문 여부 chk
        // n : 컴퓨터의 개수, 연결정보(네트워크) : computers[노드(index)][연결정보(n개만큼?)]
        
        int answer = 0;
        
        // 노드(index)별 방문여부를 체크하는 배열
        boolean[] visited = new boolean[computers.length];    
        
        // 1) 초기에는 방문 모두 x => false set
        for(int i = 0; i < computers.length; i++){
            visited[i] = false; //  default setting(false)
        }
        
        for(int i = 0; i < computers.length; i++){
            
            // 아직 방문안한 '신규' 네트웍이라면(연결된 하나의 네트워크는 dfs로 처리)
            if(visited[i] == false){
                System.out.println("네트워크 확인, 탐색 >> , i : " + i
                                   + ", computers[i] : " + 
                                   computers[i][0] + computers[i][1] + computers[i][2]);
                answer++; // 일단 연결 chk
                dfs(i, visited, computers); // index, T/F, index의 연결정보
            }            
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
        
        System.out.println("======come to dfs, node : " + node + "========");
        visited[node] = true;   //  방문했기때문에 연결 확인, true set
        
        // 다시 for문을 돌려서, 아직 방문안한 node + 연결되어있는 노드일시 넘어가서 true 체크
        // 노드가 서로 쭈우욱 연결되어있는 상태라면 네트워크 개수가 더해지면 안되니까!!!!!!!
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                System.out.println("dfs chk node gogo, i : " + i);
                dfs(i, visited, computers);
        }    
        
    }  
   }
}    