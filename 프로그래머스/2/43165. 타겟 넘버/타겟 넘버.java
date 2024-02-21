class Solution {
    private int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    private void dfs(int depth, int tempNumber, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (tempNumber == target) {
                answer++;
            }
            return;
        }
        
        dfs(depth+1, tempNumber+numbers[depth], numbers, target);
        dfs(depth+1, tempNumber-numbers[depth], numbers, target);
    }
}