package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class q9 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    List<Character> cList = new ArrayList<>();

    for (char c : s.toCharArray()) {
      if (48 <= (int)c && (int)c <= 57) {

        if ((int)c == 48 && cList.size() == 0) {
          continue;
        } else {
          cList.add(c);
        }


      }
    }

    for (char c : cList) {
      System.out.print(c);
    }
  }
}
