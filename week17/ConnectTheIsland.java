package week17;

import java.util.Arrays;

public class ConnectTheIsland {
    
    // 최소 비용으로 모든 섬 연결, n : 섬 개수
    // costs[i][0] & costs[i][1] : 현재섬/연결섬 번호, costs[i][2]  : 다리건설비용
    // 크루스칼 알고리즘 + union find를 알아야 풀 수 있는 문제
    /* 

    * 크루스칼 알고리즘 : 
    최소 비용의 간선을 선택하는 과정을 최소화하기위해 간선을 오름차순으로 정렬 한다.
    Kruskal 알고리즘은 임의의 정점을 기준으로 최소 비용의 간선을 선택해 연결해 나가는 알고리즘으로, 
    임의의 정점에 연결된 정점을 선택 했을 때 해당 정점이 어느 집합의 원소인지를 확인하는 과정이 필요
    
    선택 되지 않은 여러 간선 중 비용이 가장 적은 간선 부터 선택해 나간다.
    간선 선택 과정에서 사이클이 발생하면 해당 간선은 선택하지 않는다.
    신장트리는 N개의 정점(모든 정점)을 연결하여 만들어 지므로 N-1개의 간선이 선택되면 실행을 종료 한다.   
    
    * union find : 
    임의의 두 원소를 선택했을때, 각 원소가 같은 집합에 속하는지를 판별하는 알고리즘
    1) 각 노드들의 부모를 저장할 공간을 만들어, 처음에는 부모를 자기 자신으로 초기화합니다. 
    2) 각 연결된 노드별로 부모 노드를 union한다.(통상적으로 값이 작은 노드를 부모로 세팅)
    3) 위 과정을 반복하는 dfs 과정을 통해, 부모 노드를 통일시킨다.
    
    // 참고 : https://maetdori.tistory.com/entry/프로그래머스-섬-연결하기
    
    */
    
    static int[] parent; // 각 섬의 union 원소(섬) 테이블
    
    public int solution(int n, int[][] costs) {
        
        // 비용 기준으로 costs 배열 오름차순 정렬(적은 비용부터 연결을 시작할 것이기 때문)
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);      
        System.out.println(Arrays.toString(costs));
        
        // union find 위한 parent 배열 세팅(초기값은 노드(섬) 자신을 가리킴)
        parent = new int[n]; 
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
            
        int answer = 0;
        for (int[] cost : costs) {
            
            int from = cost[0];
            int to = cost[1];
            int costOfBridge = cost[2]; 
            
            int fromParent = getParent(from);
            int toParent = getParent(to);
            
            // 부모노드가 같으면 다리연결 필요 X => pass
            if(fromParent == toParent) continue;
            
            // 코스트 갱신 + 다리가 연결되었으므로 fromParent의 노드가 연결될 노드의 부모로 지정
            answer += costOfBridge;
            parent[toParent] = fromParent;
        }

	    return answer;
    }
    
    // 부모 노드가 자기자신과 같은 노드를 찾을때까지 재귀호출
    public int getParent(int node){
        System.out.println("getParent in, parent[node] : " + parent[node] + ", node : " + node);
        
        if(parent[node] == node){
            System.out.println("node find >> node : " + node);
            return node;
        }
        else{
            return getParent(parent[node]);
        }
            
    }  
    
}