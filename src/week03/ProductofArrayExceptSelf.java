package week03;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
    	int[] returnArr = new int[nums.length];
    //	int[] returnArrRight = new int[nums.length];
    	int idxLeft = 1;
    	int idxRight = 1;
    	
    	//	각각 i 기준, i-1까지의 곱셉을 변수에 담는다.
    	for (int i = 0; i < nums.length; i++) {
    		returnArr[i] = idxLeft;
    		idxLeft *= nums[i];
    		System.out.println("returnArr[i] : " + returnArr[i]);
		}
    	
    	System.out.println("left 곱하기 끝, " + Arrays.toString(returnArr));
    	System.out.println("==========");
    	
    	// nums[4], nums[3], nums[2]...
    	//	각각 i 기준, i+1~끝까지의 곱셉을 변수에 담는다.
    	for (int i = nums.length-1; i >= 0; i--) {
    		returnArr[i] *= idxRight;	//	returnArr[i]는 오른쪽이 없으므로, 그 아래값부터 진행
    		idxRight *= nums[i];
    		System.out.println("returnArr[i] : " + returnArr[i]);
		} 	
    	
    	System.out.println("right 곱하기 끝, " + Arrays.toString(returnArr));
    	System.out.println("==========");    	
    	
    	return returnArr;
    	
    }
    
    public static void main(String[] args) {
		
    	int[] testInt = {1,2,3,4};
    	int[] testInt2 = {-1,1,0,-3,3};
    	ProductofArrayExceptSelf pae = new ProductofArrayExceptSelf();
    	
    	pae.productExceptSelf(testInt2);
    	
	}
}
