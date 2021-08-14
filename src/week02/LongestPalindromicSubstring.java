package week02;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        
    	int lastLeftLen = 0, lastRightLen = 0;
    	
        System.out.println(s);
        System.out.println("==========");
        String[] sArray = s.split("");    
        
        for(int i = 0; i < s.length(); i++) {
        	int leftLen = i;
        	int rightLen = i;
        	char word = s.charAt(i);	//	b, a, b, a, d
        	
        	while (leftLen >= 0 && s.charAt(leftLen) == word) {
				leftLen--;	//	���� ���� �������� �����ִ� �� ��������~
			}
        	
        	while (rightLen < s.length() && s.charAt(rightLen) == word) {
				rightLen++;	//	���� ���� �������� �����ִ� �� ����������~
			}        	

       // 	System.out.println(i +  "��° word : " + word + ", leftLen : " + leftLen + ", rightLen : " + rightLen);
        
        	while (leftLen >= 0 && rightLen < s.length()) {
        		
        		//	�縰��� ������ �ȵȴٸ� ������
                if (s.charAt(leftLen) != s.charAt(rightLen)) {
                    break;	
                }
                
                //	�縰��� ������ �ȴٸ� ��ĭ�� �̵�, �ٽ� üũ
                leftLen--;
                rightLen++;     
            }
        
        	leftLen = leftLen + 1;	//	leftLen�� +1 ���� ������ -1�������� ����...
        	
       // 	System.out.println("�ִ� ��ȿ �縰��� �̵� >> , leftLen : " + leftLen + ", rightLen : " + rightLen);
       // 	System.out.println(" After >> word : " + s.substring(leftLen, rightLen));
       // 	System.out.println("==========");
        	
        	if ((lastRightLen - lastLeftLen) < (rightLen - leftLen)) {
        		lastRightLen = rightLen;
        		lastLeftLen = leftLen;
			}
             
        }	// for end
    
    //  System.out.println(s.substring(lastLeftLen, lastRightLen));
        return s.substring(lastLeftLen, lastRightLen);
        
    }
    
    
    public static void main(String[] args) {
		
    	LongestPalindromicSubstring palindrome = new LongestPalindromicSubstring();

    	palindrome.longestPalindrome("aaaa");
    	
    	
	}
	
}
