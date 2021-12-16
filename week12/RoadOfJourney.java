package week12;

import java.util.*;

public class RoadOfJourney {

	boolean[] isVisited;
    ArrayList<String> allpaths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {  
        
        isVisited = new boolean[tickets.length]; // üũ����
        String[] answer = {};
        
        dfs(tickets,"ICN","ICN",0); // �������� ICN, �湮���� ���� ICN ����
        
        Collections.sort(allpaths); //  �迭�� sort
    //    System.out.println("dfs out : " + allpaths);    
        answer = allpaths.get(0).split(",");
        return answer;
    }	
	
	public void dfs(String[][] tickets,String start,String path,int count){
        
		  //    System.out.println("dfs in, start: " + start + ", path: " + path + ", count: "+count);
		        
		        // dfs ���� �� ������ count���� ticket�� ��ü length�� ������ ���, dfs out
		        if(count == tickets.length){    
		            allpaths.add(path);
		            return;
		        }
		        
		        for(int i = 0; i< tickets.length;i++){
		            
		            // ó�� start�� �Ѿ�� ���� ��ġ�ϴ� ����� �߽߰�
		            if(!isVisited[i] && tickets[i][0].equals(start)){
		                isVisited[i] = true;
		                
		                // �� ���� dfs ����, path�� ������� �߰�, count 1 ����
		                dfs(tickets, tickets[i][1], path + "," + tickets[i][1], count+1);
		                isVisited[i] = false;
		                
		            }
		       } 
	}
}    