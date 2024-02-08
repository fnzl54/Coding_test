import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int N, K, answer = 0;
  public static boolean[] check = new boolean[100001];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    bfs();

    System.out.println(answer);
  }

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {N, 0});
    check[N] = true;
    while (!q.isEmpty()) {
      int[] now = q.poll();
      int location = now[0];
      int count = now[1];

      if (location == K) {
        answer = count;
        return;
      }

      if (location - 1 >= 0) {
        if (!check[location - 1]) {
          check[location - 1] = true;
          q.add(new int[] {location - 1, count+1});
        }
      }

      if (location + 1 <= 100000) {
        if (!check[location + 1]) {
          check[location + 1] = true;
          q.add(new int[] {location + 1, count+1});
        }
      }

      if (location * 2 <= 100000) {
        if (!check[location * 2]) {
          check[location * 2] = true;
          q.add(new int[] {location * 2, count+1});
        }
      }
    }
  }

}
