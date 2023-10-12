import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] number = new int[N];
    int[] dp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = number[0];
    for (int i = 1; i < N; i++) {
      int tempNum = i-1;
      while (tempNum >= 0) {
        if (number[i] > number[tempNum]) {
          dp[i] = Math.max(dp[i], dp[tempNum] + number[i]);
        }
        tempNum--;
      }
      if (dp[i] == 0) {
        dp[i] = number[i];
      }
    }

    Arrays.sort(dp);
    System.out.println(dp[N-1]);
  }
}