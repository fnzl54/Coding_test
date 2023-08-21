import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] word = new String[N];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      word[i] = sc.next();
    }

    for (String s : word) {
      sb.append(check(s, 0, 0, s.length()-1));
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static int check(String s, int res, int left_p, int right_p) {

    if (res == 2) {
      return 2;
    } else if(left_p >= right_p) {
      return res;
    } else {
      if (s.charAt(left_p) == s.charAt(right_p)) {
        left_p++;
        right_p--;
        res = check(s, res, left_p, right_p);
      } else {
        res = Math.min(check(s, res+1, left_p+1, right_p), check(s, res+1, left_p, right_p-1));
      }
    }

    return res;
  }
}