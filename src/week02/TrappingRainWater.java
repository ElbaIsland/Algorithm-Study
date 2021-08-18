package week02;

public class TrappingRainWater {
    public int trap(int[] height) {	// 각 index에 해당하는 기둥 높이
    	
    	//	최초 왼쪽, 오른쪽 index를 설정한 뒤 좁혀가면서 고인 빗물을 계산할 예정
        int leftIndexChk=0;
        int rightIndexChk=height.length-1;
        
        int trappedRain=0;
        
        // 동적으로 변하는 왼쪽, 오른쪽의 (빗물이 고이는)가장 큰 기둥
        int leftmax=0;
        int rightmax=0;
        
        //	인덱스를 하나씩 옮기면서 반복
        while(leftIndexChk <= rightIndexChk){
        	
        	// 각 INDEX별 가장 높은 기둥을 변수에 저장
            leftmax = Math.max(leftmax, height[leftIndexChk]);
            rightmax = Math.max(rightmax, height[rightIndexChk]);
            
            // leftmax is smaller than rightmax,
            // so the (leftmax-height[leftIndexChk]) water can be stored
            // => 왼쪽 INDEX 기준 기둥에서 leftmax 뺀 값이 빗물고여있는 양이라고....?
            
            if(leftmax < rightmax){
            	trappedRain += (leftmax - height[leftIndexChk]);      
                leftIndexChk++;
            }
            else{
            	trappedRain += (rightmax - height[rightIndexChk]);
                rightIndexChk--;
            }
            
        }
        return trappedRain;
        
    }
}
