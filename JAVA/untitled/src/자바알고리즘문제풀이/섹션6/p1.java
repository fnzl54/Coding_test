package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p1 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] li = new int[N];

    for (int i = 0; i < N; i++) {
      li[i] = sc.nextInt();
    }

    for (int i = 0; i < li.length; i++) {
      int idx = i;

      for (int j = i+1; j < li.length; j++) {
        if (li[idx] > li[j]) {
          idx = j;
        }
      }

      //i idx 위치 변경
      int i_num = li[i];
      li[i] = li[idx];
      li[idx] = i_num;

    }

    for (int i : li) {
      System.out.print(i + " ");
    }

  }
}