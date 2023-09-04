import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();
    String s = sc.nextLine();

    while (s.charAt(0) != '.') {

      Stack<Character> st = new Stack<Character>();
      boolean check = true;

      for (char c : s.toCharArray()) {
        if (c == '(' || c == '[') {
          st.add(c);
        } else if (c == ')') {
          if (st.isEmpty() || st.peek() == '[') {
            check = false;
            break;
          } else {
            st.pop();
          }
        } else if (c == ']') {
          if (st.isEmpty() || st.peek() == '(') {
            check = false;
            break;
          } else {
            st.pop();
          }
        }
      }

      if (check && st.isEmpty()) {
          sb.append("yes").append("\n");
      } else {
        sb.append("no").append("\n");
      }

      s = sc.nextLine();
    }

    System.out.println(sb);

  }
}