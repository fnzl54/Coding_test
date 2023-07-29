package 자바알고리즘문제풀이.섹션5;

import java.util.*;

public class p1 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String input = sc.next();
    Stack<Character> s = new Stack<Character>();
    int answer = 0;

    for (char c : input.toCharArray()) {
      if ( c == '(') {
        s.add(c);
      } else {
        if (s.empty()) {
          answer = 1;
          break;
        } else {
          s.pop();
        }
      }
    }

    if (answer == 1 || !s.empty()) {
      System.out.print("NO");
    } else {
      System.out.print("YES");
    }
  }
}
