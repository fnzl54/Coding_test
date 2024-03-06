import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  public static int T, N;
  public static int[] parent;
  public static boolean[] check;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    while (T --> 0) {
      N = Integer.parseInt(br.readLine());
      parent = new int[N+1];
      check = new boolean[N+1];

      for (int n = 1; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        parent[B] = A;
      }

      st = new StringTokenizer(br.readLine());
      int Q1 = Integer.parseInt(st.nextToken());
      int Q2 = Integer.parseInt(st.nextToken());
      solutions(Q1, Q2);
    }

    System.out.println(sb);

  }

  static public void solutions(int Q1, int Q2) {
    while (Q1 > 0) {
      check[Q1] = true;
      Q1 = parent[Q1];
    }

    while (Q2 > 0) {
      if (check[Q2]) {
        sb.append(Q2).append("\n");
        break;
      } else {
        Q2 = parent[Q2];
      }
    }
  }

}