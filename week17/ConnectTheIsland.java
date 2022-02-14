package week17;

import java.util.Arrays;

public class ConnectTheIsland {
    
    // �ּ� ������� ��� �� ����, n : �� ����
    // costs[i][0] & costs[i][1] : ���缶/���ἶ ��ȣ, costs[i][2]  : �ٸ��Ǽ����
    // ũ�罺Į �˰��� + union find�� �˾ƾ� Ǯ �� �ִ� ����
    /* 

    * ũ�罺Į �˰��� : 
    �ּ� ����� ������ �����ϴ� ������ �ּ�ȭ�ϱ����� ������ ������������ ���� �Ѵ�.
    Kruskal �˰����� ������ ������ �������� �ּ� ����� ������ ������ ������ ������ �˰�������, 
    ������ ������ ����� ������ ���� ���� �� �ش� ������ ��� ������ ���������� Ȯ���ϴ� ������ �ʿ�
    
    ���� ���� ���� ���� ���� �� ����� ���� ���� ���� ���� ������ ������.
    ���� ���� �������� ����Ŭ�� �߻��ϸ� �ش� ������ �������� �ʴ´�.
    ����Ʈ���� N���� ����(��� ����)�� �����Ͽ� ����� ���Ƿ� N-1���� ������ ���õǸ� ������ ���� �Ѵ�.   
    
    * union find : 
    ������ �� ���Ҹ� ����������, �� ���Ұ� ���� ���տ� ���ϴ����� �Ǻ��ϴ� �˰���
    1) �� ������ �θ� ������ ������ �����, ó������ �θ� �ڱ� �ڽ����� �ʱ�ȭ�մϴ�. 
    2) �� ����� ��庰�� �θ� ��带 union�Ѵ�.(��������� ���� ���� ��带 �θ�� ����)
    3) �� ������ �ݺ��ϴ� dfs ������ ����, �θ� ��带 ���Ͻ�Ų��.
    
    // ���� : https://maetdori.tistory.com/entry/���α׷��ӽ�-��-�����ϱ�
    
    */
    
    static int[] parent; // �� ���� union ����(��) ���̺�
    
    public int solution(int n, int[][] costs) {
        
        // ��� �������� costs �迭 �������� ����(���� ������ ������ ������ ���̱� ����)
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);      
        System.out.println(Arrays.toString(costs));
        
        // union find ���� parent �迭 ����(�ʱⰪ�� ���(��) �ڽ��� ����Ŵ)
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
            
            // �θ��尡 ������ �ٸ����� �ʿ� X => pass
            if(fromParent == toParent) continue;
            
            // �ڽ�Ʈ ���� + �ٸ��� ����Ǿ����Ƿ� fromParent�� ��尡 ����� ����� �θ�� ����
            answer += costOfBridge;
            parent[toParent] = fromParent;
        }

	    return answer;
    }
    
    // �θ� ��尡 �ڱ��ڽŰ� ���� ��带 ã�������� ���ȣ��
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