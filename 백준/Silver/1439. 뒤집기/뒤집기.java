import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int zero = 0;
    int one = 0;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) != s.charAt(i)) {
        if (s.charAt(i - 1) == '0') {
          zero++;
        } else {
          one++;
        }
      }
    }

    System.out.print(Math.max(zero,one));
  }
}