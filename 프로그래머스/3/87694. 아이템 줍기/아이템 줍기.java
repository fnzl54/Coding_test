import java.util.*;

class Solution {
    
    static char map[][] = new char[101][101];
    static int answer = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] check;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] input : rectangle) {
            int x1 = input[0] * 2; 
            int y1 = input[1] * 2;
            int x2 = input[2] * 2;
            int y2 = input[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (map[i][j] == '1')  {
                        continue;
                    }
                    map[i][j] = '1';
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        map[i][j] = '2';
                    }
                }
            }
        }
        
        check = new boolean[101][101];
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;
    }
    
    private void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {characterX, characterY, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int count = now[2];
            
            if (x == itemX && y == itemY) {
                answer = count / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                
                if (moveX >= 0 && moveY >= 0 && moveX < map.length && moveY < map[0].length) {
                    if (!check[moveX][moveY] && map[moveX][moveY] == '2') {
                        check[moveX][moveY] = true;
                        q.add(new int[] {moveX, moveY, count + 1});
                    }
                }
            }
            
        }

        
        
    }
}