import java.util.*;
// 배 length 문 length() col size()
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }
        
        
        System.out.print(Arrays.toString(citations));
        
        return answer;
    }
}