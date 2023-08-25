package goormthon_challenge;

import java.util.*;

public class Day9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    String[][] ground = new String[N+2][N+2];
    int[][] coordinate = {{-1, 0}, {0, -1}, {0, 0}, {0, 1}, {1, 0}};
    int[] answer = new int[N*N];

    // ground 초기화
    for (int i = 0; i < N+2; i++) {
      for (int j = 0; j < N+2; j++) {
        ground[i][j] = "1";
      }
    }

    // ground 입력
    for (int i = 1; i < N+1; i++) {
      for (int j = 1; j < N+1; j++) {
        ground[i][j] = sc.next();
      }
    }

    for (int k = 0; k < K; k++) {
      int x = sc.nextInt();
      int y = sc.nextInt();


      for (int[] c : coordinate) {
        switch (ground[x-c[0]][y-c[1]]) {
          case "0":
            answer[ (x-c[0]-1)*N + (y-c[1] - 1) ]++;
            break;
          case "@":
            answer[ (x-c[0]-1)*N + (y-c[1] - 1) ] += 2;
            break;
          default:
            break;
        }
      }
    }

    Arrays.sort(answer);
    System.out.println(answer[N*N - 1]);
  }
}