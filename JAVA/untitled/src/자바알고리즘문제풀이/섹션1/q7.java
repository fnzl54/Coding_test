package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q7 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    s = s.toLowerCase();

    int res = 0;


    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        System.out.print("NO");
        res = 1;
        break;
      }
    }

    if (res == 0) {
      System.out.print("YES");
    }

  }

}