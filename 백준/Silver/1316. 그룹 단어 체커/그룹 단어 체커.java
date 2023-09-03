import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int answer = 0;

    for (int i = 0; i < N; i++) {
        String s = sc.next();
        Set<Character> set = new HashSet<>();
        boolean check = true;
        set.add(s.charAt(0));

        for (int j = 1; j < s.length(); j++) {
          if (s.charAt(j-1) != s.charAt(j)) {
            if (!set.contains(s.charAt(j))) {
              set.add(s.charAt(j));
            } else {
              check = false;
              break;
            }
          }
        }

        if (check) {
          answer++;
        }
    }

    System.out.println(answer);
  }
}
