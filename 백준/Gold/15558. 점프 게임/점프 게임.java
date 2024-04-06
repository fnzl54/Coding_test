import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  static int N, K, answer = 0;
  static boolean[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    arr = new boolean[2][N + K + 1];

    for (int i = 0; i < 2; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        if (input.charAt(j) == '0') {
          arr[i][j] = true;
        }
      }
    }

    if (arr[0][0]) {
      System.out.println(0);
      return;
    }

    bfs();
    System.out.println(answer);

  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0, 0});
    arr[0][0] = false;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int lineNumber = now[0];
      int index = now[1];
      int time = now[2];

      if (index >= N) {
        answer = 1;
        return;
      }

      if (!arr[lineNumber][index + 1]) {
        arr[lineNumber][index + 1] = true;
        q.add(new int[] {lineNumber, index+1, time+1});
      }

      if (index - 1 > time && !arr[lineNumber][index - 1]) {
        arr[lineNumber][index - 1] = true;
        q.add(new int[] {lineNumber, index-1, time+1});
      }

      if (!arr[1 - lineNumber][index+K]) {
        arr[1 - lineNumber][index + K] = true;
        q.add(new int[] {1 - lineNumber, index + K, time + 1});
      }
    }
  }

}