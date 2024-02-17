import java.util.*;

class Solution {
    private static boolean[] check;
    private static int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        check = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < N; i++) {
                if (now != i && computers[now][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}