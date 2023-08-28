import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int[][] dp = new int[30][30];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 30; i++) {
      dp[0][i] = i+1;
    }

    for (int i = 0; i < 30; i++) {
        dp[i][i] = 1;
    }

    for (int i = 1; i < 30; i++) {
      for (int j = i+1; j < 30; j++) {
        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
      }
    }

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      int M = sc.nextInt();

      sb.append(dp[N-1][M-1]).append("\n");
    }

    System.out.println(sb);
  }
}