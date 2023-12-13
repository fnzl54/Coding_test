import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] cheese, check;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    List<Integer> remainCheese = new ArrayList<>();
    int time = 0, initCount;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());


    cheese = new int[N][M];
    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        cheese[n][m] = Integer.parseInt(st.nextToken());
      }
    }

    initCount = getCheeseCount();

    while (true) {
      time++;

      check = new int[N][M];
      bfs(new int[] {0, 0});

      int countCheese = getCheeseCount();
      if (countCheese != 0) {
        remainCheese.add(countCheese);
      } else {
        break;
      }
    }

    if (remainCheese.size() > 0) {
      sb.append(time).append("\n").append(remainCheese.get(remainCheese.size() - 1));
    } else {
      sb.append(time).append("\n").append(initCount);
    }

    System.out.println(sb);
  }

  static void bfs(int[] start) {
    Queue<int[]> q = new LinkedList<>();
    q.add(start);
    check[start[0]][start[1]] = 1;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M && check[nx][ny] == 0) {
          if (cheese[nx][ny] == 1) {
            cheese[nx][ny] = 2;
            check[nx][ny] = 1;
          }
          if (cheese[nx][ny] == 0) {
            check[nx][ny] = 1;
            q.add(new int[] {nx, ny});
          }
        }
      }
    }

    // 치즈 지우기
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (cheese[n][m] == 2) {
          cheese[n][m] = 0;
        }
      }
    }

  }

  static int getCheeseCount() {
    int count = 0;

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (cheese[n][m] == 1) {
          count++;
        }
      }
    }

    return count;
  }

}