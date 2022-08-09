package week01_StringHandling;

/* ====================
 * ���ڿ� ���� 
 * ====================
   ��Ʈ�ڵ�(LeetCode) 344�� ���� ���ڿ� ������
 
 - �־��� ���ڿ��� ������ ����
 - Ǯ�� : 
  
 */

public class ReverseString {

    public static void reverseString(char[] s) {
        
        for(int i = 0; i < (s.length / 2); i++) {
            
            char tempChar = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = tempChar;
            
        }
        
    }
    
    public static void main(String[] args) {
    	
    	char[] test = {'h','e','l','l','o'};
    	char[] test2 = {'H','a','n','n','a','h'};
		
		reverseString(test);
		reverseString(test2);
		//
		
    }
    
}
