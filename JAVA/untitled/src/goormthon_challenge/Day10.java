package goormthon_challenge;

import java.util.*;

public class Day10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Rg =sc.nextInt() - 1, Cg =sc.nextInt() - 1;
    int Rp =sc.nextInt() - 1, Cp =sc.nextInt() - 1;
    int g_point = 0, c_point = 0;
    boolean check = true;
    // 왼쪽, 오른쪽, 위, 아래
    int[][] coordinate = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    String[][] board = new String[N][N];
    int[][] g_check_board = new int[N][N];
    g_check_board[Rg][Cg] = 1;
    int[][] p_check_board = new int[N][N];
    p_check_board[Rp][Cp] = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = sc.next();
      }
    }

    // groom 게임
    while(check) {
      int num = (int) board[Rg][Cg].charAt(0) - 48;
      char dir = board[Rg][Cg].charAt(1);

      for (int i = 0; i < num; i++) {
        switch (dir) {
          case 'L':
            Rg += coordinate[0][0];
            Cg += coordinate[0][1];
            if (Cg < 0) {
              Cg = N-1;
            }
            break;
          case 'R':
            Rg += coordinate[1][0];
            Cg += coordinate[1][1];
            if (Cg >= N) {
              Cg = 0;
            }
            break;
          case 'U':
            Rg += coordinate[2][0];
            Cg += coordinate[2][1];
            if (Rg < 0) {
              Rg =N-1;
            }
            break;
          case 'D':
            Rg += coordinate[3][0];
            Cg += coordinate[3][1];
            if (Rg >= N) {
              Rg = 0;
            }
            break;
          default:
            break;
        }

        if (g_check_board[Rg][Cg] != 1) {
          g_check_board[Rg][Cg] = 1;
        } else {
          check = false;
          break;
        }
      }
    }

    check = true;
    while(check) {
      int num = (int) board[Rp][Cp].charAt(0) - 48;
      char dir = board[Rp][Cp].charAt(1);

      for (int i = 0; i < num; i++) {
        switch (dir) {
          case 'L':
            Rp += coordinate[0][0];
            Cp += coordinate[0][1];
            if (Cp < 0) {
              Cp = N-1;
            }
            break;
          case 'R':
            Rp += coordinate[1][0];
            Cp += coordinate[1][1];
            if (Cp >= N) {
              Cp = 0;
            }
            break;
          case 'U':
            Rp += coordinate[2][0];
            Cp += coordinate[2][1];
            if (Rp < 0) {
              Rp =N-1;
            }
            break;
          case 'D':
            Rp += coordinate[3][0];
            Cp += coordinate[3][1];
            if (Rp >= N) {
              Rp = 0;
            }
            break;
          default:
            break;
        }

        if (p_check_board[Rp][Cp] != 1) {
          p_check_board[Rp][Cp] = 1;
        } else {
          check = false;
          break;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (g_check_board[i][j] == 1) {
          g_point++;
        }
        if (p_check_board[i][j] == 1) {
          c_point++;
        }
      }
    }

    if (g_point > c_point) {
      System.out.println("goorm " + g_point);
    } else {
      System.out.println("player " + c_point);
    }

  }
}