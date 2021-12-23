package week13;

import java.util.*;

public class TableEdit {
	
//	īī�� ä�뿬���� ���Ͻ� Lv.3
//	��ɾ� ������� ǥ�� ���� ����, ����, �����ϴ� ���α׷��� �ۼ��ϴ� ������ �þҽ��ϴ�. 
	
//  "U X": ���� ���õ� �࿡�� Xĭ ���� �ִ� ���� �����մϴ�.
//	"D X": ���� ���õ� �࿡�� Xĭ �Ʒ��� �ִ� ���� �����մϴ�.
//	"C" : ���� ���õ� ���� ������ ��, �ٷ� �Ʒ� ���� �����մϴ�. ��, ������ ���� ���� ������ ���� ��� �ٷ� �� ���� �����մϴ�.
//	"Z" : ���� �ֱٿ� ������ ���� ������� �����մϴ�. ��, ���� ���õ� ���� �ٲ��� �ʽ��ϴ�.

    public String solution(int n, int k, String[] cmd) { 
        
        // n : ó�� ǥ�� �� ����
        // k : ���õ� ���� ��ġ
        
        Stack<Integer> remove = new Stack<>();
        
        int table_size = n; // table_size ����
        
        for(int i = 0; i < cmd.length; i++) {
            
            char order = cmd[i].charAt(0);
            
            if(order == 'U') 
            {   // ���� row ��ġ���� ���� ������ŭ ����. (up row�� �̵�)
                k -= Integer.valueOf(cmd[i].substring(2)); 
            } 
            else if(order == 'D')
            {   // ���� row ��ġ���� ���� ������ŭ ���Ѵ�. (down row�� �̵�)
                k += Integer.valueOf(cmd[i].substring(2));
            } 
            else if(order == 'C')
            {
                // ���� row�� remove stack�� ����, ���̺� size down
                remove.push(k);
                table_size -= 1;
                if(k == table_size) k -= 1; //  ������ ���� ���� ������ ���� ���, �ٷ� ���� ����
            } 
            else // z : �ֱٻ����� ����
            {
                
                int recent_row = remove.pop(); // ���� �ֱٿ� ������ ���� �����´�.
                if(k >= recent_row) k += 1; // ?
                table_size += 1;
            }
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        
        // ���� ���̺��� ũ�⸸ŭ�� ���� �������� ���� ���̹Ƿ� 'O'�� append ���ش�.
        for(int i = 0; i < table_size; i++) {
            sb.append('O');
        }
        
        // ���ؿ��� ������ ���� ������� ������ ��ġ�� �������ְ�, �ش� ��ġ���� 'X'�� insert ���ش�.        
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
        }
        
        return sb.toString();
    }
   
}