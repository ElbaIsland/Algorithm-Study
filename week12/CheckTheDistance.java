package week12;


public class CheckTheDistance {
	
	//dfs 조건 
	//사람과 사람사이에 파티션 존재 하면 ok 
	//한사람 기준으로 -> 사방에 파티션 있으면 ok,
	// 만약 사방에 파티션이 없는데 
	//빈테이블은 무시이다.. 그냥 공간.
	//int [][] dp = int 	
	
	
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            String[][] room = new String[5][5];
            for(int z = 0 ; z <  places[i].length; z++){
                room[z] = places[i][z].split("");   
            }
            answer[i] = dfs(room);
        } 
        return answer;
    }
    
    Boolean check(String[][] room, int row, int column){
        // 디피 넣기 !!!!!!!!!!!!!!!!!
        if(!room[row][column].equals("P")){// 사람아닌건 pass
            return true;
        }

        if(row != 4 && room[row+1][column].equals("P")) return false;
        if(row != 0 && room[row-1][column].equals("P")) return false;
        if(column != 4 && room[row][column+1].equals("P")) return false;
        if(column != 0 && room[row][column-1].equals("P")) return false;
        
        if(row != 4 && column != 4  && room[row+1][column+1].equals("P")){
            if( !room[row+1][column].equals("X") || !room[row][column+1].equals("X"))
            return false;
        }
        if(row != 4 && column != 0  && room[row+1][column-1].equals("P")){
            if( !room[row+1][column].equals("X") || !room[row][column-1].equals("X"))
            return false;
        }
        if(row != 0 && column != 4  && room[row-1][column+1].equals("P")){
            if( !room[row-1][column].equals("X") || !room[row][column+1].equals("X"))
            return false;
        }
        if(row != 0 && column != 0  && room[row-1][column-1].equals("P")){
            if( !room[row-1][column].equals("X") || !room[row][column-1].equals("X"))
            return false;
        }
        
        if(row < 3 && room[row+2][column].equals("P") && !room[row+1][column].equals("X") )return false;
        if(row > 1 && room[row-2][column].equals("P") && !room[row-1][column].equals("X"))return false;
        if(column < 3 && room[row][column+2].equals("P") && !room[row][column+1].equals("X"))return false;
        if(column > 1 && room[row][column-2].equals("P") && !room[row][column-1].equals("X"))return false;
        
        
        
        return true;
    }
    
    
    int dfs(String[][] room){
        for(int r = 0 ; r < 5 ; r++ ){
            for(int c = 0; c < 5; c ++){
                Boolean ch = check(room, r, c);
                if(!ch){
                   return 0;  
                }
            }
        }
        return 1;
    } 

}