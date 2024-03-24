import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  static int M, N;
  static int[][] map;
  static int[] robotStart; // [0] x, [1] y, [2] dir, [3] count
  static int[] robotEnd; // [0] x, [1] y, [2] dir, [3] count
  static boolean[][][] check; // x, y, dir
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N+1][M+1];
    check = new boolean[N+1][M+1][5];
    for (int n = 1; n <= N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 1; m <= M; m++) {
        map[n][m] = Integer.parseInt(st.nextToken());
      }
    }

    robotStart = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      robotStart[i] = Integer.parseInt(st.nextToken());
    }
    robotStart[3] = 0;

    robotEnd = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 3; i++) {
      robotEnd[i] = Integer.parseInt(st.nextToken());
    }
    robotEnd[3] = 0;

    bfs();
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    check[robotStart[0]][robotStart[1]][robotStart[2]] = true;
    q.add(robotStart);

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];
      int dir = now[2];
      int count = now[3];

      if (x == robotEnd[0] && y == robotEnd[1] && dir == robotEnd[2]) {
        System.out.println(count);
        break;
      }

      // 1~3 칸 전진 여부 확인
      for (int i = 1; i <= 3; i++) {
        int moveX = x + (dx[dir - 1] * i);
        int moveY = y + (dy[dir - 1] * i);

        if (moveX > 0 && moveX <= N && moveY > 0 && moveY <= M) {
          if (map[moveX][moveY] == 0) {
            if (!check[moveX][moveY][dir]) {
              check[moveX][moveY][dir] = true;
              q.add(new int[] {moveX, moveY, dir, count + 1});
            }
          } else {
            break;
          }
        }
      }

      // 방향 전환 여부 확인 (반대 방향인 경우 ++ 해주어서 count 추가)
      for (int i = 1; i <= 4; i++) {
        if (dir != i && !check[x][y][i]) {
          int tempTurnCount = 1;

          if (dir == 1) {
            if (i == 2) {
              tempTurnCount++;
            }
          } else if (dir == 2) {
            if (i == 1) {
              tempTurnCount++;
            }
          } else if (dir == 3) {
            if (i == 4) {
              tempTurnCount++;
            }
          } else {
            if (i == 3) {
              tempTurnCount++;
            }
          }

          check[x][y][i] = true;
          q.add(new int[] {x, y, i, count + tempTurnCount});
        }
      }

    }

  }

}