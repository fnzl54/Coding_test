package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q10 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[][] table = new int[num + 2][num + 2];
    int answer = 0;

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= num; j++) {
        table[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= num; j++) {
        if (table[i][j] > table[i-1][j] && table[i][j] > table[i][j-1] && table[i][j] > table[i+1][j] && table[i][j] > table[i][j+1]) {
          answer++;
        }
      }
    }

    System.out.print(answer);

  }

}