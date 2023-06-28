package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q12 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    String s = sc.next();

    for (int i = 0; i < num; i++) {
      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < 7; j++) {
        if ( s.charAt(i*7 + j) == '#') {
          sb.append(1);
        } else {
          sb.append(0);
        }
      }
      System.out.print((char)Integer.parseInt(sb.toString(), 2));
    }

  }
}