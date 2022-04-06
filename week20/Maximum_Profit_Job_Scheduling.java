package week20;

import java.util.Arrays;
import java.util.TreeMap;

public class Maximum_Profit_Job_Scheduling {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        
        System.out.println(Arrays.deepToString(jobs));
        Arrays.sort(jobs, (a, b)->a[1] - b[1]); //  ?
        System.out.println(Arrays.deepToString(jobs));
        
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();        
        
        
    }
}