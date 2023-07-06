package 자바알고리즘문제풀이.섹션3;

import java.util.*;

public class p2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    List<Integer> answer = new ArrayList<Integer>();

    int n1 = sc.nextInt();
    int[] l1 = new int[n1];
    for (int i = 0; i < n1; i++) {
      l1[i] = sc.nextInt();
    }

    int n2 = sc.nextInt();
    int[] l2 = new int[n2];
    for (int i = 0; i < n2; i++) {
      l2[i] = sc.nextInt();
    }

    Arrays.sort(l1);
    Arrays.sort(l2);

    int p1 = 0, p2 = 0;
    while (p1 != n1 && p2 != n2) {
      if (l1[p1] == l2[p2]) {
        answer.add(l1[p1]);
        p1++;
        p2++;
      } else if (l1[p1] < l2[p2]) {
        p1++;
      } else if (l1[p1] > l2[p2]) {
        p2++;
      }
    }

    for (int i : answer) {
      System.out.print(i + " ");
    }
  }
}