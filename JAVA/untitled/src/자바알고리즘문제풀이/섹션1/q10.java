package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q10 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    char c = sc.next().charAt(0);
    List<Integer> cLoc = new ArrayList<Integer>();
    int min = 100;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        cLoc.add(i);
      }
    }


    for (int i = 0; i < s.length(); i++) {
      min = 100;

      for (int j : cLoc) {
        if (min > Math.abs(i - j)) {
          min = Math.abs(i - j);
        }
      }

      System.out.print(min + " ");
    }


  }
}