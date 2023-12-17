import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N, answer = Integer.MIN_VALUE;
  static ArrayList<int[]>[] graph;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    graph = new ArrayList[N+1];
    for (int i = 1; i < N+1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      graph[from].add(new int[] {to, weight});
      graph[to].add(new int[] {from, weight});
    }

    for (int i = 1; i <= N; i++) {
      check = new boolean[N+1];
      check[i] = true;
      dfs(i, 0);
    }

    System.out.println(answer);
  }

  /*
  dfs 탐색 진행
  - 루트 노드부터 탐색
  - 현재 탐색 노드가 마지막 노드 경우 마지막 노드간의 거리 측정 가능
   */
  static void dfs(int nodeNumber, int nowWeight) {
    if (answer < nowWeight) {
      answer = nowWeight;
    }

    for (int[] i : graph[nodeNumber]) {
      if (!check[i[0]]) {
        check[i[0]] = true;
        dfs(i[0], nowWeight + i[1]);
      }
    }

  }

}