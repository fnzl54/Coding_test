import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static final int dx[] = {0,-1,1,0};
  static final int dy[] = {-1,0,0,1};
  static int N, M, answer = 0;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        map[n][m] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);

    System.out.println(answer);
  }

  // 벽을 3개 사용하는 모든 경우 조사
  static void dfs(int depth) {
    if (depth == 3) {
      bfs();
      return;
    }

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (map[n][m] == 0) {
          map[n][m] = 1;
          dfs(depth + 1);
          map[n][m] = 0;
        }
      }
    }
  }

  // 벽이 3개인 경우 안전 영역 조사
  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    int cleanCount = 0;

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (map[n][m] == 2) {
          q.add(new int[] {n, m});
        }
      }
    }

    int[][] copyMap = new int[N][M];
    for (int n = 0; n < N; n++) {
      copyMap[n] = map[n].clone();
    }

    while(!q.isEmpty()) {
      int[] current = q.poll();
      int x = current[0];
      int y = current[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
          if (copyMap[moveX][moveY] == 0) {
            q.add(new int[] {moveX, moveY});
            copyMap[moveX][moveY] = 2;
          }
        }
      }
    }

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (copyMap[n][m] == 0) {
          cleanCount++;
        }
      }
    }

    answer = Math.max(answer, cleanCount);
  }
}