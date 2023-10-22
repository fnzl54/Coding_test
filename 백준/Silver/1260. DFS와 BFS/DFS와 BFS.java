import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  static int N, M, V, count;
  static int[][] graph;
  static int[] check;
  static Queue<Integer> q = new LinkedList<>();
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N =Integer.parseInt(st.nextToken());
    M =Integer.parseInt(st.nextToken());
    V =Integer.parseInt(st.nextToken());
    graph = new int[N+1][N+1];
    check = new int[N+1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a][b] = graph[b][a] = 1;
    }

    check = new int[1001];
    check[V] = 1;
    count = 0;
    sb = new StringBuilder();
    DFS(V);
    System.out.println(sb);

    check = new int[1001];
    q.add(V);
    check[V] = 1;
    sb = new StringBuilder();
    BFS(V);
    System.out.println(sb);

  }

  public static void DFS(int v) {

    if (count == N) {
      return;
    }

    sb.append(v).append(" ");
    count++;

    for (int i = 1; i <= N; i++) {
      if (graph[v][i] == 1 && check[i] == 0) {
        check[i] = 1;
        DFS(i);
      }
    }
  }

  public static void BFS(int v) {
    sb.append(v).append(" ");

    while (!q.isEmpty()) {
      int start = q.poll();

      for (int i = 1; i <= N; i++) {
        if (graph[start][i] == 1 && check[i] == 0) {
          q.add(i);
          check[i] = 1;
          sb.append(i).append(" ");
        }
      }
    }
  }
}
