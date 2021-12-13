package week12;

import java.util.*;

// 1. 대기실의 모든 자리를 탐색하면서, P(응시자의 위치)를 찾는다.
// 2. bfs(사방탐색)를 통해, 맨해튼거리 2 이내에(최근접 사방향) 다른 P가 있는지 확인
// 3. 각 거리별 경우의 수를 탐색(최근접거리 기준)
//     1) P가 있다면 FALSE(0) RETURN
//     2) X가 있다면 현재 방향 탐색 필요 X(모든 경우의 수 충족)
//     3) O가 있다면 최근접거리에 같은 O 또는 X만 가능 => 탐색 한번 더 진행되야 함

// 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하면,
// T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2|
// 공식 : int manhaten = Math.abs(nextr - r) + Math.abs(nextc - c); (abs : 절대값 )
// 현재 응시자를 기준으로 x축/y축 느낌으로 이해하자!

public class CheckTheDistance {
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            
             boolean isOk = true; // 각 대기실별 clean 여부
             String[] perRoom = places[i];
          //   System.out.println(Arrays.toString(perRoom));  // 대기실 목록
            
             for(int j = 0; j < perRoom.length; j++){
                 
                 String perRow = perRoom[j];
             //    System.out.println("perRow : " + perRow); // 각 row별 목록
                 
                 for (int x = 0; x < 5; x++) {
                     
                    if (perRoom[j].charAt(x) == 'P') {  //  그 줄에 앉아있는 사람이 있다면
                        
                        //  그 사람을 기준으로 bfs 실행
                        //  j : 방의 각 행 | x : 방의 각 열
                        if (!bfs(j, x, perRoom)){  
                            isOk = false; // bfs를 빠져나오면 false chk
                        }
                    }
                     
                 } // for 3 end                
   
             } // for 2 end
            
           answer[i] = isOk ? 1 : 0;    //  해당 대기실의 clean여부 chk
        } // for 1 end
        
        return answer;
    } // solution end
    
    
    private static boolean bfs(int row, int count, String[] p) {
        System.out.println("bfs in, row : " +row+", count : "+count+", p : " + Arrays.toString(p));
        
        int dr[] = { -1, 1, 0, 0 }; // 다음 row
        int dc[] = { 0, 0, -1, 1 }; // 다음 count

        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.offer(new int[] { row, count }); // 현재 행렬을 큐에 추가
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            System.out.println("position >> " + Arrays.toString(position)); // 처음 0,0
            
            // 4방향을 검색
            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];
                System.out.println("nr : " + nr + ", nc : " + nc); // 처음 0,0

                // 이전 경우의 수가 없거나, 이후 경우의 수가 5보다 큰 경우 무시
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == row && nc == count))
                    continue;

                int d = Math.abs(nr - row) + Math.abs(nc - count); // 맨하탄거리 계산

                if (p[nr].charAt(nc) == 'P' && d <= 2) {
                    return false;
                }
                else if (p[nr].charAt(nc) == 'O' && d < 2) {
                    queue.offer(new int[] { nr, nc });
                }
            } // for end
        } // while end  
         return true;
    } // bfs end
} // class end