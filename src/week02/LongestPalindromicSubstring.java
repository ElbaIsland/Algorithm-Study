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
				leftLen--;	//	같은 글자 기준으로 갈수있는 한 왼쪽으로~
			}
        	
        	while (rightLen < s.length() && s.charAt(rightLen) == word) {
				rightLen++;	//	같은 글자 기준으로 갈수있는 한 오른쪽으로~
			}        	

       // 	System.out.println(i +  "번째 word : " + word + ", leftLen : " + leftLen + ", rightLen : " + rightLen);
        
        	while (leftLen >= 0 && rightLen < s.length()) {
        		
        		//	펠린드롬 성립이 안된다면 하지마
                if (s.charAt(leftLen) != s.charAt(rightLen)) {
                    break;	
                }
                
                //	펠린드롭 성립이 된다면 한칸씩 이동, 다시 체크
                leftLen--;
                rightLen++;     
            }
        
        	leftLen = leftLen + 1;	//	leftLen을 +1 하지 않으면 -1에서부터 시작...
        	
       // 	System.out.println("최대 유효 펠린드롬 이동 >> , leftLen : " + leftLen + ", rightLen : " + rightLen);
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
