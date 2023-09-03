import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      String s = sc.next();

      switch (s) {
        case "push":
          int num = sc.nextInt();
          st.add(num);
          break;
        case "pop":
          if (st.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(st.pop()).append("\n");
          }
          break;
        case "top":
          if (st.isEmpty()) {
            sb.append("-1").append("\n");
          } else {
            sb.append(st.peek()).append("\n");
          }
          break;
        case "size":
          sb.append(st.size()).append("\n");
          break;
        case "empty":
          if (st.isEmpty()) {
            sb.append("1").append("\n");
          } else {
            sb.append("0").append("\n");
          }
          break;
        default:
          break;
      }
    }

    System.out.println(sb);
  }
}

