package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q11 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    char lw = s.charAt(0);
    int rn = 1;

    for (int i = 1; i < s.length(); i++) {
      if (lw == s.charAt(i)) {
        rn++;
      } else {
        if (rn == 1) {
          System.out.print(lw);
        } else {
          System.out.print(lw + String.valueOf(rn));
          rn = 1;
        }
        lw = s.charAt(i);
      }
    }

    if (rn == 1) {
      System.out.print(lw);
    } else {
      System.out.print(lw + String.valueOf(rn));
    }

  }
}
