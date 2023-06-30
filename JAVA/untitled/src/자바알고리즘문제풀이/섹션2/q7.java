package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q7 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int[] numList = new int[num];
    int answer = 0;

    for (int i = 0; i < num; i++) {
      numList[i] = sc.nextInt();
    }

    int tempAnswer = 0;

    for (int i : numList) {
      if (i == 0) {
        tempAnswer = 0;
      } else {
        tempAnswer++;
        answer += tempAnswer;
      }
    }

    System.out.print(answer);
  }

}