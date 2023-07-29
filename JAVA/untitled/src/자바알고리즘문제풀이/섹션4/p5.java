package 자바알고리즘문제풀이.섹션4;

import java.util.*;

public class p5 {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] li = new int[N];
    int answer = -1;

    TreeSet<Integer> ts = new TreeSet<Integer>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      li[i] = sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int l = j + 1; l < N; l++) {
          ts.add(li[i] + li[j] + li[l]);
        }
      }
    }

    int count = 0;

    for (int i : ts) {
      count++;
      if (count == K) {
        answer = i;
        break;
      }
    }

    System.out.print(answer);
  }
}
