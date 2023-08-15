import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] words = new String[N];

    for (int i = 0; i < N; i++) {
      words[i] = sc.next();
    }

    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        } else {
          return o1.length() - o2.length();
        }
      }
    });

    String check_before = "";
    for (String s : words) {
      if (!check_before.equals(s)) {
        System.out.println(s);
        check_before = s;
      }
    }
    
  }
}