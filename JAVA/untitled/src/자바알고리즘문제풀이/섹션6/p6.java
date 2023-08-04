package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] hight = new int[N];

    for (int i = 0; i < N; i++) {
      hight[i] = sc.nextInt();
    }

    int[] temp_hight = hight.clone();

    Arrays.sort(hight);

    for (int i = 0; i < N; i++) {
      if (temp_hight[i] != hight[i]) {
        System.out.print( i+1 + " " );
      }
    }
  }
}
