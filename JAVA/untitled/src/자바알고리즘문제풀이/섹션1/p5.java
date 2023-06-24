package 자바알고리즘문제풀이.섹션1;

import java.util.*;

public class p5 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String text = sc.next();
    Stack<Character> st = new Stack<>();

    // System.out.println((int)'A'); 65
    // System.out.println((int)'z'); 122
    for (char c : text.toCharArray()) {
      if ((int)c <= 122 && (int)c >= 65) {
        st.add(c);
      }
    }

    for (char c : text.toCharArray()) {
      if ((int)c <= 122 && (int)c >= 65) {
        System.out.print(st.pop());
      } else {
        System.out.print(c);
      }
    }
  }

}