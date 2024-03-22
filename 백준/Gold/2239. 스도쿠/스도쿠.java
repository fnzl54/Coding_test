import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  static int[][] map = new int[9][9];
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      String input = br.readLine();
      for (int j = 0; j < 9; j++) {
        map[i][j] = input.charAt(j) - '0';
      }
    }

    dfs(0);

    for (int[] i : map) {
      for (int j : i) {
        sb.append(j);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void dfs(int depth) {
    if  (depth == 81) {
      flag = true;
      return;
    }

    int x = depth / 9;
    int y = depth % 9;

    if (map[x][y] != 0) {
      dfs(depth + 1);
    } else {
      for (int i = 1; i < 10; i++) {
        if (check(x, y, i)) {
          map[x][y] = i;
          dfs(depth + 1);

          if (flag) {
            return;
          }

          map[x][y] = 0;
        }
      }
    }

  }

  private static boolean check(int x, int y, int now) {
    for (int i = 0; i < 9; i++) { // 가로 세로 확인
      if (map[i][y] == now || map[x][i] == now) {
        return false;
      }
    }

    int rectangleX = x/3 * 3; // 3*3 확인
    int rectangleY = y - y%3;
    for (int i = rectangleX; i < rectangleX + 3; i++) {
      for (int j = rectangleY; j < rectangleY + 3; j++) {
        if (map[i][j] == now) {
          return false;
        }
      }
    }

    return true;
  }

}