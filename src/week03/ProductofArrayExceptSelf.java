package week03;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
    	int[] returnArr = new int[nums.length];
    //	int[] returnArrRight = new int[nums.length];
    	int idxLeft = 1;
    	int idxRight = 1;
    	
    	//	���� i ����, i-1������ ������ ������ ��´�.
    	for (int i = 0; i < nums.length; i++) {
    		returnArr[i] = idxLeft;
    		idxLeft *= nums[i];
    		System.out.println("returnArr[i] : " + returnArr[i]);
		}
    	
    	System.out.println("left ���ϱ� ��, " + Arrays.toString(returnArr));
    	System.out.println("==========");
    	
    	// nums[4], nums[3], nums[2]...
    	//	���� i ����, i+1~�������� ������ ������ ��´�.
    	for (int i = nums.length-1; i >= 0; i--) {
    		returnArr[i] *= idxRight;	//	returnArr[i]�� �������� �����Ƿ�, �� �Ʒ������� ����
    		idxRight *= nums[i];
    		System.out.println("returnArr[i] : " + returnArr[i]);
		} 	
    	
    	System.out.println("right ���ϱ� ��, " + Arrays.toString(returnArr));
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
