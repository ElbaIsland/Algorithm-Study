package week_2208_03_Queue;

import java.util.*;

/* ====================
 * 
 * ====================

 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        
        // 2진수로 이루어진 nums 배열에서, 해당 2진수 중 빠진 2진수를 구하는 문제
        // nums의 길이 = nums 배열 각 2진수의 길이
        // 1) for문으로 각각의 nums 확인 / 10진수로 변환
        // 2) 
        Arrays.sort(nums);
        List<Integer> numsList = new ArrayList<Integer>();
        
        // 해당 nums의 길이인 n을 구하는 과정
        String maxN = "";
        for(int i = 0; i < nums.length; i++){
            maxN = maxN + "1";
        }
        
        for(int i = 0; i < nums.length; i++){
            int binaryToDecimal = Integer.parseInt(nums[i], 2);
            System.out.println("binaryToDecimal : " + binaryToDecimal);
            numsList.add(binaryToDecimal);
        }
        
        // maxN까지 반복하여 중간에 비어있는 수를 찾아낸다.
        // i번째 수에 해당하는 값이 numsList에 없으면 뱉어내기S
        System.out.println("maxN : " + Integer.parseInt(maxN, 2) + ",numsList.size() : " + numsList.size());
        for(int i = 0; i < Integer.parseInt(maxN, 2); i++){

            System.out.println("numsList.get(i) : " + numsList.get(i));
            // i가 numList의 크기를 넘어서거나, i번째 수가 numList에 없으면
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