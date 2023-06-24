package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class p4 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    for (int i = 0; i < num; i++) {
      String word = sc.next();

      for (int j = word.length() - 1; j >= 0; j--) {
        System.out.print(word.charAt(j));
      }

      System.out.println();
    }
  }

}