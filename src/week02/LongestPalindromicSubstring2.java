package week02;

public class LongestPalindromicSubstring2 {

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
            
            System.out.println(i +  "¹øÂ° word : " + c + ", leftLen : " + left + ", rightLen : " + right);

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }

            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            
            left = left + 1;
            if (endidx - startidx < right - left) {
            	startidx = left;
            	endidx = right;
            }
        }
        System.out.println(s.substring(startidx, endidx));
        return s.substring(startidx, endidx);

        
    }
    
    
    public static void main(String[] args) {
		
    	LongestPalindromicSubstring2 palindrome = new LongestPalindromicSubstring2();

    	palindrome.longestPalindrome("aaaa");
    	
    	
	}
	
}
