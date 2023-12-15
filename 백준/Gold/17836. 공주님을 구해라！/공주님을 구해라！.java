import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M, T;
  static boolean isKnife = false;
  static int[][] map, check, weight;
  static int[] knifePoint = {0, 0};
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer1 = 0, answer2 = 0;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        map[n][m] = Integer.parseInt(st.nextToken());
      }
    }

    check = new int[N][M];
    weight = new int[N][M];
    bfs();
    answer1 = weight[N-1][M-1];

    if (isKnife) {
      check = new int[N][M];
      bfsK();
      answer2 = weight[N-1][M-1];
    }

    if (answer1 == 0 && answer2 == 0) {
      System.out.println("Fail");
    } else {
      if (Math.min(answer1, answer2) == 0) {
        if (Math.max(answer1, answer2) > T) {
          System.out.println("Fail");
        } else {
          System.out.println(Math.max(answer1, answer2));
        }
      } else {
        if (Math.min(answer1, answer2) > T) {
          System.out.println("Fail");
        } else {
          System.out.println(Math.min(answer1, answer2));
        }
      }
    }

  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0});
    check[0][0] = 1;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && check[moveX][moveY] == 0) {
          if (map[moveX][moveY] != 1) {
            if (map[moveX][moveY] == 2) {
              knifePoint[0] = moveX;
              knifePoint[1] = moveY;
              isKnife = true;
            }
            check[moveX][moveY] = 1;
            q.add(new int[] {moveX, moveY});
            weight[moveX][moveY] = weight[x][y] + 1;
          }
        }
      }
    }
  }

  static void bfsK() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {knifePoint[0], knifePoint[1]});
    check[knifePoint[0]][knifePoint[1]] = 1;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && check[moveX][moveY] == 0) {
          check[moveX][moveY] = 1;
          q.add(new int[] {moveX, moveY});
          weight[moveX][moveY] = weight[x][y] + 1;
        }
      }
    }
  }

}