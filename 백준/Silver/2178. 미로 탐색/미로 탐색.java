import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Queue<int[]> q = new LinkedList<>();
    int[][] map = new int[N+1][M+1];
    int[][] check = new int[N+1][M+1];
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};


    for (int i = 1; i <= N; i++) {
      String input = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = input.charAt(j-1) - '0';
      }
    }

    check[1][1] = 1;
    q.add(new int[] {1,1});

    while (!q.isEmpty()) {
      int input[] = q.poll();
      int x = input[0];
      int y = input[1];

      for (int i = 0; i < 4; i++) {
        int tempX = x + dx[i];
        int tempY = y + dy[i];

        if (!(tempX < 1 || tempX > N || tempY < 1 || tempY > M)) {
          if (check[tempX][tempY] == 0 && map[tempX][tempY] != 0) {
            q.add(new int[] {tempX, tempY});
            map[tempX][tempY] = map[x][y] + 1;
            check[tempX][tempY] = 1;
          }
        }
      }
    }

    System.out.println(map[N][M]);
  }
}