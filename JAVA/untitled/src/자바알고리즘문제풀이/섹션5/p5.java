package 자바알고리즘문제풀이.섹션5;

// 3 3 2 3 2 2 1 1

import java.util.*;

public class p5 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Stack<Character> st = new Stack<>();
    String str = sc.next();
    int answer = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        st.add('(');
      } else if (str.charAt(i) == ')' && str.charAt(i-1) == '(') {
        st.pop();
        answer += st.size();
      } else {
        st.pop();
        answer ++;
      }
    }

    System.out.println(answer);
  }

}
