package week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
    public int[] twoSum(int[] nums, int target) {
    	
    	// map�� nums array ����
    	Map<String, Integer> numArr = new HashMap<String, Integer>();
    	int [] returnNums = new int[2];
    	// <'2',0>, <'7',1>, <'11',2>...
    	// <'3',0>, <'2',1>, <'4',2>
    	for (int i = 0; i < nums.length; i++) {
			numArr.put(Integer.toString(nums[i]), i);	// map������ key���� ã�°� �������� �ݴ�� �۾�...
		}
    	
    	for (int i = 0; i < nums.length; i++) {

    		if (numArr.containsKey(Integer.toString(target - nums[i]))) {	//	�� ���� �� �� ����ִٸ� 
    			
    			System.out.println("�����°� : " + (target - nums[i]));
    			
    			System.out.println("���� key : " + i);
    			System.out.println("���� key+1 : " + numArr.get(Integer.toString((target - nums[i]))));
    			System.out.println("nums[i]�� : " + nums[i]);
    			
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
