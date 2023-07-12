package 삼성전자_알고리즘_특강;

import java.util.*;

public class 사전문제2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int N = 0, M = 0, Q = 0;
    int r = 0, c = 0, x = 0;

    for (int t = 1; t <= T; t++) {

      N = sc.nextInt();
      M = sc.nextInt();
      Q = sc.nextInt();

      int[][] origin = new int[N][M];
      int[] max_row = new int[N];
      int[] max_col = new int[M];
      int answer = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          origin[i][j] = sc.nextInt();

          // 행의 최대 개체 수 업데이트
          max_row[i] = Math.max(max_row[i], origin[i][j]);

          // 열의 최대 개체 수 업데이트
          max_col[j] = Math.max(max_col[j], origin[i][j]);
        }
      }

      for (int k = 0; k < Q; k++) {
        r = sc.nextInt() - 1; // 관측 보고서 위치의 행
        c = sc.nextInt() - 1; // 관측 보고서 위치의 열
        x = sc.nextInt(); // 새로운 외계 곰팡이 개체 수

        origin[r][c] = x;

        max_row[r] = Math.max(max_row[r], x);
        max_col[c] = Math.max(max_col[c], x);

        for (int a = 0; a < N; a++) {
          for (int b = 0; b < M; b++) {
            if (max_row[a] == max_col[b]) {
              if (origin[a][b] == max_row[a]) {
                answer++;
                break;
              } else {
                break;
              }
            }
          }
        }
      }

      System.out.println("#" + t + " " + answer);
    }
  }
}

// Solution