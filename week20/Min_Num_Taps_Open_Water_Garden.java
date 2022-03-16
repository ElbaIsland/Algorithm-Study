package week20;


public class Min_Num_Taps_Open_Water_Garden {
    public int minTaps(int n, int[] ranges) {
        
        // **문제 참고사항 : 수도꼭지의 물주는 범위는 서로 겹쳐도 상관없다!
        //    => 끝까지만 닿으면 OK
        // n : garden의 마지막 포인트 (즉, 수도꼭지(taps)는 n + 1만큼 존재 )
        
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