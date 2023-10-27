import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt( br.readLine());
    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    int[] point = new int[4];

    for (int t = 0; t < T; t++) {
      Queue<int[]> q = new LinkedList<>();
      int L = Integer.parseInt( br.readLine());
      int[][] board = new int[L][L];
      int[][] check = new int[L][L];

      // 현재 위치(1,2)와 이동하려는 위치(3,4)
      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        point[2*i] = Integer.parseInt(st.nextToken());
        point[2*i + 1] = Integer.parseInt(st.nextToken());
      }

      q.add(new int[] {point[0], point[1]});
      board[point[0]][point[1]] = 1;
      check[point[0]][point[1]] = 1;

      while (!q.isEmpty()) {
        int[] nowPoint = q.poll();
        int X = nowPoint[0];
        int Y = nowPoint[1];

        for (int i = 0; i < 8; i++) {
          int moveX = X + dx[i];
          int moveY = Y + dy[i];

          if (moveX >= 0 && moveX < L && moveY >= 0 && moveY < L) {
            if (check[moveX][moveY] == 0) {
              q.add(new int[] {moveX, moveY});
              board[moveX][moveY] = board[X][Y] + 1;
              check[moveX][moveY] = 1;
            }
          }
        }

        if (board[point[2]][point[3]] != 0) {
          sb.append(board[point[2]][point[3]] - 1).append("\n");
          break;
        }
      }
    }

    System.out.println(sb);
  }
}