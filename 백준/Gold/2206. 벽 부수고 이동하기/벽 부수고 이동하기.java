import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[][] map;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = input.charAt(j) - '0';
      }
    }

    if (N == 1 && M == 1) {
      System.out.println(1);
      System.exit(0);
    }

    System.out.println(bfs());
  }

  private static int bfs() {
    // 0은 벽을 안 부수고 지나가는 노드, 1은 벽을 부수고 지나가는 노드
    int[][][] check = new int[2][N][M];

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0, 0});
    check[0][0][0] = 1;

    while (!q.isEmpty()) {

      int[] now = q.poll();
      int b = now[0]; // 벽을 부신 여부
      int x = now[1];
      int y = now[2];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= N || nx < 0 || ny >= M || ny < 0) {
          continue;
        }

        if (map[nx][ny] == 0) {
          if (check[b][nx][ny] == 0) {
            q.offer(new int[] {b, nx, ny});
            check[b][nx][ny] = check[b][x][y] + 1;
            if (nx == N - 1 && ny == M - 1) {
              return check[b][nx][ny];
            }

          }
        }
        else {
          if (b == 0) {
            if (check[1][nx][ny] == 0) {
              q.offer(new int[] {1, nx, ny});
              check[1][nx][ny] = check[0][x][y] + 1;
              if (nx == N - 1 && ny == M - 1) {
                return check[1][nx][ny];
              }
            }
          }
        }

      }
    }

    return -1;
  }

}