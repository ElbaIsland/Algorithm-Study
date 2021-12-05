package week10;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        
        int[] answer = {};
           
   		 ArrayList<Integer> arrAnswer = new ArrayList<Integer>();   //  ��������迭
   		 HashMap<String, Integer> genresPerPlay = new HashMap<>();
           
   		 // 1) �帣�� �� ���Ƚ��
   	 	 for(int i =0; i< genres.length; i++) {
   		 		genresPerPlay.put(genres[i], genresPerPlay.getOrDefault(genres[i],0)+plays[i]); 
   	 	 }
        //   System.out.println("genresPerPlay : " + genresPerPlay);  //  �帣 & ���Ƚ��
           
   		 // 2) ���Ƚ���� ���� �帣������ sort
   	 	 List<String> genresList = new ArrayList<>(genresPerPlay.keySet());
   	 	 Collections.sort(genresList, (o1, o2) -> (genresPerPlay.get(o2).compareTo(genresPerPlay.get(o1))));
        //   System.out.println("genresList : " + genresList);  //  �帣�� �̾� ���Ƚ���� ����
           

        // �� �帣�� �ݺ�
   	 	 for(String arg : genresList) {

          // 3) �� �帣�� ��(index)�� ���Ƚ�� view
   	 		 HashMap<Integer, Integer> playsOfIndex = new HashMap<Integer, Integer>();
   	 		 for(int i = 0; i<genres.length; i++) {
   		 			if(arg.equals(genres[i])) { 
   		 				playsOfIndex.put(i, plays[i]);  // genres[]�� plays[]�� ���� index�� ������      
   		 			}
   	 		 }
          //  System.out.println("playsOfIndex : " + playsOfIndex);  //  index�� ���Ƚ��
   			 //  ex ) {1=600, 4=2500}       
         

   			 // 4) ���� index�� ��� Ƚ���� sort
   	 		 List<Integer> indexLists = new ArrayList<>(playsOfIndex.keySet());
   	 		 indexLists.sort((s1, s2)->playsOfIndex.get(s2).compareTo(playsOfIndex.get(s1)));
          //    System.out.println("indexLists : " + indexLists);  //  ���Ƚ���� list ����
    		

          // 5) 0 & 1, �� ���� ���� ����� 2���� index�� ����
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

       // ������ ������ arrAnswer(arraylist)�� int[]������ ��ȯ
   	 	answer = new int[arrAnswer.size()];
           
   	 	 for( int i =0;i<arrAnswer.size();i++) {
   	 		answer[i] = arrAnswer.get(i);
   	 	 }      
           return answer;
       }
   }