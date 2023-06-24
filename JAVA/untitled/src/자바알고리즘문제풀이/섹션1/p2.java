package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class p2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();
    String s = sc.next();

    for (char c : s.toCharArray()) {
      if ((int)c >= 97 ) {
        sb.append((char)((int)c-32));
      } else {
        sb.append((char)((int)c+32));
      }
    }

    System.out.println(sb);
  }

}