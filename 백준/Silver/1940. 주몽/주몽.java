import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int answer = 0;
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < N; i++) {
      set.add(sc.nextInt());
    }

    for (int i : set.toArray(new Integer[0])) {
      if ( set.contains(M - i) ) {
        answer++;
      }
    }

    System.out.println(answer/2);
  }
}
