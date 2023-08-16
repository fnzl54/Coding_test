package goormthon_challenge;

import java.util.*;

public class Day2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int M = sc.nextInt();
    int[] pj = new int[N];

    for (int i = 0; i < N; i++) {
      pj[i] = sc.nextInt();
    }

    for (int i : pj) {
      int temp_T = i / 60;
      int temp_M = i % 60;
      T += temp_T;
      M += temp_M;
    }

    // 분 변환
    T += M / 60;
    M = M % 60;

    // 시 변환
    if (T >= 24) {
      T = T % 24;
    }

    System.out.printf("%d %d", T, M);
  }
}
