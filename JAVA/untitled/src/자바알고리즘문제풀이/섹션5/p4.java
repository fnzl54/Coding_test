package 자바알고리즘문제풀이.섹션5;

import java.util.*;

public class p4 {
  public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      Stack<Integer> st = new Stack<>();
      String str = sc.next();
      int a = 0, b = 0;

      for (char c : str.toCharArray()) {

        switch (c) {
          case '+':
            a = st.pop();
            b = st.pop();
            st.add(a+b);
            break;
          case '-':
            a = st.pop();
            b = st.pop();
            st.add(b-a);
            break;
          case '*':
            a = st.pop();
            b = st.pop();
            st.add(a*b);
            break;
          case '/':
            a = st.pop();
            b = st.pop();
            st.add(b/a);
            break;
          default:
            st.add( (int)c - 48 );
            break;
        }

      }

    System.out.println(st.peek());
  }
}