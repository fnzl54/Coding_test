import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      String W = sc.next();
      int K = sc.nextInt();

      if (K == 1) {
        System.out.println("1 1");
        continue;
      }

      int[] alpha = new int[26];
      for (int i = 0; i < W.length(); i++) {
        alpha[W.charAt(i) - 'a']++;
      }

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for (int i = 0; i < W.length(); i++) {
        if ( alpha[W.charAt(i) - 'a'] < K) {
          continue;
        } else {
          int count = 1;
          for (int j = i+1; j < W.length(); j++) {
            if (W.charAt(j) == W.charAt(i)) {
              count++;
            }
            if (count == K) {
              min = Math.min(min, j - i + 1);
              max = Math.max(max, j - i + 1);
              break;
            }
          }
        }
      }
      if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
        System.out.println("-1");
      } else {
        System.out.println(min + " " + max);
      }
    }
  }
}