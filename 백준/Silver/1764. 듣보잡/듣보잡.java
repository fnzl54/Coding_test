import java.util.*;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    HashSet<String> Look = new HashSet<>();
    List<String> answer = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      Look.add(sc.next());
    }

    for (int i = 0; i < M; i++) {
      String temp = sc.next();

      if (Look.contains(temp)) {
        answer.add(temp);
        Look.remove(temp);
      }
    }

    Collections.sort(answer);

    System.out.println(answer.size());
    for (String s : answer) {
      System.out.println(s);
    }
  }
}