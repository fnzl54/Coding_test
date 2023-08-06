import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int answer = 0;

    HashMap<String, Integer> map_one = new HashMap<>();

    for (int i = 0; i < N; i++) {
      map_one.put(sc.next(), 0);
    }

    for (int i = 0; i < M; i++) {
      String input = sc.next();

      if (map_one.containsKey(input)) {
        answer++;
      }
    }

    System.out.println(answer);
  }

}