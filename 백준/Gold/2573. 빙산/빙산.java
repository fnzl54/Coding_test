import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M, answer = 0;;
  static int[][] map;
  static boolean[][] check;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};

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

    while (true) {
      int islandCount = countIsland();

      if (islandCount >= 2) {
        break;
      } else if (islandCount == 0) {
        answer = 0;
        break;
      }

      bfs();
      answer++;
    }

    System.out.println(answer);

  }

  private static int countIsland() {
    int count = 0;
    check = new boolean[N][M];

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (!check[n][m] && map[n][m] > 0) {
          oneIsland(n, m, check);
          count++;
        }
      }
    }

    return count;
  }

  private static void oneIsland(int x, int y, boolean[][] check) {
    check[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        if (!check[nx][ny] && map[nx][ny] > 0) {
          oneIsland(nx, ny, check);
        }
      }
    }
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    check = new boolean[N][M];

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (map[n][m] > 0) {
          q.add(new int[] {n, m});
          check[n][m] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      int waterCount = 0; // 빙산 근접 바닷물 영역의 개수

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
          if (!check[nx][ny] && map[nx][ny] == 0) {
            waterCount++;
          }
        }
      }

      if (map[x][y] - waterCount < 0) {
        map[x][y] = 0;
      } else {
        map[x][y] -= waterCount;
      }
    }

  }
  
}
