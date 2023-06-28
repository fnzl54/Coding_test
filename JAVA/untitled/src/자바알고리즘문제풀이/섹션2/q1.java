package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q1 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] numList = new int[num];

    for (int i = 0; i < num; i++) {
      numList[i] = sc.nextInt();
    }

    System.out.print(numList[0] + " ");

    for (int i = 1; i < num; i++) {
      if (numList[i - 1] < numList[i]) {
        System.out.print(numList[i] + " ");
      }
    }

  }
}
