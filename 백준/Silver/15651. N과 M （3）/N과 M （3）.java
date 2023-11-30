import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, M, answer = 0;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M+1];

    dfs(1);

    System.out.println(sb);

  }

  static void dfs (int depth) {
    if (depth == M+1) {
      for (int i = 1; i < depth; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      arr[depth] = i;
      dfs(depth + 1);
      arr[depth] = 0;
    }
  }

}