import java.util.*;

public class Main {

  public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int[] dp = new int[12];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i < 12; i++) {
      dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
    }

    for (int i = 0; i < T; i++) {
      int temp_num = sc.nextInt();
      System.out.println(dp[temp_num]);
    }

  }
}