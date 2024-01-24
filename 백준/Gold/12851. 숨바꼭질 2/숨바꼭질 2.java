import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int N, K, minTime = Integer.MAX_VALUE, count = 0;
  static int[] time = new int[100001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 동일한 경우와 이전으로 가는 경우 (디버깅으로 찾음)
    if (N >= K) {
      System.out.println((N-K) + "\n" + "1");
      return;
    }
      
    bfs();

    System.out.println(minTime + "\n" + count);
  }

  public static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    q.add(N);
    time[N] = 1;

    while (!q.isEmpty()) {
      int now = q.poll();

      if (minTime < time[now]) {
        return;
      }

      for (int i = 0; i < 3; i++) {
        int next;

        if (i == 0) {
          next = now - 1;
        } else if (i == 1) {
          next = now + 1;
        } else {
          next = now * 2;
        }

        if (next < 0 || next > 100000) {
          continue;
        } else {
          if (next == K) {
            minTime = time[now];
            count++;
          }
          if (time[next] == 0 || time[next] == time[now] + 1) {
            q.add(next);
            time[next] = time[now] + 1;
          }
        }
      }
    }
  }
  
}