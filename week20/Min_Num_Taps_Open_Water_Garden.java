package week20;


public class Min_Num_Taps_Open_Water_Garden {
    public int minTaps(int n, int[] ranges) {
        
        // **���� ������� : ���������� ���ִ� ������ ���� ���ĵ� �������!
        //    => �������� ������ OK
        // n : garden�� ������ ����Ʈ (��, ��������(taps)�� n + 1��ŭ ���� )
        
        int[] nowTap= new int[n+1];
        for(int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            nowTap[left] = right;
        }
        
        int current = 0, maxR = 0, answer = 0;
        
        for(int i = 0; i <= n; i++) {

            if(maxR < i) return -1;

            if(current < i) {
                current = maxR;
                answer++;
            }
            
            maxR = Math.max(maxR, nowTap[i]);
        }
        
        return answer ;
    }
}