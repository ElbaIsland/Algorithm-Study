package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
    	
    	// map에 nums array 저장
    	Map<String, Integer> numArr = new HashMap<String, Integer>();
    	int [] returnNums = new int[2];
    	// <'2',0>, <'7',1>, <'11',2>...
    	// <'3',0>, <'2',1>, <'4',2>
    	for (int i = 0; i < nums.length; i++) {
			numArr.put(Integer.toString(nums[i]), i);	// map에서는 key값을 찾는게 여러워서 반대로 작업...
		}
    	
    	for (int i = 0; i < nums.length; i++) {

    		if (numArr.containsKey(Integer.toString(target - nums[i]))) {	//	두 수를 뺀 값 들어있다면 
    			
    			System.out.println("가져온값 : " + (target - nums[i]));
    			
    			System.out.println("넣을 key : " + i);
    			System.out.println("넣을 key+1 : " + numArr.get(Integer.toString((target - nums[i]))));
    			System.out.println("nums[i]값 : " + nums[i]);
    			
				returnNums[0] = i;
				returnNums[1] = numArr.get(Integer.toString((target - nums[i])));
				
				if (returnNums[0] == returnNums[1]) {
					continue;
				}
				else 
					break;	
    			
			}
		}
    	
    	System.out.println(Arrays.toString(returnNums));
		return returnNums;
    }
    
    public static void main(String[] args) {
    	int [] test = {2,11,15,7};	
		TwoSum ts = new TwoSum();
		ts.twoSum(test, 9);
	}
    
}
