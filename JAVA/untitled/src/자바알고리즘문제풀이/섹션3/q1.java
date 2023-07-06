package 자바알고리즘문제풀이.섹션3;

import java.util.*;

public class q1 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    List<Integer> answer = new ArrayList<Integer>();

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      answer.add(sc.nextInt());
    }

    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      answer.add(sc.nextInt());
    }

    Collections.sort(answer);

    for (int i : answer) {
      System.out.print(i + " ");
    }

  }
}