package week03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOfThree {
    public List<List<Integer>> threeSum(int[] nums) {
        
    	List<List<Integer>> returnSum = new LinkedList<>();
    	Arrays.sort(nums);
    	int caseSum = 0;
    	System.out.println(Arrays.toString(nums) + ", nums.length-2 :" + (nums.length-2));
    		
    	for (int i = 0; i < nums.length-2; i++) {
    		
    		System.out.println("i : " + i);
    		
    		if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}		
    		
    		// i 기준, 하나씩 업 and 다운
    		// 왜 i에서 더하는 수만 있는거지?
    		// => 한번 i값이 포함되면, 더이상 지난 index는 볼필요가 없다!
    		int j = i+1;	int k = nums.length-1;
    		//	풀이 : i를 기준으로 j, k를 하나씩 더하고 빼며 0이되는 경우의 수 찾을 것
    		System.out.println("i : " + i + ", nums[i] : " + nums[i] + ", nums[j] : " + nums[j] + ", nums[k] : " + nums[k]);
    		
    		while (j < k) {  			
    			if(nums[i] + nums[j] + nums[k] == 0) {
    				returnSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
    				j++;
    				k--;
    				// 이렇게 skip해주지 않으면 같은 nums[j], nums[k]값이 return값에 두번 들어감
                    while (j < k && nums[j] == nums[j - 1]) j++;  
                    while (j < k && nums[k] == nums[k + 1]) k--;     				
    			}
    			//	아래 로직이 어떻게 testNums2 같은 case를 거르게 해주는거지??
    			else if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				}
    			else {
    				j++;
    			}
    			
			}
    		
    		System.out.println("i : " + i + ", nums[i] : " + nums[i] + ", nums[j] : " + nums[j] + ", nums[k] : " + nums[k]);
    		System.out.println("===================");
   		
		}			
    	
    	System.out.println(returnSum);
    	return returnSum;
    }
    
    public static void main(String[] args) {
		
    	int[] testNums = {-1,0,1,2,-1,-4};
    	int[] testNums2 = {-2,0,0,2,2};
    	
    	SumOfThree st = new SumOfThree();
    	st.threeSum(testNums2);
	}
}
