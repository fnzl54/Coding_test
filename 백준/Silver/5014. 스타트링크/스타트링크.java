import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Queue<int[]> q = new LinkedList<>();

    int F = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int G = Integer.parseInt(st.nextToken());
    int U = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    int[] check = new int[F];

    q.add(new int[] {S, 1});
    check[S-1] = 1;

    if (S == G) {
      System.out.println("0");
      return;
    }

    while (!q.isEmpty()) {
      int[] input = q.poll();
      int nowFloor = input[0];
      int count = input[1];
      int upFloor = nowFloor + U;
      int downFloor = nowFloor - D;

      // 층수에 도착한 경우
      if (upFloor == G || downFloor == G) {
        System.out.println(count);
        return;
      }

      // 올라가는 경우
      if (upFloor < F && check[upFloor-1] == 0) {
        q.add(new int[] {upFloor, count+1});
        check[upFloor-1] = 1;
      }

      // 내려가는 경우
      if (downFloor > 0 && check[downFloor-1] == 0) {
        q.add(new int[] {downFloor, count+1});
        check[downFloor-1] = 1;
      }

    }

    System.out.println("use the stairs");
  }
}
