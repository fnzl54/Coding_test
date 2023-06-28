package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] numList = new int[num];
    int answer = 1;
    int max = 0;

    for (int i = 0; i < num; i++) {
      numList[i] = sc.nextInt();
    }

    max = numList[0];

    for (int i = 1; i < num; i++) {
      if (max < numList[i]) {
        answer++;
        max = numList[i];
      }
    }

    System.out.print(answer);

  }
}
