import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  static int R, C, answer = Integer.MIN_VALUE;
  static int[][] map;
  static boolean[][] mapCheck;
  static boolean[] alphabetCheck;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    // 데이터 입력 받기
    map = new int[R][C];
    for (int r = 0; r < R; r++) {
      String input = br.readLine();
      for (int c = 0; c < C; c++) {
        map[r][c] = input.charAt(c) - 'A';
      }
    }

    // dfs를 통해
    mapCheck = new boolean[R][C];
    alphabetCheck = new boolean[26];
    dfs(0, 0, 1);

    System.out.println(answer);
  }

  private static void dfs(int x, int y, int count) {
    answer = Math.max(answer, count);

    alphabetCheck[map[x][y]] = true;
    mapCheck[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];

      if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
        if (!mapCheck[moveX][moveY] && !alphabetCheck[map[moveX][moveY]]) {
          dfs(moveX, moveY, count + 1);
        }
      }
    }

    alphabetCheck[map[x][y]] = false;
    mapCheck[x][y] = false;
  }
  
}