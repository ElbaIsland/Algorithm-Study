package week13;

import java.util.*;

public class TableEdit {
	
//	카카오 채용연계형 인턴쉽 Lv.3
//	명령어 기반으로 표의 행을 선택, 삭제, 복구하는 프로그램을 작성하는 과제를 맡았습니다. 
	
//  "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
//	"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
//	"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
//	"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.

    public String solution(int n, int k, String[] cmd) { 
        
        // n : 처음 표의 행 개수
        // k : 선택된 행위 위치
        
        Stack<Integer> remove = new Stack<>();
        
        int table_size = n; // table_size 지정
        
        for(int i = 0; i < cmd.length; i++) {
            
            char order = cmd[i].charAt(0);
            
            if(order == 'U') 
            {   // 현재 row 위치에서 숫자 개수만큼 뺀다. (up row로 이동)
                k -= Integer.valueOf(cmd[i].substring(2)); 
            } 
            else if(order == 'D')
            {   // 현재 row 위치에서 숫자 개수만큼 더한다. (down row로 이동)
                k += Integer.valueOf(cmd[i].substring(2));
            } 
            else if(order == 'C')
            {
                // 현재 row를 remove stack에 저장, 테이블 size down
                remove.push(k);
                table_size -= 1;
                if(k == table_size) k -= 1; //  삭제된 행이 가장 마지막 행인 경우, 바로 윗행 선택
            } 
            else // z : 최근삭제행 복구
            {
                
                int recent_row = remove.pop(); // 가장 최근에 삭제된 행을 가져온다.
                if(k >= recent_row) k += 1; // ?
                table_size += 1;
            }
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        
        // 현재 테이블의 크기만큼은 행이 삭제되지 않은 것이므로 'O'를 append 해준다.
        for(int i = 0; i < table_size; i++) {
            sb.append('O');
        }
        
        // 스텍에서 삭제된 행을 순서대로 꺼내며 위치를 복구해주고, 해당 위치에는 'X'를 insert 해준다.        
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
        }
        
        return sb.toString();
    }
   
}