import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  public static int N;
  public static int[][] map;
  public static List<Integer> answer = new ArrayList<>();
  public static int[] dx = {-1, 0, 0, 1};
  public static int[] dy = {0, -1, 1, 0};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = input.charAt(j) - '0';
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          bfs(i, j);
        }
      }
    }

    Collections.sort(answer);

    sb.append(answer.size() + "\n");
    for (int i : answer) {
      sb.append(i + "\n");
    }

    System.out.println(sb);
  }

  static void bfs(int startX, int startY) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {startX, startY});
    int count = 1;
    map[startX][startY] = 0;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveY >= 0 && moveX < N && moveY < N) {
          if (map[moveX][moveY] == 1) {
            q.add(new int[] {moveX, moveY});
            map[moveX][moveY] = 0;
            count++;
          }
        }
      }
    }

    answer.add(count);
  }

}
