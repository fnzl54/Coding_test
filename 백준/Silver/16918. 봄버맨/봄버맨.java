import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    char[][] map = new char[R+1][C+1];
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    for (int i = 1; i <= R; i++) {
      String input = br.readLine();
      for (int j = 1; j <= C; j++) {
        map[i][j] = input.charAt(j-1);
      }
    }

    if (N % 2 == 0) { // 짝수 초 후인 경우 무조건 "O"으로 다 차있음
      for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
          sb.append("O");
        }
        sb.append("\n");
      }
      System.out.println(sb);
      return;
    } else { // 홀수 초인 경우
      for (int t = 0; t < N/2; t++) {
        Queue<int[]> q = new LinkedList<>();

        //조사할 폭탄 위치 저장
        for (int i = 1; i <= R; i++) {
          for (int j = 1; j <= C; j++) {
            if (map[i][j] == 'O') {
              q.add(new int[] {i, j});
            }
          }
        }

        for (int i = 1; i <= R; i++) {
          for (int j = 1; j <= C; j++) {
            map[i][j] = 'O';
          }
        }

        // bfs 구현
        while(!q.isEmpty()) {
          int[] input = q.poll();
          int x = input[0];
          int y = input[1];

          for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (!(tempX < 1 || tempX > R || tempY < 1 || tempY > C)) {
              map[tempX][tempY] = '.';
            }
          }

          map[x][y] = '.';
        }
      }
    }

    for (int i = 1; i <= R; i++) {
      for (int j = 1; j <= C; j++) {
        sb.append(map[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
