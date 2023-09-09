import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      HashSet<Integer> set = new HashSet<>();
      StringBuilder sb = new StringBuilder();

      for (int n = 0; n < N; n++) {
        set.add(sc.nextInt());
      }

      int M = sc.nextInt();
      for (int m = 0; m < M; m++) {
        sb.append(set.contains(sc.nextInt()) ? 1 : 0).append("\n");
      }

      System.out.print(sb);

    }
  }
}
