import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static  int[] answer;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    answer = new int[M];
    visited = new boolean[N+1];
    dfs(N, M, 0, 1);
    System.out.println(sb);

  }

  public static void dfs(int N, int M, int depth, int start) {
    if (M == depth) {
      for (int i : answer) {
        sb.append(i).append(' ');
      }
      sb.append('\n');
      return;
    }

    for (int n = start; n <= N; n++) {
      if (!visited[n]) {
        visited[n] = true;
        answer[depth] = n;
        dfs(N, M, depth + 1, n+1);
        visited[n] = false;
      }
    }
  }
}