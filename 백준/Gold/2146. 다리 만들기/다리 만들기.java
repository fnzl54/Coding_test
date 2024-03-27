import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  static int N, landNumber = 2, answer = Integer.MAX_VALUE;
  static int[][] map;
  static boolean[][] check;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    // 데이터 입력 받기
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 섬 별로 구분하기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          makeIslandGroup(i, j);
        }
      }
    }

    // 최단거리 찾기
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] > 1) {
          check = new boolean[N][N];
          findBridgeLength(i, j);
        }
      }
    }

    System.out.println(answer);
  }

  private static void makeIslandGroup(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {x, y}); // x좌표, y좌표
    map[x][y] = landNumber;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int X = now[0];
      int Y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = X + dx[i];
        int moveY = Y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
          if (map[moveX][moveY] == 1) {
            map[moveX][moveY] = landNumber;
            q.add(new int[] {moveX, moveY});
          }
        }
      }
    }

    landNumber++;
  }

  private static void findBridgeLength(int x, int y) {
    int nowIslandNumber = map[x][y];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {x, y, 0}); // x좌표, y좌표, 다리 길이
    check[x][y] = true;
    while (!q.isEmpty()) {
      int[] now = q.poll();
      int X = now[0];
      int Y = now[1];
      int count = now[2];

      for (int i = 0; i < 4; i++) {
        int moveX = X + dx[i];
        int moveY = Y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
          if (!check[moveX][moveY] && map[moveX][moveY] != nowIslandNumber) {
            check[moveX][moveY] = true;
            if (map[moveX][moveY] == 0) {
              q.add(new int[] {moveX, moveY, count + 1});
            } else {
              answer = Math.min(answer, count);
            }
          }
        }
      }
    }

  }
  
}