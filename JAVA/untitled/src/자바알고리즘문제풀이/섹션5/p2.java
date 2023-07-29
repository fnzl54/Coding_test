package 자바알고리즘문제풀이.섹션5;

import java.util.*;

public class p2 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String input = sc.next();
    Stack<Character> s = new Stack<Character>();


    for (char c : input.toCharArray()) {
      if ( c == ')') {
        int stackSize = s.size();
        for (int i = 0; i < stackSize; i++) {
          if (s.peek() == '(') {
            s.pop();
            break;
          } else {
            s.pop();
          }
        }
      } else {
        s.add(c);
      }
    }

    for (int i = 0; i < s.size(); i++) {
      System.out.print(s.get(i));
    }
  }
}
