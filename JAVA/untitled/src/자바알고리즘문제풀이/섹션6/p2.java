package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] li = new int[N];

    for (int i = 0; i < N; i++) {
      li[i] = sc.nextInt();
    }

    int count = li.length;

    for (int i = 0; i < li.length; i++) {
      for (int j = 0; j < count-1; j++) {
        if (li[j] > li[j+1]) {
          int temp = li[j];
          li[j] = li[j+1];
          li[j+1] = temp;
        }
      }
      count--;
    }

    for (int i : li) {
      System.out.print(i + " ");
    }

  }
}
