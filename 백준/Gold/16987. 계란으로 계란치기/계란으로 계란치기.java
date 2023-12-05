import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N, answer;
  static int[][] egg;
  static int[] check;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    egg = new int[N][2];
    for (int n = 0; n < N; n++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      egg[n][0] = Integer.parseInt(st.nextToken());
      egg[n][1] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);
    System.out.println(answer);


  }

  static void dfs (int now_egg, int count) {
    if (count == N-1 || now_egg == N) {
      answer = Math.max(answer, count);
      return;
    }

    if (egg[now_egg][0] <= 0) {
      dfs(now_egg + 1, count);
    } else {
      for (int n = 0; n < N; n++) {
        if (n == now_egg) {
          continue;
        } else {
          if (egg[n][0] > 0) {
            egg[now_egg][0] -= egg[n][1];
            egg[n][0] -= egg[now_egg][1];
            dfs(now_egg + 1, count + (egg[now_egg][0] <= 0 ? 1 : 0) + (egg[n][0] <= 0 ? 1 : 0));
            egg[now_egg][0] += egg[n][1];
            egg[n][0] += egg[now_egg][1];
          }
        }
      }
    }
  }

}