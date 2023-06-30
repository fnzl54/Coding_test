package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q9 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[][] table = new int[num][num];
    int answer = 0;
    int temp = 0;


    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        table[i][j] = sc.nextInt();
      }
    }


    for (int i = 0; i < num; i++) {
      temp = 0;
      for (int j = 0; j < num; j++) {
        temp += table[i][j];
      }
      if (temp > answer) {
        answer = temp;
      }
    }

    for (int i = 0; i < num; i++) {
      temp = 0;
      for (int j = 0; j < num; j++) {
        temp += table[j][i];
      }
      if (temp > answer) {
        answer = temp;
      }
    }

    temp = 0;
    for (int i = 0; i < num; i++) {
      temp += table[i][i];
      if (temp > answer) {
        answer = temp;
      }
    }

    temp = 0;
    for (int i = 0; i < num; i++) {
      temp += table[i][num - 1 - i];
      if (temp > answer) {
        answer = temp;
      }
    }

    System.out.print(answer);

  }

}