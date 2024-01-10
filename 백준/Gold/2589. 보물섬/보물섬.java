import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, time = 0;
  static int[][] map;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static char land[][];
  static int check[][];

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    land = new char[N][M];
    for (int n = 0; n < N; n++) {
      String input = br.readLine();
      for (int m = 0; m < M; m++) {
        land[n][m] = input.charAt(m);
      }
    }

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (land[n][m] == 'L') {
          check = new int[N][M];
          bfs(n, m);
        }
      }
    }

    System.out.println(time);
  }

  private static void bfs(int i, int j) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {i, j});

    check[i][j] = 1;
    while(!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int n = 0; n < 4; n++) {
        int moveX = x + dx[n];
        int moveY = y + dy[n];
        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
          if (check[moveX][moveY] == 0 && land[moveX][moveY] == 'L') {
            q.add(new int[] {moveX, moveY});
            check[moveX][moveY] = check[x][y] + 1;
            time = Math.max(time, check[moveX][moveY] - 1);
          }
        }
      }
    }
  }

}