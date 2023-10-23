import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N+1][M+1];
    int[][] check = new int[N+1][M+1];
    Queue<int[]> q = new LinkedList<>();
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          q.add(new int[] {i, j});
          map[i][j] = 0;
          check[i][j] = 1;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX > 0 && moveX <= N && moveY > 0 && moveY <= M) {
          if (map[moveX][moveY] != 0 && check[moveX][moveY] == 0) {
            map[moveX][moveY] = map[x][y] + 1;
            q.add(new int[] {moveX, moveY});
            check[moveX][moveY] = 1;
          }
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (check[i][j] == 0 && map[i][j] == 1) {
          sb.append("-1").append(" ");
        } else {
          sb.append(map[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}