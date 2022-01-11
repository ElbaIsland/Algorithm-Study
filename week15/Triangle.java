package week15;

import java.util.*;

public class Triangle {
    
    static int answer = 0;  //  최대값 기본 세팅
    static int[][] triangles;
    
    // 1) 내 풀이
    public int solution1(int[][] triangle) {
        triangles = triangle;
        dfs(0,0,triangle[0][0]); //  처음 삼각형부터 시작(0,0,7)
        
        return answer;
    }
    
    
	public static void dfs(int i,int j, int sum) {
        
        // 마지막 depth까지 내려온것이 아니라면 dfs 진행
		if(i<triangles.length-1) {
			dfs(i+1,j,sum+triangles[i+1][j]); // 다음depth, 대각왼쪽, 현재 숫자를 sum에 더한 값
			dfs(i+1,j+1,sum+triangles[i+1][j+1]); // 다음depth, 대각오른쪽, 현재 숫자를 sum에 더한 값
		}else { 
            // 마지막 depth까지 내려왔다면, max값 처리
			answer = Math.max(answer, sum);
		}
        
	}   
	
	//2) 처리시간 개선 답안
    public int solution2(int[][] triangle) {

        // triangle을 복제한 dp
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i=1; i< triangle.length; i++) {

            // [1][0]부터 시작 => 삼각형[1][0] + 삼각형 맨 위 꼭지점
            dp[i][0] = triangle[i][0] + dp[i - 1][0];   // i번째 처음 꼭지점 + 윗지점

            for (int j=1; j<i+1; j++) {
                // 최댓값 구하는 점화식 적용
                // Math.max(dp[i -1][j - 1], dp[i -1][j]) = 좌우 상부중 최대값
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        // dp 마지막층에서 최대값 구하기
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