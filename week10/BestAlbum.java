package week10;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        
        int[] answer = {};
           
   		 ArrayList<Integer> arrAnswer = new ArrayList<Integer>();   //  정답넣을배열
   		 HashMap<String, Integer> genresPerPlay = new HashMap<>();
           
   		 // 1) 장르별 총 재생횟수
   	 	 for(int i =0; i< genres.length; i++) {
   		 		genresPerPlay.put(genres[i], genresPerPlay.getOrDefault(genres[i],0)+plays[i]); 
   	 	 }
        //   System.out.println("genresPerPlay : " + genresPerPlay);  //  장르 & 재생횟수
           
   		 // 2) 재생횟수가 많은 장르순으로 sort
   	 	 List<String> genresList = new ArrayList<>(genresPerPlay.keySet());
   	 	 Collections.sort(genresList, (o1, o2) -> (genresPerPlay.get(o2).compareTo(genresPerPlay.get(o1))));
        //   System.out.println("genresList : " + genresList);  //  장르만 뽑아 재생횟수별 정렬
           

        // 각 장르별 반복
   	 	 for(String arg : genresList) {

          // 3) 각 장르의 곡(index)별 재생횟수 view
   	 		 HashMap<Integer, Integer> playsOfIndex = new HashMap<Integer, Integer>();
   	 		 for(int i = 0; i<genres.length; i++) {
   		 			if(arg.equals(genres[i])) { 
   		 				playsOfIndex.put(i, plays[i]);  // genres[]와 plays[]는 같은 index로 움직임      
   		 			}
   	 		 }
          //  System.out.println("playsOfIndex : " + playsOfIndex);  //  index별 재생횟수
   			 //  ex ) {1=600, 4=2500}       
         

   			 // 4) 위의 index를 재생 횟수별 sort
   	 		 List<Integer> indexLists = new ArrayList<>(playsOfIndex.keySet());
   	 		 indexLists.sort((s1, s2)->playsOfIndex.get(s2).compareTo(playsOfIndex.get(s1)));
          //    System.out.println("indexLists : " + indexLists);  //  재생횟수별 list 정렬
    		

          // 5) 0 & 1, 즉 가장 많이 재생된 2개의 index만 저장
          int j = 0;
   	 		 for (Integer c : indexLists) {
   		 			if(j>1) {
   		 				break;
   		 			}
   		 			arrAnswer.add(c);
   		 		    j++;
   		 	 }
   	 	 }
       //    System.out.println("arrAnswer : " + arrAnswer);  

       // 정답을 도출한 arrAnswer(arraylist)를 int[]형으로 변환
   	 	answer = new int[arrAnswer.size()];
           
   	 	 for( int i =0;i<arrAnswer.size();i++) {
   	 		answer[i] = arrAnswer.get(i);
   	 	 }      
           return answer;
       }
   }