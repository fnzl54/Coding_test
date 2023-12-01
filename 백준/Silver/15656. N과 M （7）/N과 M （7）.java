import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
  static int N, M;
  static int[] arr, check, input;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    input = new int[N];
    check = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      input[n] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(input);

    dfs(0);

    System.out.println(sb);
  }

  static void dfs (int depth) {
    if (depth == M) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int n = 0; n < N; n++) {
      arr[depth] = input[n];
      dfs(depth + 1);
    }
  }

}