package week12;

import java.util.*;

public class RoadOfJourney {

	boolean[] isVisited;
    ArrayList<String> allpaths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {  
        
        isVisited = new boolean[tickets.length]; // 체크여부
        String[] answer = {};
        
        dfs(tickets,"ICN","ICN",0); // 시작점인 ICN, 방문공항 역시 ICN 유일
        
        Collections.sort(allpaths); //  배열의 sort
    //    System.out.println("dfs out : " + allpaths);    
        answer = allpaths.get(0).split(",");
        return answer;
    }	
	
	public void dfs(String[][] tickets,String start,String path,int count){
        
		  //    System.out.println("dfs in, start: " + start + ", path: " + path + ", count: "+count);
		        
		        // dfs 진행 중 더해진 count값이 ticket의 전체 length와 동일할 경우, dfs out
		        if(count == tickets.length){    
		            allpaths.add(path);
		            return;
		        }
		        
		        for(int i = 0; i< tickets.length;i++){
		            
		            // 처음 start로 넘어온 값과 일치하는 출발지 발견시
		            if(!isVisited[i] && tickets[i][0].equals(start)){
		                isVisited[i] = true;
		                
		                // 그 다음 dfs 실행, path에 도착경로 추가, count 1 증가
		                dfs(tickets, tickets[i][1], path + "," + tickets[i][1], count+1);
		                isVisited[i] = false;
		                
		            }
		       } 
	}
}    