import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int C, N, count = 0;
  public static int[][] networkList;
  public static boolean[] check;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    C = Integer.parseInt(br.readLine());
    N = Integer.parseInt(br.readLine());

    networkList = new int[C+1][C+1];
    check = new boolean[C+1];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      networkList[a][b] = networkList[b][a] = 1;
    }

    bfs();

    System.out.println(count);
  }

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    check[1] = true;

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int i = 1; i <= C; i++) {
        if (networkList[now][i] == 1 && check[i] == false) {
          q.add(i);
          check[i] = true;
          count++;
        }
      }
    }
  }

}
