package week02;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        
        int startidx = 0;
        int endidx = 0;
        
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }
            
            System.out.println(i +  "번째 word : " + c + ", leftLen : " + left + ", rightLen : " + right);

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
         
            left = left + 1;
            System.out.println("후처리 " + i +  "번째 word : " + c + ", leftLen : " + left + ", rightLen : " + right);
            
            if (endidx - startidx < right - left) {
            	startidx = left;
            	endidx = right;
            }
            
        }
        System.out.println("startidx : " + startidx + ", endidx : " + endidx);
        System.out.println(s.substring(startidx, endidx));
        return s.substring(startidx, endidx);

        
    }
    
    
    public static void main(String[] args) {
		
    	LongestPalindromicSubstring palindrome = new LongestPalindromicSubstring();

    	palindrome.longestPalindrome("babad");
    	
    	
	}
	
}
