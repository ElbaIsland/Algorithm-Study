package week01_StringHandling;

/* ====================
 * 문자열 조작 
 * ====================
   리트코드(LeetCode) 125번 문제 유효한 펠린드롬
 
 - 주어진 문자열이 유효한 펠린드롬인지 판별하는 문제
 - 풀이 : 
  
 */

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        
        Boolean isPalindrome = true;

        s = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll(" ", "").toUpperCase().trim();
        // System.out.println(s);
        String[] sArray = s.split("");
        
        StringBuffer sb = new StringBuffer(s);
        String reverseS = sb.reverse().toString();
        String[] resArray = reverseS.split("");
        
        System.out.println(reverseS);
        
        for(int i = 0; i < sArray.length; i++){
            

        	System.out.println("sArray[i] : " + sArray[i]);
        	System.out.println("resArray[i] : " + resArray[i]);
            if(sArray[i].equals(resArray[i])){
                continue;
            }
            else{
	            isPalindrome = false;
	            break;
            }
                
        }
        
        return isPalindrome;
        
    }
    
    
    public static void main(String[] args) {
		
    	ValidPalindrome palindrome = new ValidPalindrome();
    	
    	boolean answer = palindrome.isPalindrome("0p");
    	
    	System.out.println(answer);
    	
    	
	}
	
}
