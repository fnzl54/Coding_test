import java.util.Scanner;

public class Day11 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int A = scanner.nextInt();
    int B = scanner.nextInt();

    int[] dp = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      dp[i] = Integer.MAX_VALUE; // int 타입 배열을 최대값으로 초기화
    }

    dp[0] = 0;

    for (int i = 0; i <= N; i++) {
      if (i - A >= 0 && dp[i - A] != Integer.MAX_VALUE) {
        dp[i] = Math.min(dp[i], dp[i - A] + 1);
      }
      if (i - B >= 0 && dp[i - B] != Integer.MAX_VALUE) {
        dp[i] = Math.min(dp[i], dp[i - B] + 1);
      }
    }

    System.out.println(dp[N] != Integer.MAX_VALUE ? dp[N] : -1);
  }
}