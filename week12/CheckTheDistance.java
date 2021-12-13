package week12;

import java.util.*;

// 1. ������ ��� �ڸ��� Ž���ϸ鼭, P(�������� ��ġ)�� ã�´�.
// 2. bfs(���Ž��)�� ����, ����ư�Ÿ� 2 �̳���(�ֱ��� �����) �ٸ� P�� �ִ��� Ȯ��
// 3. �� �Ÿ��� ����� ���� Ž��(�ֱ����Ÿ� ����)
//     1) P�� �ִٸ� FALSE(0) RETURN
//     2) X�� �ִٸ� ���� ���� Ž�� �ʿ� X(��� ����� �� ����)
//     3) O�� �ִٸ� �ֱ����Ÿ��� ���� O �Ǵ� X�� ���� => Ž�� �ѹ� �� ����Ǿ� ��

// �� ���̺� T1, T2�� ��� (r1, c1), (r2, c2)�� ���� ��ġ�ϸ�,
// T1, T2 ������ ����ư �Ÿ��� |r1 - r2| + |c1 - c2|
// ���� : int manhaten = Math.abs(nextr - r) + Math.abs(nextc - c); (abs : ���밪 )
// ���� �����ڸ� �������� x��/y�� �������� ��������!

public class CheckTheDistance {
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++){
            
             boolean isOk = true; // �� ���Ǻ� clean ����
             String[] perRoom = places[i];
          //   System.out.println(Arrays.toString(perRoom));  // ���� ���
            
             for(int j = 0; j < perRoom.length; j++){
                 
                 String perRow = perRoom[j];
             //    System.out.println("perRow : " + perRow); // �� row�� ���
                 
                 for (int x = 0; x < 5; x++) {
                     
                    if (perRoom[j].charAt(x) == 'P') {  //  �� �ٿ� �ɾ��ִ� ����� �ִٸ�
                        
                        //  �� ����� �������� bfs ����
                        //  j : ���� �� �� | x : ���� �� ��
                        if (!bfs(j, x, perRoom)){  
                            isOk = false; // bfs�� ���������� false chk
                        }
                    }
                     
                 } // for 3 end                
   
             } // for 2 end
            
           answer[i] = isOk ? 1 : 0;    //  �ش� ������ clean���� chk
        } // for 1 end
        
        return answer;
    } // solution end
    
    
    private static boolean bfs(int row, int count, String[] p) {
        System.out.println("bfs in, row : " +row+", count : "+count+", p : " + Arrays.toString(p));
        
        int dr[] = { -1, 1, 0, 0 }; // ���� row
        int dc[] = { 0, 0, -1, 1 }; // ���� count

        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.offer(new int[] { row, count }); // ���� ����� ť�� �߰�
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            System.out.println("position >> " + Arrays.toString(position)); // ó�� 0,0
            
            // 4������ �˻�
            for (int i = 0; i < 4; i++) {
                int nr = position[0] + dr[i];
                int nc = position[1] + dc[i];
                System.out.println("nr : " + nr + ", nc : " + nc); // ó�� 0,0

                // ���� ����� ���� ���ų�, ���� ����� ���� 5���� ū ��� ����
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == row && nc == count))
                    continue;

                int d = Math.abs(nr - row) + Math.abs(nc - count); // ����ź�Ÿ� ���

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