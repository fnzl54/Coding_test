import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static double answer;
  static double[] directionPercent = new double[4];
  static int[][] check = new int[30][30];
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < 4; i++) {
      directionPercent[i] = Double.parseDouble(st.nextToken()) / 100.0;
    }

    check[15][15] = 1;
    dfs(0, 15, 15, 1.0);

    System.out.println(answer);
  }

  private static void dfs(int depth, int x, int y, double percent) {
    if (check[x][y] == 2) {
      return;
    }

    if (depth == N) {
      answer += percent;
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (directionPercent[i] != 0) {
        int moveX = x + dx[i];
        int moveY = y + dy[i];

        check[moveX][moveY] += 1;
        dfs(depth + 1, moveX, moveY, percent * directionPercent[i]);
        check[moveX][moveY] -= 1;
      }
    }

  }
  
}