import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];
    dp[1] = 0;

    for (int i = 2; i <= N; i++) {
      int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;

      if ( i % 2 == 0) {
        int temp_num = i / 2;
        a = dp[temp_num] + 1;
      }
      if ( i % 3 == 0) {
        int temp_num = i / 3;
        b = dp[temp_num] + 1;
      }

      int temp_num = i - 1;
      c = dp[temp_num] + 1;

      dp[i] = Math.min(Math.min(a, b), c);
    }

    System.out.println(dp[N]);
  }
}