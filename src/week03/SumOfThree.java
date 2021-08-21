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
    		
    		// i ����, �ϳ��� �� and �ٿ�
    		// �� i���� ���ϴ� ���� �ִ°���?
    		// => �ѹ� i���� ���ԵǸ�, ���̻� ���� index�� ���ʿ䰡 ����!
    		int j = i+1;	int k = nums.length-1;
    		//	Ǯ�� : i�� �������� j, k�� �ϳ��� ���ϰ� ���� 0�̵Ǵ� ����� �� ã�� ��
    		System.out.println("i : " + i + ", nums[i] : " + nums[i] + ", nums[j] : " + nums[j] + ", nums[k] : " + nums[k]);
    		
    		while (j < k) {  			
    			if(nums[i] + nums[j] + nums[k] == 0) {
    				returnSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
    				j++;
    				k--;
    				// �̷��� skip������ ������ ���� nums[j], nums[k]���� return���� �ι� ��
                    while (j < k && nums[j] == nums[j - 1]) j++;  
                    while (j < k && nums[k] == nums[k + 1]) k--;     				
    			}
    			//	�Ʒ� ������ ��� testNums2 ���� case�� �Ÿ��� ���ִ°���??
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
