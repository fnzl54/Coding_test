import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] input_list = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      input_list[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = 1;
    for (int i = 1; i < N; i++) {
      int temp_max = 0;
      for (int j = i-1; j >= 0; j--) {
        if (input_list[i] > input_list[j]) {
          temp_max = Math.max(temp_max, dp[j]);
        }
      }
      dp[i] = temp_max + 1;
    }

    Arrays.sort(dp);

    System.out.println(dp[N-1]);
  }
}
