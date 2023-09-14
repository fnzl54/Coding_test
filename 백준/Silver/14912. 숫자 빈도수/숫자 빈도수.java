import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    char d = sc.next().charAt(0);
    int answer = 0;

    for (int i = 1; i <= n; i++) {
      for (char c : String.valueOf(i).toCharArray()) {
        if (c == d) {
          answer++;
        }
      }
    }

    System.out.println(answer);
  }
}
