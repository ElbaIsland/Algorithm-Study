package week2;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        
    	int leftLen, rightLen = 0;
    	char word;
    	
        s = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll(" ", "").trim();
        System.out.println(s);
        String[] sArray = s.split("");
        
        
        for(int i = 0; i < s.length(); i++) {
        	
        	leftLen = i;
        	rightLen = i;
        	word = s.charAt(i);
        	
        	while ( leftLen > 0 && word == s.charAt(leftLen)) {
				leftLen--;
			}
        	
        	while (rightLen < s.length() && word == s.charAt(rightLen)) {
				rightLen++;
			}        	

        	System.out.println("word : " + word + ", leftLen : " + leftLen + ", rightLen : " + rightLen);
        	
        	
        	while (leftLen >= 0 && rightLen < s.length()) {
                if (s.charAt(leftLen) != s.charAt(rightLen)) {
                    break;
                }
                leftLen--;
                rightLen++;
            }
        	
        	System.out.println(" After >> word : " + word + ", leftLen : " + leftLen + ", rightLen : " + rightLen);
        	System.out.println("==========");
        	
        }
        
        return s;
        
    }
    
    
    public static void main(String[] args) {
		
    	LongestPalindromicSubstring palindrome = new LongestPalindromicSubstring();

    	palindrome.longestPalindrome("babad");
    	
	}
	
}
