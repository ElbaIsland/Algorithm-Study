package week15;

import java.util.*;

public class Triangle {
    
    static int answer = 0;  //  �ִ밪 �⺻ ����
    static int[][] triangles;
    
    // 1) �� Ǯ��
    public int solution1(int[][] triangle) {
        triangles = triangle;
        dfs(0,0,triangle[0][0]); //  ó�� �ﰢ������ ����(0,0,7)
        
        return answer;
    }
    
    
	public static void dfs(int i,int j, int sum) {
        
        // ������ depth���� �����°��� �ƴ϶�� dfs ����
		if(i<triangles.length-1) {
			dfs(i+1,j,sum+triangles[i+1][j]); // ����depth, �밢����, ���� ���ڸ� sum�� ���� ��
			dfs(i+1,j+1,sum+triangles[i+1][j+1]); // ����depth, �밢������, ���� ���ڸ� sum�� ���� ��
		}else { 
            // ������ depth���� �����Դٸ�, max�� ó��
			answer = Math.max(answer, sum);
		}
        
	}   
	
	//2) ó���ð� ���� ���
    public int solution2(int[][] triangle) {

        // triangle�� ������ dp
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i=1; i< triangle.length; i++) {

            // [1][0]���� ���� => �ﰢ��[1][0] + �ﰢ�� �� �� ������
            dp[i][0] = triangle[i][0] + dp[i - 1][0];   // i��° ó�� ������ + ������

            for (int j=1; j<i+1; j++) {
                // �ִ� ���ϴ� ��ȭ�� ����
                // Math.max(dp[i -1][j - 1], dp[i -1][j]) = �¿� ����� �ִ밪
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        // dp ������������ �ִ밪 ���ϱ�
        int max = 0;
        for (int i=0; i<dp[dp.length - 1].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        int answer = max;
        return answer;
    } 
    
    
    public static void main(String[] args) {
		
    	Triangle ts = new Triangle();
    	int[][] testCase = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
    	ts.solution1(testCase);
    	
    	
	}
   
}