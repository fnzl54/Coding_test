import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] input = new int[N+2][2];
    int[] dp = new int[N+2];
    int max = Integer.MIN_VALUE;

    for (int n = 1; n <= N; n++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      input[n][0] = Integer.parseInt(st.nextToken());
      input[n][1] = Integer.parseInt(st.nextToken());
    }

    for (int n = 1; n <= N+1; n++) {
      if (max < dp[n]) {
        max = dp[n];
      }

      int temp = n + input[n][0];
      if (temp < N + 2) {
        dp[temp] = Math.max(dp[temp], max + input[n][1]);
      }
    }

    System.out.println(dp[N+1]);
  }
}