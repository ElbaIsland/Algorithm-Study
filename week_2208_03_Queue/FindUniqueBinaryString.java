package week_2208_03_Queue;

import java.util.*;

/* ====================
 * 
 * ====================

 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        
        // 2������ �̷���� nums �迭����, �ش� 2���� �� ���� 2������ ���ϴ� ����
        // nums�� ���� = nums �迭 �� 2������ ����
        // 1) for������ ������ nums Ȯ�� / 10������ ��ȯ
        // 2) 
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<Integer>();
        
        // �ش� nums�� ������ n�� ���ϴ� ����
        String maxN = "";
        for(int i = 0; i < nums.length; i++){
            maxN = maxN + "1";
        }
        
        for(int i = 0; i < nums.length; i++){
            int binaryToDecimal = Integer.parseInt(nums[i], 2);
            System.out.println("binaryToDecimal : " + binaryToDecimal);
            numsList.add(binaryToDecimal);
        }
        
        // maxN���� �ݺ��Ͽ� �߰��� ����ִ� ���� ã�Ƴ���.
        // i��° ���� �ش��ϴ� ���� numsList�� ������ ����S
        System.out.println("maxN : " + Integer.parseInt(maxN, 2) + ",numsList.size() : " + numsList.size());
        for(int i = 0; i < Integer.parseInt(maxN, 2); i++){

            System.out.println("numsList.get(i) : " + numsList.get(i));
            // i�� numList�� ũ�⸦ �Ѿ�ų�, i��° ���� numList�� ������
            if(i > numsList.size() || i != numsList.get(i)){
                
                if(i == 0){
                    String zeroReturn  = "";
                    for(int j = 1; j < Integer.parseInt(maxN, 2); j++){
                        zeroReturn = zeroReturn + "0";
                    }
                    return zeroReturn;
                }
                else return Integer.toBinaryString(i);
            }         
            
        }
        
        return "00";
        
    }
}