package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q3 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] A = new int[num];
    int[] B = new int[num];

    for (int i = 0; i < num; i++) {
      A[i] = sc.nextInt();
    }

    for (int i = 0; i < num; i++) {
      B[i] = sc.nextInt();
    }
    // 1,1,1,2,2,2,3,3,3
    // 1,2,3,1,2,3,1,2,3
    // 0,-1b, -2a,1a,0,-1b,2b,1a,0
    for (int i = 0; i < num; i++) {
      int temp = A[i] - B[i];
      if (temp == 0) {
        System.out.println("D");
      } else if (temp == 1 || temp == -2) {
        System.out.println("A");
      } else {
        System.out.println("B");
      }
    }

  }
}