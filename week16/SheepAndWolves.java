package week16;

import java.util.*;

public class SheepAndWolves {
    
    // childNodes : 해당 index의 자식 Node를 담고 있는 ArrayList배열
    // Info : 노드별 양 or 늑대인지 show (0 : 양, 1 : 늑대) => 전역변수로 use
    static ArrayList<Integer>[] childNodes;
    static int[] Info;
    
    static int answer = 0;
    static int maxSheepCnt = 0;
    
    // info : 노드별 양 or 늑대인지 show (0 : 양, 1 : 늑대)
    // edges : 2진 트로의 각 노드 연결관계 배열 [부모노드번호][자식노드번호]
    //         가로(열 길이) : 2, 세로(행 길이) : info의 index-1    
    public int solution(int[] info, int[][] edges) {
        
        Info = info;
        childNodes = new ArrayList[info.length];
        
        // 1) childNode에 edges를 확인하여 노드를 담는다.
        for (int[] i : edges) {
            int parent = i[0];
            int child = i[1];
            
            // 자식노드가 없는 경우 깡통 세팅(NullPointerException 방지용)
            if (childNodes[parent] == null) {   
                childNodes[parent] = new ArrayList<>();
            }
            childNodes[parent].add(child);
        }
        System.out.println(Arrays.toString(childNodes));
        
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list); //  2) dfs start
        
        answer = maxSheepCnt;
        return answer;
    }
    
    // index : 현재 node index, nextNode : 다음 탐색 위치
    public void dfs(int index, int sheepCnt, int wolfCnt, List<Integer> nextNode){
 
		// 늑대/양 수, 양의 최대값 세팅
		if (Info[index] == 0) sheepCnt++;
		else wolfCnt++;
 
		if (wolfCnt >= sheepCnt) return;    //  꺼-억
		maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);
   
        // =====================================
		// 다음 탐색 위치 갱신
        // 처음에는 list에 0만 in,  
		List<Integer> listofNode = new ArrayList<>();
		listofNode.addAll(nextNode);
        
		// 다음 탐색 목록중 현재 위치제외
		listofNode.remove(Integer.valueOf(index));
		if (childNodes[index] != null) {
			for (int child : childNodes[index]) {
				listofNode.add(child);
			}
		}
        
		// 갈수 있는 모든 Node Dfs
		for (int next : listofNode) {
			dfs(next, sheepCnt, wolfCnt, listofNode);
		}   
        // =====================================

    } // dfs end
        
}