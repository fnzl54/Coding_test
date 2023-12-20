import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  static int N = 8, time = 0, answer = 0;
  static int[][] map = new int[N][N];
  static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
  static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 (빈칸 -> 0, 벽 -> 1)
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        if (input.charAt(j) == '#') {
          map[i][j] = 1;
        } else {
          map[i][j] = 0;
        }
      }
    }

    bfs();

    if (answer == 0) {
      System.out.println(0);
    } else {
      System.out.println(1);
    }
  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {7, 0, 0}); //x, y, time

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];
      int t = now[2];

      // 도착한 경우
      if (x == 0 && y == 7) {
        answer = 1;
        return;
      }

      // 시간이 변한 경우
      if (time != t) {
        time = t;
        moveMap();
      }

      if (map[x][y] == 0) {
        for (int i = 0; i < 9; i++) {
          int moveX = x + dx[i];
          int moveY = y + dy[i];

          if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < N){
            if (map[moveX][moveY] == 0) {
              q.add(new int[] {moveX, moveY, t+1});
            }
          }
        }
      }
    }
  }

  static void moveMap() {
    List<int[]> movePoint = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          movePoint.add(new int[] {i, j});
          map[i][j] = 0;
        }
      }
    }

    for (int[] point : movePoint) {
      int moveX = point[0] + 1;
      int moveY = point[1];

      if (moveX < N) {
        map[moveX][moveY] = 1;
      }
    }
  }

}