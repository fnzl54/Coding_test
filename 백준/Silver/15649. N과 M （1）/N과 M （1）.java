import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static  int[] arr;
  static boolean[] check;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    check = new boolean[N];
    dfs(N, M, 0);
    System.out.println(sb);

  }

  public static void dfs(int N, int M, int depth) {
    if (M == depth) {
      for (int i : arr) {
        sb.append(i).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int n = 0; n < N; n++) {
      if (!check[n]) {
        check[n] = true;
        arr[depth] = n+1;
        dfs(N, M, depth + 1);
        check[n] = false;
      }
    }
  }
}