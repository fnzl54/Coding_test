import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long max = (long) times[times.length-1] * n;
        long min = 1;
        long mid = 0, sum, answer = max;
        
        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;
            
            for (int t : times) {
                sum += mid / t;
            }
            
            if (sum >= n) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            
        }
        
        return answer;
    }
}