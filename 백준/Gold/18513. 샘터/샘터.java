import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int N, K, pointModifyNumber = 200000000, house = 0;
  public static long answer = 0;
  public static boolean[] map;
  public static Queue<int[]> q = new LinkedList<>();
  public static int[] dx = {-1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new boolean[(pointModifyNumber * 2) + 1];
    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      int input = Integer.parseInt(st.nextToken());
      map[input + pointModifyNumber] = true;
      q.add(new int[] {input + pointModifyNumber, 0});
    }

    bfs();

    System.out.println(answer);
  }

  public static void bfs() {
    while (!q.isEmpty() && house != K) {
      int[] now = q.poll();
      int x = now[0];
      int distance = now[1];

      for (int i = 0; i < 2; i++) {
        int moveX = x + dx[i];

        if (0 <= moveX && moveX <= pointModifyNumber * 2 && house != K) { // 확인하는 위치가 map 범위 안에 있는지 확인
          if (!map[moveX]) { // 집을 놓을 위치가 집이나 우물 자리가 아닌지 확인
            answer += (distance + 1);
            house += 1;
            map[moveX] = true;
            q.add(new int[] {moveX, distance + 1});
          }
        }
      }
    }
  }

}
