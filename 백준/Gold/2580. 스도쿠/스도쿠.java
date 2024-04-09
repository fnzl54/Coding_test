import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  static int[][] input = new int[9][9];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        input[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);
  }

  private static void dfs(int row, int col) {

    if (col == 9) {
      dfs(row + 1, 0);
      return;
    }

    if (row == 9) {
      StringBuilder sb =  new StringBuilder();
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(input[i][j]).append(' ');
        }
        sb.append('\n');
      }
      System.out.println(sb);
      System.exit(0);
    }

    if (input[row][col] == 0) {
      for (int i = 1; i <= 9; i++) {
        if (possibility(row, col, i)) {
          input[row][col] = i;
          dfs(row, col + 1);
        }
      }
      input[row][col] = 0;
      return;
    }

    dfs(row, col + 1);
  }

  private static boolean possibility(int row, int col, int tempNumber) {
    for (int i = 0; i < 9; i++) {
      if (input[row][i] == tempNumber) {
        return false;
      }
    }

    for (int i = 0; i < 9; i++) {
      if (input[i][col] == tempNumber) {
        return false;
      }
    }

    int nowRow = (row / 3) * 3;
    int nowCol = (col / 3) * 3;

    for (int i = nowRow; i < nowRow + 3; i++) {
      for (int j = nowCol; j < nowCol + 3; j++) {
        if (input[i][j] == tempNumber) {
          return false;
        }
      }
    }

    return true;
  }
}
