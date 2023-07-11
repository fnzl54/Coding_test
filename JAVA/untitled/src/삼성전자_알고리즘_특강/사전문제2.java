package 삼성전자_알고리즘_특강;

import java.util.*;

public class 사전문제2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    int N = 0, M = 0, Q = 0;
    int r = 0, c = 0, x = 0;
    List<int[]> before = new ArrayList<>();

    for (int t = 1; t <= T; t++) {

      N = sc.nextInt();
      M = sc.nextInt();
      Q = sc.nextInt();

      int[][] origin = new int[N][M];
      int answer = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          origin[i][j] = sc.nextInt();
        }
      }

      //초기 찾기
      for (int row = 0; row < N; row++) {
        int row_max = Arrays.stream(origin[row]).max().getAsInt();

        List<Integer> rowList = new ArrayList<>();
        for (int element : origin[row]) {
          rowList.add(element);
        }

        int row_location = rowList.indexOf(row_max);

        int col_max = 0;
        int col_location = 0;
        for (int col = 0; col < N; col++) {
          if (col_max < origin[col][row_location]) {
            col_max = origin[col][row_location];
            col_location = col;
          }
        }

        if (row_max == col_max) {
          int[] temp = {col_location, row_location};
          before.add(temp);
        }

      }

      // -> 이후에 변경점만 찾는데 만일 같은 행과 열이 아니면 기존거 저장했다가 착지
      for (int i = 0; i < Q; i++) {
        int max  = 0;

        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        x = sc.nextInt();

        origin[r][c] = x;

        int before_size = before.size();
        for (int j = 0; j < before_size; j++) {
          if ( before.get(j)[0] == r || before.get(j)[1] == c) {
            int row_max = Arrays.stream(origin[r]).max().getAsInt();

            List<Integer> rowList = new ArrayList<>();
            for (int element : origin[r]) {
              rowList.add(element);
            }

            int row_location = rowList.indexOf(row_max);

            int col_max = 0;
            int col_location = 0;
            for (int col = 0; col < N; col++) {
              if (col_max < origin[col][row_location]) {
                col_max = origin[col][row_location];
                col_location = col;
              }
            }

            if (row_max == col_max) {
              int[] temp = {col_location, row_location};
              before.add(temp);
              before.remove(j);
            }

          } else {
            int row_max = Arrays.stream(origin[r]).max().getAsInt();

            List<Integer> rowList = new ArrayList<>();
            for (int element : origin[r]) {
              rowList.add(element);
            }

            int row_location = rowList.indexOf(row_max);

            int col_max = 0;
            int col_location = 0;
            for (int col = 0; col < N; col++) {
              if (col_max < origin[col][row_location]) {
                col_max = origin[col][row_location];
                col_location = col;
              }
            }

            if (row_max == col_max) {
              int[] temp = {col_location, row_location};
              before.add(temp);
            }
          }

        }
        answer += before.size();
      }
      System.out.println("#" + t + " " + answer);
    }
  }
}
