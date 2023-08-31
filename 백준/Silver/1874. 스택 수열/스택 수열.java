import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int max = 0, before_max = 0;
    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean check_p = true;

    for (int i = 0; i < n; i++) {
      int current_num = sc.nextInt();

      if (current_num < max) {
        if (st.pop() == current_num - 1) {
          sb.append("-").append("\n");
        } else {
          check_p = false;
          break;
        }
      } else {
        before_max = max;
        max = current_num;
        for (int j = before_max; j < max; j++) {
          st.push(j);
          sb.append("+").append("\n");
        }
        st.pop();
        sb.append("-").append("\n");

      }
    }

    if (check_p) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }
  }
}
