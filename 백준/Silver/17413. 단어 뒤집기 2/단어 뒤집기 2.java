import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String S = sc.nextLine();
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (char c : S.toCharArray()) {
      if (c == ' ') {
        if (st.get(0) == '<') {
          st.add(c);
        } else {
          int st_size = st.size();
          for (int i = 0; i < st_size; i++) {
            sb.append(st.pop());
            //System.out.print(st.pop());
          }
          sb.append(' ');
          //System.out.print(' ');
        }
      } else if (c == '<') {
        if (!st.isEmpty()) {
          int st_size = st.size();
          for (int i = 0; i < st_size; i++) {
            sb.append(st.pop());
            //System.out.print(st.pop());
          }
          st.add(c);
        } else {
          st.add(c);
        }
      } else if (c == '>') {
        st.add(c);
        for (int i = 0; i < st.size(); i++) {
          sb.append(st.get(i));
          //System.out.print(st.get(i));
        }
        st.clear();
      } else {
        st.add(c);
      }
    }

    if (!st.isEmpty()) {
      int st_size = st.size();
      for (int i = 0; i < st_size; i++) {
        sb.append(st.pop());
        //System.out.print(st.pop());
      }
    }

    System.out.print(sb);
  }
}