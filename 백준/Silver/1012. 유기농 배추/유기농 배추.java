import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int T, M, N, K;
  public static int[][] map;
  public static boolean[][] check;
  public static Queue<int[]> q;
  public static int[] dx = {-1, 0, 0, 1};
  public static int[] dy = {0, -1, 1, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());


    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      int answer = 0;

      map = new int[M][N];
      check = new boolean[M][N];
      q = new LinkedList<>();

      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
      }

      for (int m = 0; m < M; m++) {
        for (int n = 0; n < N; n++) {
          if (map[m][n] == 1 && !check[m][n]) {
            bfs(m, n);
            answer++;
          }
        }
      }

      System.out.println(answer);

    }
  }

  static void bfs(int m, int n) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {m, n});

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];
      check[x][y] = true;
      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0 && moveX < M && moveY < N) {
          if (!check[moveX][moveY] && map[moveX][moveY] == 1) {
            q.add(new int[] {moveX, moveY});
            check[moveX][moveY] = true;
          }
        }
      }
    }
  }

}