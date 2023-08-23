package goormthon_challenge;

import java.util.*;

public class Day7 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] game_board = new int[N+2][N+2];
    int answer = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        game_board[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {

        if (game_board[i][j] != 1) {
          int groom_num = 0;

          for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
              if (game_board[i+a][j+b] == 1) {
                groom_num++;
              }
            }
          }

          if (groom_num == K) {
            answer++;
          }
        }

      }
    }

    System.out.println(answer);
  }
}
