import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.next();
    int res = 0;
    Stack<Character> st = new Stack<>();


    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(') {
        st.push('(');
      } else {
        st.pop();
        if (input.charAt(i-1) == '(') {
          res += st.size();
        } else {
          res++;
        }
      }
    }

    System.out.println(res);
  }
}