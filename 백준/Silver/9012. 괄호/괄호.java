import java.util.*;

class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();

    for (int i = 0 ;  i < num; i++) {
      String prob = sc.next();
      System.out.println(solve(prob));
    }

  }

  public static String solve(String prob) {
    char[] probList = prob.toCharArray();

    if (probList.length % 2 != 0) {
      return "NO";
    }

    Stack<Character> s = new Stack<>();

    for (char c : probList) {
      if (c == '(') {
        s.add(c);
      } else if (s.isEmpty()) {
        return "NO";
      } else {
        s.pop();
      }
    }

    if (s.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}
