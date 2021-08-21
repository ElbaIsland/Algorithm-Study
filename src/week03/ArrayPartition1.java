package week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        
    	int returnSumValue = 0;
    	Map<Integer, Integer> arrPartition = new HashMap<Integer, Integer>();
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
    	for (int i = 0; i < nums.length/2; i++) {
    	//	int minVal = Math.min(i, i);
    	//	arrPartition.put(nums[i*2], nums[i*2+1]);
    		returnSumValue += nums[i*2];
		}	
    	System.out.println(returnSumValue);
    	
    	return returnSumValue;
    }
    
    public static void main(String[] args) {
    	
    //	int[] testNums = {1,4,3,2};
    	int[] testNums = {6,2,6,5,1,2};
		ArrayPartition1 testArr = new ArrayPartition1();
		testArr.arrayPairSum(testNums);	
	}
    
}
