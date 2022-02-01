package week16;

import java.util.*;

public class SheepAndWolves {
    
    // childNodes : �ش� index�� �ڽ� Node�� ��� �ִ� ArrayList�迭
    // Info : ��庰 �� or �������� show (0 : ��, 1 : ����) => ���������� use
    static ArrayList<Integer>[] childNodes;
    static int[] Info;
    
    static int answer = 0;
    static int maxSheepCnt = 0;
    
    // info : ��庰 �� or �������� show (0 : ��, 1 : ����)
    // edges : 2�� Ʈ���� �� ��� ������� �迭 [�θ����ȣ][�ڽĳ���ȣ]
    //         ����(�� ����) : 2, ����(�� ����) : info�� index-1    
    public int solution(int[] info, int[][] edges) {
        
        Info = info;
        childNodes = new ArrayList[info.length];
        
        // 1) childNode�� edges�� Ȯ���Ͽ� ��带 ��´�.
        for (int[] i : edges) {
            int parent = i[0];
            int child = i[1];
            
            // �ڽĳ�尡 ���� ��� ���� ����(NullPointerException ������)
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
    
    // index : ���� node index, nextNode : ���� Ž�� ��ġ
    public void dfs(int index, int sheepCnt, int wolfCnt, List<Integer> nextNode){
 
		// ����/�� ��, ���� �ִ밪 ����
		if (Info[index] == 0) sheepCnt++;
		else wolfCnt++;
 
		if (wolfCnt >= sheepCnt) return;    //  ��-��
		maxSheepCnt = Math.max(sheepCnt, maxSheepCnt);
   
        // =====================================
		// ���� Ž�� ��ġ ����
        // ó������ list�� 0�� in,  
		List<Integer> listofNode = new ArrayList<>();
		listofNode.addAll(nextNode);
        
		// ���� Ž�� ����� ���� ��ġ����
		listofNode.remove(Integer.valueOf(index));
		if (childNodes[index] != null) {
			for (int child : childNodes[index]) {
				listofNode.add(child);
			}
		}
        
		// ���� �ִ� ��� Node Dfs
		for (int next : listofNode) {
			dfs(next, sheepCnt, wolfCnt, listofNode);
		}   
        // =====================================

    } // dfs end
        
}