package 자바알고리즘문제풀이.섹션3;


import java.util.*;

public class p3 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int[] l1 = new int[n1];

    for (int i = 0; i < n1; i++) {
      l1[i] = sc.nextInt();
    }

    int max = 0, temp = 0;
    for (int i = 0; i < n2; i++) {
      max += l1[i];
    }

    temp = max;


    for (int i = n2; i < n1; i++) {
      temp = temp - l1[i-n2] + l1[i];
      if (temp > max) {
        max = temp;
      }
    }

    System.out.print(max);

  }
}