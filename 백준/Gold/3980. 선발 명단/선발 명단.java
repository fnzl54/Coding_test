import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  public static int C;
  static int[][] positionAbility = new int[11][11];
  static boolean[] check;
  static int answerMax;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    C = Integer.parseInt(br.readLine());

    for (int c = 0; c < C; c++) {

      // 능력치 읿력
      for (int i = 0; i < 11; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          positionAbility[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      answerMax = Integer.MIN_VALUE;
      check = new boolean[11];
      dfs(0, 0);
      sb.append(answerMax + "\n");
    }

    System.out.println(sb);
  }

  static void dfs(int player, int total) {
    if (player == 11) {
      answerMax = Math.max(answerMax, total);
      return;
    }

    for (int i = 0; i < 11; i++) {
      if (!check[i] && positionAbility[player][i] != 0) {
        check[i] = true;
        dfs(player + 1, total + positionAbility[player][i]);
        check[i] = false;
      }
    }
  }

}
