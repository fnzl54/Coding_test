import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        
        bfs(maps);
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = count;
            }
            
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                
                if (moveX >= 0 && moveY >= 0 && moveX < maps.length && moveY < maps[0].length) {
                    if (maps[moveX][moveY] == 1) {
                        maps[moveX][moveY] = 0;
                        q.add(new int[] {moveX, moveY, count+1});
                    }
                }
            }
        }
        
        
        
    }
}