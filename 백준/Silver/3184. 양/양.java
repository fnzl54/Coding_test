import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int R, C;
  static char[][] ground;
  static int[][] check;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static int totalSheep, totalWolf;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st =new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    ground = new char[R][C];
    check = new int[R][C];
    
    for (int r = 0; r < R; r++) {
      String input = br.readLine();
      for (int c = 0; c < C; c++) {
        ground[r][c] = input.charAt(c);
      }
    }

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (ground[r][c] != '#' && check[r][c] != 1) {
          bfs(r, c);
        }
      }
    }

    System.out.println(totalSheep + " " + totalWolf);
  }

  static void bfs(int r, int c) {
    Queue<int[]> q = new LinkedList<>();
    check[r][c] = 1;
    q.add(new int[] {r, c});
    int countSheep = 0, countWolf = 0;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      if (ground[x][y] == 'o') {
        countSheep++;
      }
      if (ground[x][y] == 'v') {
        countWolf++;
      }

      for (int i = 0; i < 4; i++) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
          if (check[moveX][moveY] != 1 && ground[moveX][moveY] != '#') {
            check[moveX][moveY] = 1;
            q.add(new int[] {moveX, moveY});
          }
        }
      }
    }

    if (countSheep > countWolf) {
      totalSheep += countSheep;
    } else {
      totalWolf += countWolf;
    }
  }

}