import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(br.readLine());
    long[][] dp = new long[N][N];

    dp[0][0] = 1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int input = Integer.parseInt(st.nextToken());

        if (dp[i][j] >= 1 && input != 0) {
          if (j + input < N) {
            dp[i][j + input] += dp[i][j];
          }
          if (i + input < N) {
            dp[i + input][j] += dp[i][j];
          }
        }
      }
    }

    System.out.println(dp[N-1][N-1]);
  }
}
