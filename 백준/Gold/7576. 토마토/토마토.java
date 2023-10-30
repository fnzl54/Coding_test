import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Queue<int[]> q = new LinkedList<>();

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[][] tomato = new int[N][M];
    int[][] check = new int[N][M];
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int answer = 0;

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        tomato[n][m] = Integer.parseInt(st.nextToken());
        if (tomato[n][m] == 1) {
          check[n][m] = 1;
          q.add(new int[] {n, m});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] input = q.poll();
      int x = input[0];
      int y = input[1];

      for (int i = 0 ; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && check[moveX][moveY] == 0 && tomato[moveX][moveY] != -1) {
          tomato[moveX][moveY] = tomato[x][y] + 1;
          check[moveX][moveY] = 1;
          q.add(new int[] {moveX, moveY});
        }
      }

    }

    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        if (tomato[n][m] == 0) {
          System.out.println("-1");
          return;
        }
        answer = Math.max(answer, tomato[n][m]);
      }
    }

    System.out.println(answer - 1);

  }
}