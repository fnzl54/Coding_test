package 삼성전자_알고리즘_특강;

import java.util.*;

public class 사전문제1 {

  static List<int[]> manitos; // 마니또 관계 리스트
  static boolean[] visited; // 방문 여부
  static int minCost; // 가장 작은 선물 비용

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); // 테스트케이스 개수

    for (int t = 1; t <= T; t++) {
      int N = sc.nextInt(); // 학생 수
      int M = sc.nextInt(); // 마니또 관계 수

      manitos = new ArrayList<>();

      for (int i = 0; i < M; i++) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        int cost = sc.nextInt();
        manitos.add(new int[]{from, to, cost});
      }

      minCost = Integer.MAX_VALUE;

      for (int i = 1; i <= N; i++) {
        visited = new boolean[N + 1];
        dfs(i, i, 0, 0);
      }

      if (minCost == Integer.MAX_VALUE) {
        System.out.println("#" + t + " -1");
      } else {
        System.out.println("#" + t + " " + minCost);
      }
    }
  }

  private static void dfs(int start, int current, int totalCost, int count) {
    // 마니또 사이클 확인
    if (start == current && count > 0) {
      minCost = Math.min(minCost, totalCost);
      return;
    }

    visited[current] = true;

    for (int[] manito : manitos) {
      if (manito[0] == current && start == manito[1]) {
        current = manito[1];
        dfs(start, current, totalCost + manito[2], count + 1);
      } else if (manito[0] == current && !visited[manito[1]]) {
        dfs(start, manito[1], totalCost + manito[2], count + 1);
      }
    }

    visited[current] = false;
  }


}
