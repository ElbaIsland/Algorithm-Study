package week02;

public class TrappingRainWater {
    public int trap(int[] height) {	// �� index�� �ش��ϴ� ��� ����
    	
    	//	���� ����, ������ index�� ������ �� �������鼭 ���� ������ ����� ����
        int leftIndexChk=0;
        int rightIndexChk=height.length-1;
        
        int trappedRain=0;
        
        // �������� ���ϴ� ����, �������� (������ ���̴�)���� ū ���
        int leftmax=0;
        int rightmax=0;
        
        //	�ε����� �ϳ��� �ű�鼭 �ݺ�
        while(leftIndexChk <= rightIndexChk){
        	
        	// �� INDEX�� ���� ���� ����� ������ ����
            leftmax = Math.max(leftmax, height[leftIndexChk]);
            rightmax = Math.max(rightmax, height[rightIndexChk]);
            
            // leftmax is smaller than rightmax,
            // so the (leftmax-height[leftIndexChk]) water can be stored
            // => ���� INDEX ���� ��տ��� leftmax �� ���� �������ִ� ���̶��....?
            
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
