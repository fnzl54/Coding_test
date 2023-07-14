package 자바알고리즘문제풀이.섹션3;

import java.util.*;

public class p5 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int answer = 0;

    int[] li = new int[n];

    for (int i = 0; i < (n / 2) + 2; i++) {
      li[i] = i;
    }

    int f = 0, e = 1;

    while (e < (n / 2) + 2) {
      int temp = 0;

      for (int i = f; i <= e; i++) {
        temp += li[i];
      }

      if (temp == n) {
        answer++;
        e++;
      } else if (temp < n) {
        e++;
      } else {
        f++;
      }
    }

    System.out.println(answer);

  }
}