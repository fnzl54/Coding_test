import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
  static int N;
  static int[] answer = {0, 0};
  static char[][] colorBoard;
  static boolean[][] checked;
  static int dx[] = {-1, 0, 0, 1};
  static int dy[] = {0, -1, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    colorBoard = new char[N][N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        colorBoard[i][j] = input.charAt(j);
      }
    }

    checked = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!checked[i][j]) {
          dfs(i, j);
          answer[0]++;
        }
      }
    }

    // 적녹 생명인경우
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (colorBoard[i][j] == 'G') {
          colorBoard[i][j] = 'R';
        }
      }
    }

    checked = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!checked[i][j]) {
          dfs(i, j);
          answer[1]++;
        }
      }
    }

    System.out.println(answer[0] + " " + answer[1]);
  }

  public static void dfs(int x, int y) {
    checked[x][y] = true;
    Character nowColor = colorBoard[x][y];
    for (int i = 0; i < 4; i++) {
      int moveX = x + dx[i];
      int moveY = y + dy[i];

      if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
        if (!checked[moveX][moveY] && nowColor == colorBoard[moveX][moveY]) {
          dfs(moveX, moveY);
        }
      }
    }

  }
}