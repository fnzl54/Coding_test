import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static int C, N, answer = Integer.MAX_VALUE;
  public static int[] dp;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    C = Integer.parseInt(st.nextToken()); // 적어도 늘려야 하는 고객 수
    N = Integer.parseInt(st.nextToken()); // 도시의 갯수

    dp = new int[C + 100];
    Arrays.fill(dp, 99999999);
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cost = Integer.parseInt(st.nextToken());
      int people = Integer.parseInt(st.nextToken());

      for (int j = people; j < C + 100; j++) {
        dp[j] = Math.min(dp[j], dp[j-people] + cost);
      }
    }

    for (int i = C; i < C + 100; i++) {
      answer = Math.min(answer, dp[i]);
    }

    System.out.println(answer);
  }

}