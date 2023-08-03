package 자바알고리즘문제풀이.섹션6;

import java.util.*;

public class p5 {

  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    HashSet<Integer> hs = new HashSet<Integer>();

    for (int i = 0; i < N; i++) {
      hs.add(sc.nextInt());
    }

    if (hs.size() == N) {
      System.out.print("U");
    } else {
      System.out.print("D");
    }
  }
}
