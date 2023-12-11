import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M, answer = Integer.MAX_VALUE;;
  static int[][] map;
  static List<int[]> house = new ArrayList<>();
  static List<int[]> chicken = new ArrayList<>();
  static List<int[]> pick = new ArrayList<>();
  static int[] check;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          house.add(new int[] {i, j});
        }
        if (map[i][j] == 2) {
          chicken.add(new int[] {i, j});
        }
      }
    }

    check = new int[chicken.size()];
    dfs(0,0);
    System.out.println(answer);
  }

  static void dfs(int depth, int start) {
    if (depth == M) {
      checkMin();
      return;
    }

    for (int i = start; i < chicken.size(); i++) {
      if (check[i] == 0) {
        check[i] = 1;
        pick.add(chicken.get(i));
        dfs(depth + 1, i + 1);
        pick.remove(pick.size() -1);
        check[i] = 0;
      }
    }
  }

  static void checkMin() {
    int tempSum = 0;
    for (int[] h : house) {
      int min = Integer.MAX_VALUE;
      for (int[] p : pick) {
        int distance = Math.abs(h[0] - p[0]) + Math.abs(h[1] - p[1]);
        min = Math.min(distance, min);
      }
      tempSum += min;
    }

    answer = Math.min(answer, tempSum);
  }

}