package week01;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        
        Boolean isPalindrome = true;

        s = s.replaceAll("[^a-zA-Z0-9]", "").replaceAll(" ", "").toUpperCase().trim();
        System.out.println(s);
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
