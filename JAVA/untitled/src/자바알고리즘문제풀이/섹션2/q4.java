package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q4 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] numList = new int[num];

    numList[0] = 1;
    numList[1] = 1;

    for (int i = 2; i < num; i++) {
      numList[i] = numList[i-2] + numList[i-1];
    }

    for (int i : numList) {
      System.out.print(i + " ");
    }
  }

}