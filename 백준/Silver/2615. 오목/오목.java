import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  static int[][] map;
  static boolean[][] check;
  static int[][] dxy = {
      {0, 1}, // 우
      {1, 1}, // 우하
      {1, 0}, // 하
      {1, -1}, // 좌하
      {0, -1}, // 좌
      {-1, -1}, // 좌상
      {-1, 0}, // 상
      {-1, 1} // 우상
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    map = new int[19][19];
    for(int i = 0; i < 19; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 19; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int j = 0; j < 19; j++) {
      for(int i = 0; i < 19; i++) {
        for (int d = 0; d < 4; d++) {
          if (map[i][j] != 0) {
            if (dfs(i, j, d, map[i][j])) {
              sb.append(map[i][j]).append("\n").append(i+1).append(" ").append(j+1);
              System.out.println(sb);
              return;
            }
          }
        }
      }
    }

    System.out.println("0");

  }

  private static boolean dfs(int x, int y, int direction, int stoneColor) {
    int moveX = x + dxy[direction][0];
    int moveY = y + dxy[direction][1];
    int preMoveX = x + dxy[direction + 4][0];
    int preMoveY = y + dxy[direction + 4][1];
    int totalCount = 1;
    int preCount = 0;

    while((0 <= preMoveX && preMoveX < 19 && 0 <= preMoveY && preMoveY < 19) && map[preMoveX][preMoveY] == stoneColor) {
      preMoveX += dxy[direction + 4][0];
      preMoveY += dxy[direction + 4][1];
      preCount++;
    }

    totalCount += preCount;

    while((0 <= moveX && moveX < 19 && 0 <= moveY && moveY < 19) && map[moveX][moveY] == stoneColor) {
      moveX += dxy[direction][0];
      moveY +=  dxy[direction][1];
      totalCount++;
    }

    if (totalCount == 5) {
      return true;
    } else {
      return false;
    }

  }
}
