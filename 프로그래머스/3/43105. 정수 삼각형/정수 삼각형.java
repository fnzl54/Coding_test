import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = triangle.clone();
        
        for (int i = 1; i < triangle.length; i++) {
            // 맨 왼쪽
            dp[i][0] = triangle[i][0] + triangle[i-1][0];
            
            // 중앙
            for (int j = 1; j < triangle[i].length-1; j++) {
                int left = triangle[i][j] + triangle[i-1][j-1];
                int right = triangle[i][j] + triangle[i-1][j];
                dp[i][j] = Math.max(left, right);
            }
            
            // 맨 오른쪽
            dp[i][triangle[i].length-1] 
                = triangle[i][triangle[i].length-1] + triangle[i-1][triangle[i-1].length-1];
        }
        
        Arrays.sort(dp[dp.length-1]);
        answer = dp[dp.length-1][dp.length-1];

        return answer;
    }
}